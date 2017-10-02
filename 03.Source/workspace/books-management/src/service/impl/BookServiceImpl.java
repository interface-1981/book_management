package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dto.BookDto;
import dto.BookSearchDto;
import entity.Book;
import service.AbstractDBAccessService;
import service.BookService;

@Component
public class BookServiceImpl extends AbstractDBAccessService implements BookService{

	@Override
	public List<BookDto> getBookList() {
		//return null;
		return getBookList(null);
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

	@Override
	public List<BookDto> getBookList(BookSearchDto bookSearchDto) {
		Criteria criteria = super.getCriteria(Book.class);

		//criteria.add(Restrictions.like("name", userList.getUserCriteria(), MatchMode.ANYWHERE));
		if(bookSearchDto != null) {
			criteria.add(Restrictions.like("title", bookSearchDto.getTitleCriteria(), MatchMode.ANYWHERE));
			criteria.add(Restrictions.like("author", bookSearchDto.getAuthorCriteria(), MatchMode.ANYWHERE));
		}
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


}
