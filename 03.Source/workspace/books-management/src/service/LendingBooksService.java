package service;

import java.util.List;

import dto.LendingBooksDto;
import dto.LendingBooksSearchDto;

public interface LendingBooksService  {


	public List<LendingBooksDto> getLendingBooksList() ;

	public List<LendingBooksDto> getLendingBooksList(LendingBooksSearchDto lendingBooksSearchDto) ;

	public void registLendingBooks(LendingBooksDto ownedBooks) ;


}
