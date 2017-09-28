package service;

import java.util.List;

import dto.BookDto;

public interface BookService  {


	public List<BookDto> getBookList() ;

	public void registBook(BookDto bookDto) ;


}
