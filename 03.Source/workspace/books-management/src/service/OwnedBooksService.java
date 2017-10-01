package service;

import java.util.List;

import dto.OwnedBooksDto;
import dto.OwnedBooksLSearchDto;

public interface OwnedBooksService  {


	public List<OwnedBooksDto> getOwnedBooksList(OwnedBooksLSearchDto userList) ;
	public List<OwnedBooksDto> getOwnedBooksList() ;

	public void registOwnedBooks(OwnedBooksDto ownedBooks) ;


}
