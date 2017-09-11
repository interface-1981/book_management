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
@Table(name="\"Sample\"")
public class Sample implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer id;
	private String sampleString;
	private Integer sampleInteger;
	private Date sampleDate;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="\"sampleString\"")
	public String getSampleString() {
		return sampleString;
	}
	public void setSampleString(String sampleString) {
		this.sampleString = sampleString;
	}

	@Column(name="\"sampleInteger\"")
	public Integer getSampleInteger() {
		return sampleInteger;
	}
	public void setSampleInteger(Integer sampleInteger) {
		this.sampleInteger = sampleInteger;
	}

	@Column(name="\"sampleDate\"")
	public Date getSampleDate() {
		return sampleDate;
	}
	public void setSampleDate(Date sampleDate) {
		this.sampleDate = sampleDate;
	}

}

