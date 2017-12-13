package jp.iface.books.webapi;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import jp.iface.books.dto.BookDto;
import jp.iface.books.entity.WebAPIAccessHistory;
import jp.iface.common.AbstractDBAccessComponent;

public abstract class BookApiClient extends AbstractDBAccessComponent{

	private int webApiType;
	private String webApiUrl;


	abstract public BookDto getBookData(String isbn);

	protected String requestWebApi(String isbn) {
		Charset charset = StandardCharsets.UTF_8;

		WebAPIAccessHistory webAPIAccessHistory = getWebAPIAccessHistory(isbn);
		if (webAPIAccessHistory != null) {
			return webAPIAccessHistory.getResponseData();
		}

		String responseData = null;
		try {

			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet request = new HttpGet(webApiUrl.replace(C_REPLACEMENT_ISBN,isbn));

			CloseableHttpResponse response = null;

			response = httpclient.execute(request);

			int status = response.getStatusLine().getStatusCode();

			System.out.println("HTTPステータス:" + status);

			//HTTPステータス:200
			if (status == HttpStatus.SC_OK){
				responseData =
				EntityUtils.toString(response.getEntity(),charset);
				registWebAPIAccessHistory(isbn, false, responseData, "");
			} else {
				registWebAPIAccessHistory(isbn, true, responseData, "StatusCode:" + status);
			}
		} catch (Exception e) {
			registWebAPIAccessHistory(isbn, true, responseData, e.getMessage());
		}

		return responseData;
	}
	protected void registWebAPIAccessHistory(String isbn, boolean errorFlag, String responseData, String message) {

		super.beginTransaction();
		try {
			WebAPIAccessHistory webAPIAccessHistory = new WebAPIAccessHistory();

			webAPIAccessHistory.setAccessDatetime(new Date());
			webAPIAccessHistory.setWebApiType(this.webApiType);
			webAPIAccessHistory.setIsbn(isbn);
			webAPIAccessHistory.setErrorFlag(errorFlag);
			webAPIAccessHistory.setResponseData(responseData);
			webAPIAccessHistory.setRegistDatetime(new Date());
			webAPIAccessHistory.setRegistUser("system");
			webAPIAccessHistory.setMessage(message);
			super.save(webAPIAccessHistory);
			super.commit();
		}finally {

			super.close();
		}
	}


	protected WebAPIAccessHistory getWebAPIAccessHistory(String isbn) {

		Criteria criteria = super.getCriteria(WebAPIAccessHistory.class);

		criteria.add(Restrictions.eq("isbn", isbn));
		criteria.add(Restrictions.eq("webApiType", this.webApiType));
		criteria.add(Restrictions.eq("errorFlag", false));


		@SuppressWarnings("unchecked")
		List<WebAPIAccessHistory> results = (List<WebAPIAccessHistory>)criteria.list();

		if (results.size() > 0) {
			return results.get(0);
		} else {
			return null;
		}

	}

	public int getWebApiType() {
		return webApiType;
	}

	public void setWebApiType(int webApiType) {
		this.webApiType = webApiType;
	}

	public String getWebApiUrl() {
		return webApiUrl;
	}

	public void setWebApiUrl(String webApiUrl) {
		this.webApiUrl = webApiUrl;
	}

}
