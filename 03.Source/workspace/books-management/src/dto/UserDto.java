package dto;

import entity.User;

public class UserDto {

	private Integer id;
	private String name;
	private String password;

	public UserDto(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
	}
	public UserDto() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		User user = new User();
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		return user;
	}
}
