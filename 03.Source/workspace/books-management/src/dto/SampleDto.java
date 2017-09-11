package dto;

import java.util.Date;

public class SampleDto {

	private Integer id;
	private String sampleString;
	private Integer sampleInteger;
	private Date sampleDate;
	public String getSampleString() {
		return sampleString;
	}
	public void setSampleString(String sampleString) {
		this.sampleString = sampleString;
	}
	public Integer getSampleInteger() {
		return sampleInteger;
	}
	public void setSampleInteger(Integer sampleInteger) {
		this.sampleInteger = sampleInteger;
	}
	public Date getSampleDate() {
		return sampleDate;
	}
	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
