package dto;

import java.util.List;


public class UserSearchDto {
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

	public void setResults(List<UserDto> results) {
		this.results = results;
	}




}
