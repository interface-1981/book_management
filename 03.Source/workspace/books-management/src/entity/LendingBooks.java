package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="\"LendingBooks\"")
public class LendingBooks implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer ownedBooksId;
	private Integer userId;
	private String status;
	private OwnedBooks ownedBooks;
	private User user;

	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="sample_sequence", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="pk_sequence")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="\"ownedBooksId\"")
	public Integer getOwnedBooksId() {
		return ownedBooksId;
	}
	public void setOwnedBooksId(Integer ownedBooksId) {
		this.ownedBooksId = ownedBooksId;
	}

	@Column(name="\"userId\"")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="\"status\"")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "\"ownedBooksId\"", referencedColumnName = "\"id\"", updatable = false, insertable = false)
	public OwnedBooks getOwnedBooks() {
		return ownedBooks;
	}
	public void setOwnedBooks(OwnedBooks ownedBooks) {
		this.ownedBooks = ownedBooks;
	}
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name = "\"userId\"", referencedColumnName = "\"id\"", updatable = false, insertable = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



}

