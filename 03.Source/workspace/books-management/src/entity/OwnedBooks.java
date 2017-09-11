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
@Table(name="\"OwnedBooks\"")
public class OwnedBooks implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer userId;
	private Integer bookId;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="\"userId\"")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Column(name="\"bookId\"")
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}



}

