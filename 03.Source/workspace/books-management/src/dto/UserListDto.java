package dto;

import java.util.List;


public class UserListDto {
	private String userCriteria;
	private List<UserDto> results;


	public String getUserCriteria() {
		return userCriteria;
	}

	public void setUserCriteria(String userCriteria) {
		this.userCriteria = userCriteria;
	}

	public List<UserDto> getResults() {
		return results;
	}

	public void setResults(List<UserDto> userList) {
		this.results = userList;
	}




}
