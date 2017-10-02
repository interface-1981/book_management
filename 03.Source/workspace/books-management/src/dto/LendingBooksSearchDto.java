package dto;

import java.util.List;


public class LendingBooksSearchDto {
	private String lendingSrcUserCriteria;
	private String lendingDestUserCriteria;

	private List<LendingBooksDto> results;

	public String getLendingSrcUserCriteria() {
		return lendingSrcUserCriteria;
	}

	public void setLendingSrcUserCriteria(String lendingSrcUserCriteria) {
		this.lendingSrcUserCriteria = lendingSrcUserCriteria;
	}

	public String getLendingDestUserCriteria() {
		return lendingDestUserCriteria;
	}

	public void setLendingDestUserCriteria(String lendingDestUserCriteria) {
		this.lendingDestUserCriteria = lendingDestUserCriteria;
	}

	public List<LendingBooksDto> getResults() {
		return results;
	}

	public void setResults(List<LendingBooksDto> results) {
		this.results = results;
	}


}
