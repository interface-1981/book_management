package dto;

import java.util.List;


public class OwnedBooksLSearchDto {
	private String userCriteria;
	private String bookCriteria;
	private List<OwnedBooksDto> results;


	public String getUserCriteria() {
		return userCriteria;
	}

	public void setUserCriteria(String userCriteria) {
		this.userCriteria = userCriteria;
	}

	public String getBookCriteria() {
		return bookCriteria;
	}

	public void setBookCriteria(String bookCriteria) {
		this.bookCriteria = bookCriteria;
	}

	public List<OwnedBooksDto> getResults() {
		return results;
	}

	public void setResults(List<OwnedBooksDto> results) {
		this.results = results;
	}




}
