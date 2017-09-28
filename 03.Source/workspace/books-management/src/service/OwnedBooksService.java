package service;

import java.util.List;

import dto.OwnedBooksDto;
import dto.OwnedBooksListDto;

public interface OwnedBooksService  {


	public List<OwnedBooksDto> getOwnedBooksList(OwnedBooksListDto userList) ;
	public List<OwnedBooksDto> getOwnedBooksList() ;

	public void registOwnedBooks(OwnedBooksDto ownedBooks) ;


}
