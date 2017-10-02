package service;

import java.util.List;

import dto.BookDto;
import dto.BookSearchDto;

public interface BookService  {


	public List<BookDto> getBookList() ;
	public List<BookDto> getBookList(BookSearchDto bookSearchDto) ;

	public void registBook(BookDto bookDto) ;

}
