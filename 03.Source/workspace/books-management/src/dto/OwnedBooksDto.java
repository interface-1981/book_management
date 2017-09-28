package dto;

public class OwnedBooksDto {

	private Integer id;
	private Integer userId;
	private Integer bookId;
	private BookDto bookDto;
	private UserDto userDto;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public BookDto getBook() {
		return bookDto;
	}
	public void setBook(BookDto bookDto) {
		this.bookDto = bookDto;
	}
	public UserDto getUser() {
		return userDto;
	}
	public void setUser(UserDto userDto) {
		this.userDto = userDto;
	}



}
