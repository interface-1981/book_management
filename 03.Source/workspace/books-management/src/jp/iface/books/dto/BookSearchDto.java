package jp.iface.books.dto;

import java.util.Date;
import java.util.List;



public class BookSearchDto extends AbstractPagerListDto {

	private Date registDateFromCriteria;
	private Date registDateToCriteria;
	private Date modifyDateFromCriteria;
	private Date modifyDateToCriteria;
	private String isbnCriteria;
	private String keywordCriteria;
	private List<BookDto> results;


	public Date getRegistDateFromCriteria() {
		return registDateFromCriteria;
	}
	public void setRegistDateFromCriteria(Date registDateFromCriteria) {
		this.registDateFromCriteria = registDateFromCriteria;
	}
	public Date getRegistDateToCriteria() {
		return registDateToCriteria;
	}
	public void setRegistDateToCriteria(Date registDateToCriteria) {
		this.registDateToCriteria = registDateToCriteria;
	}
	public String getIsbnCriteria() {
		return isbnCriteria;
	}
	public void setIsbnCriteria(String isbnCriteria) {
		this.isbnCriteria = isbnCriteria;
	}
	public String getKeywordCriteria() {
		return keywordCriteria;
	}
	public void setKeywordCriteria(String keywordCriteria) {
		this.keywordCriteria = keywordCriteria;
	}
	public Date getModifyDateFromCriteria() {
		return modifyDateFromCriteria;
	}
	public void setModifyDateFromCriteria(Date modifyDateFromCriteria) {
		this.modifyDateFromCriteria = modifyDateFromCriteria;
	}
	public Date getModifyDateToCriteria() {
		return modifyDateToCriteria;
	}
	public void setModifyDateToCriteria(Date modifyDateToCriteria) {
		this.modifyDateToCriteria = modifyDateToCriteria;
	}

	public List<BookDto> getResults() {
		return results;
	}
	public void setResults(List<BookDto> results) {
		this.results = results;
	}
}
