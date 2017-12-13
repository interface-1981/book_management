package jp.iface.books.dto;

import java.util.Date;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

import jp.iface.books.entity.Book;
import jp.iface.common.CommonUtil;


public class BookDto {

	private CommonUtil util = new CommonUtil();

	private Integer bookId;
	private String title;
	private String volume;
	private String author;
	private String fileImgUrl;
	private String isbn;
	private String publisher;
	private Date publicationDate;
	private Integer pageCount;
	private String contents;
	private String thumbnailImage;
	private Date registDate;
	private Date modifyDate;
	private String style;

	public BookDto(Book book) {
		this.setBookId(book.getBookId());
		this.setAuthor(book.getAuthor());
		this.setTitle(book.getTitle());
		this.setVolume(book.getVolume());
		this.setIsbn(book.getIsbn());
		this.setPublisher(book.getPublisher());
		this.setPublicationDate(book.getPublicationDate());
		this.setPageCount(book.getPageCount());
		this.setContents(book.getContents());
		this.setThumbnailImage(book.getThumbnailImage());
		this.setRegistDate(book.getRegistDatetime());
		this.setModifyDate(book.getModifyDatetime());

	}
	public BookDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
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

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getPublicationDateStr() {
		return util.toStringDate(publicationDate);
	}

	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Book createBookEntity() {
		Book book = new Book();
		book.setBookId(this.getBookId());
		book.setAuthor(this.getAuthor());
		book.setTitle(this.getTitle());
		book.setVolume(this.getVolume());
		book.setIsbn(this.getIsbn());
		book.setPublisher(this.getPublisher());
		book.setPublicationDate(this.getPublicationDate());
		book.setPageCount(this.getPageCount());
		book.setContents(this.getContents());
		book.setThumbnailImage(this.getThumbnailImage());
		return book;
	}
}
