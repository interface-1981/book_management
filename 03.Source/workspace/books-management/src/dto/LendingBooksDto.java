package dto;

import entity.LendingBooks;

public class LendingBooksDto {

	private Integer id;
	private Integer userId;
	private Integer ownedBooksId;
	private String status;
	private OwnedBooksDto ownedBooksDto;
	private UserDto userDto;

	public LendingBooksDto(LendingBooks lendingBooks) {
		this.setId(lendingBooks.getId());
		this.setOwnedBooksId(lendingBooks.getOwnedBooksId());
		this.setUserId(lendingBooks.getUserId());
		this.setStatus(lendingBooks.getStatus());
		this.setOwnedBooksDto(new OwnedBooksDto(lendingBooks.getOwnedBooks()));
		this.setUserDto(new UserDto(lendingBooks.getUser()));
	}

	public LendingBooksDto() {

	}
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
	public Integer getOwnedBooksId() {
		return ownedBooksId;
	}
	public void setOwnedBooksId(Integer ownedBooksId) {
		this.ownedBooksId = ownedBooksId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OwnedBooksDto getOwnedBooksDto() {
		return ownedBooksDto;
	}
	public void setOwnedBooksDto(OwnedBooksDto ownedBooksDto) {
		this.ownedBooksDto = ownedBooksDto;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}


}
