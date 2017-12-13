package jp.iface.books.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="t_web_api_access_history")
public class WebAPIAccessHistory implements Serializable {

	private Integer webApiAccessHistoryId;
	private String isbn;
	private Integer webApiType;
	private Boolean errorFlag;
	private Date accessDatetime;
	private String responseData;
	private Date registDatetime;
	private String registUser;
	private String message;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="web_api_access_history_id_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	@Column(name="web_api_access_history_id")
	public Integer getWebApiAccessHistoryId() {
		return webApiAccessHistoryId;
	}
	public void setWebApiAccessHistoryId(Integer webApiAccessHistoryId) {
		this.webApiAccessHistoryId = webApiAccessHistoryId;
	}

	@Column(name="isbn")
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Column(name="web_api_type")
	public Integer getWebApiType() {
		return webApiType;
	}
	public void setWebApiType(Integer webApiType) {
		this.webApiType = webApiType;
	}

	@Column(name="error_flag")
	public Boolean getErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(Boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	@Column(name="access_datetime")
	public Date getAccessDatetime() {
		return accessDatetime;
	}
	public void setAccessDatetime(Date accessDatetime) {
		this.accessDatetime = accessDatetime;
	}

	@Column(name="response_data")
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	@Column(name="regist_datetime")
	public Date getRegistDatetime() {
		return registDatetime;
	}
	public void setRegistDatetime(Date registDatetime) {
		this.registDatetime = registDatetime;
	}

	@Column(name="regist_user")
	public String getRegistUser() {
		return registUser;
	}
	public void setRegistUser(String registUser) {
		this.registUser = registUser;
	}
	@Column(name="message")
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

