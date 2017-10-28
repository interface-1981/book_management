package dto;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import entity.Book;

public class BookDto {

	private Integer id;
	private String title;
	private String author;
	private String fileImgUrl;
	private Long isbn;


	public BookDto(Book book) {
		this.setId(book.getId());
		this.setAuthor(book.getAuthor());
		this.setTitle(book.getTitle());
		this.setIsbn(book.getIsbn());

	}
	public BookDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}

	@RequiredStringValidator(message="書籍名が未入力です" ,shortCircuit=true)
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}

	@RequiredStringValidator(message="著者が未入力です" , shortCircuit=true)
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileImgUrl() {
		return fileImgUrl;
	}
	public void setFileImgUrl(String fileImgUrl) {
		this.fileImgUrl = fileImgUrl;
	}

	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public Book createBookEntity() {
		Book book = new Book();
		book.setId(this.getId());
		book.setAuthor(this.getAuthor());
		book.setTitle(this.getTitle());
		book.setIsbn(this.getIsbn());
		return book;
	}
}
