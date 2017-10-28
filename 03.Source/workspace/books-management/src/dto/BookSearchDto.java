package dto;

import java.util.List;


public class BookSearchDto {

	private Long isbnCriteria;
	private String titleCriteria;
	private String authorCriteria;
	private List<BookDto> results;

	public Long getIsbnCriteria() {
		return isbnCriteria;
	}
	public void setIsbnCriteria(Long isbnCriteria) {
		this.isbnCriteria = isbnCriteria;
	}
	public String getTitleCriteria() {
		return titleCriteria;
	}
	public void setTitleCriteria(String titleCriteria) {
		this.titleCriteria = titleCriteria;
	}
	public String getAuthorCriteria() {
		return authorCriteria;
	}
	public void setAuthorCriteria(String authorCriteria) {
		this.authorCriteria = authorCriteria;
	}
	public List<BookDto> getResults() {
		return results;
	}
	public void setResults(List<BookDto> results) {
		this.results = results;
	}


}
