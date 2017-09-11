package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="\"Book\"")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	private Integer author;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="\"title\"")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Column(name="\"author\"")
	public Integer getAuthor() {
		return author;
	}
	public void setAuthor(Integer author) {
		this.author = author;
	}

}

