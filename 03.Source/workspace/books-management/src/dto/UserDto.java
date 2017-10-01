package dto;

import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;

import entity.User;

public class UserDto {

	private Integer id;
	private String name;
	private String password;
	private String confirmationPassword;

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

	@RequiredStringValidator(message="ユーザー名が未入力です" ,shortCircuit=true)
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(message="パスワードが未入力です" ,shortCircuit=true)
	@RegexFieldValidator(message = "パスワードは英数字で入力してください", regexExpression = "\\w{8,}")
	@StringLengthFieldValidator(message = "パスワードは8文字以上で入力してください",
	trim = true, minLength = "8", shortCircuit = true)
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	@RequiredStringValidator(message="パスワード再入力が未入力です" ,shortCircuit=true)
	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}
	public User getUser() {
		User user = new User();
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		return user;
	}
}
