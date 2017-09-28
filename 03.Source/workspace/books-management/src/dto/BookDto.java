package dto;

import entity.Book;

public class BookDto {

	private Integer id;
	private String title;
	private String author;

	public BookDto(Book book) {
		this.setId(book.getId());
		this.setAuthor(book.getAuthor());
		this.setTitle(book.getTitle());

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
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public Book getBook() {
		Book book = new Book();
		book.setId(this.getId());
		book.setAuthor(this.getAuthor());
		book.setTitle(this.getTitle());
		return book;
	}
}
