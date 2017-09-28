package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import dto.BookDto;
import entity.Book;
import service.AbstractDBAccessService;
import service.BookService;

@Component
public class BookServiceImpl extends AbstractDBAccessService implements BookService{

	@Override
	public List<BookDto> getBookList() {
		Criteria criteria = super.getCriteria(Book.class);

		//criteria.add(Restrictions.like("name", userList.getUserCriteria(), MatchMode.ANYWHERE));

		@SuppressWarnings("unchecked")
		List<Book> results = (List<Book>)criteria.list();
		BookDto bookDto;
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		for(Book book :results) {

			bookDto = new BookDto(book);
			bookDtoList.add(bookDto);

		}
		return bookDtoList;
	}

	@Override
	public void registBook(BookDto bookDto) {
		super.beginTransaction();
		try {
			super.save(bookDto.getBook());
			super.commit();
		}finally {

			super.close();
		}
	}


}
