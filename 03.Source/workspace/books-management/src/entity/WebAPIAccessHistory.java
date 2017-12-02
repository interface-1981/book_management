package entity;

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
	private Long isbn;
	private Integer webApiType;
	private Integer status;
	private Date accessDatetime;
	private String responseData;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	@Column(name="web_api_access_history_id")
	public Integer getWebApiAccessHistoryId() {
		return webApiAccessHistoryId;
	}
	public void setWebApiAccessHistoryId(Integer webApiAccessHistoryId) {
		this.webApiAccessHistoryId = webApiAccessHistoryId;
	}

	@Column(name="isbn")
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}

	@Column(name="web_api_type")
	public Integer getWebApiType() {
		return webApiType;
	}
	public void setWebApiType(Integer webApiType) {
		this.webApiType = webApiType;
	}

	@Column(name="status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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

}

