package jp.iface.books.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.iface.books.dto.BookDto;
import jp.iface.books.dto.BookSearchDto;
import jp.iface.books.entity.Book;
import jp.iface.books.service.AbstractDBAccessService;
import jp.iface.books.service.BookApi;
import jp.iface.books.service.BookService;

@Component
@Scope("prototype")
public class BookServiceImpl extends AbstractDBAccessService implements BookService{

	@Override
	public void registBook(BookDto bookDto) {
		super.beginTransaction();
		try {
			super.save(bookDto.createBookEntity());
			super.commit();
		}finally {

			super.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookDto> getBookList(BookSearchDto bookSearchDto) {

		long recordCount = (long) getBookSearchCriteria(bookSearchDto).setProjection(Projections.rowCount()).uniqueResult();

		Criteria criteria = getBookSearchCriteria(bookSearchDto);
		super.setPagerCriteria(criteria, recordCount, bookSearchDto);
		List<Book> results = (List<Book>)criteria.list();

		BookDto bookDto;
		List<BookDto> bookDtoList = new ArrayList<BookDto>();
		for(Book book :results) {

			bookDto = new BookDto(book);
			bookDtoList.add(bookDto);

		}
		return bookDtoList;
	}

	private Criteria getBookSearchCriteria(BookSearchDto bookSearchDto) {

		Criteria criteria = super.getCriteria(Book.class);


		if(bookSearchDto != null) {

			if (bookSearchDto.getRegistDateFromCriteria() != null && bookSearchDto.getRegistDateToCriteria() != null) {
				criteria.add(Restrictions.between("registDatetime", bookSearchDto.getRegistDateFromCriteria(), bookSearchDto.getRegistDateToCriteria()));
			}else if (bookSearchDto.getRegistDateFromCriteria() != null ) {
				criteria.add(Restrictions.ge("registDatetime", bookSearchDto.getRegistDateFromCriteria()));
			}else if (bookSearchDto.getRegistDateToCriteria() != null) {
				criteria.add(Restrictions.le("registDatetime", bookSearchDto.getRegistDateToCriteria()));
			}

			if (bookSearchDto.getModifyDateFromCriteria() != null && bookSearchDto.getModifyDateToCriteria() != null) {
				criteria.add(Restrictions.between("modifyDatetime", bookSearchDto.getModifyDateFromCriteria(), bookSearchDto.getModifyDateToCriteria()));
			}else if (bookSearchDto.getModifyDateFromCriteria() != null ) {
				criteria.add(Restrictions.ge("modifyDatetime", bookSearchDto.getModifyDateFromCriteria()));
			}else if (bookSearchDto.getModifyDateToCriteria() != null) {
				criteria.add(Restrictions.le("modifyDatetime", bookSearchDto.getModifyDateToCriteria()));
			}

			if (bookSearchDto.getIsbnCriteria() != null && !bookSearchDto.getIsbnCriteria().equals("")) {
				criteria.add(Restrictions.eq("isbn", bookSearchDto.getIsbnCriteria()));

			}

			if (bookSearchDto.getKeywordCriteria() != null && !bookSearchDto.getKeywordCriteria().equals("")) {
				criteria.add(Restrictions.or(
						Restrictions.like("title", bookSearchDto.getKeywordCriteria(), MatchMode.ANYWHERE),
						Restrictions.like("author", bookSearchDto.getKeywordCriteria(), MatchMode.ANYWHERE),
						Restrictions.like("contents", bookSearchDto.getKeywordCriteria(), MatchMode.ANYWHERE)

						));
			}
		}
		return criteria;
	}

	@Override
	public void bulkRegistBook(List<BookDto> bookDtoList) {
		super.beginTransaction();
		try {
			for(BookDto bookDto : bookDtoList) {
				if (bookDto.getIsbn() != null && bookDto.getIsbn().length() == 13) {
					Book book = bookDto.createBookEntity();
					book.setRegistUser("System");
					book.setRegistDatetime(new Date());
					book.setModifyUser("System");
					book.setModifyDatetime(new Date());
					book.setDeleteFlag(false);

					super.save(book);
				}
			}
			super.commit();
		}finally {

			super.close();
		}

	}

	@Override
	public BookDto getBookDataFromWebAPI(String isbn) {

		BookDto bookDto = null;

		BookApi api = new GoogleBookApi();
		bookDto = api.getBookData(isbn);

		if (bookDto == null) {
			api = new NDLBookApi();
			return api.getBookData(isbn);
		} else {
			api = new NDLBookApi();
			BookDto bookDtoWk =  api.getBookData(isbn);
			if (bookDtoWk != null) {
				if (util.isEmpty(bookDto.getAuthor())) {
					bookDto.setAuthor(bookDtoWk.getAuthor());
				}

				if (util.isEmpty(bookDto.getPublisher())) {
					bookDto.setPublisher(bookDtoWk.getPublisher());
				}

				if (bookDto.getPublicationDate() == null) {
					bookDto.setPublicationDate(bookDtoWk.getPublicationDate());
				}

				if (util.isEmpty(bookDto.getTitle())) {
					bookDto.setTitle(bookDtoWk.getTitle());
				}

				if (util.isEmpty(bookDto.getVolume())) {
					bookDto.setVolume(bookDtoWk.getVolume());
				}
			}

		}

		return bookDto;
	}


	@Override
	public BookDto getBook(String isbn) {
		BookSearchDto bookSearchDto = new BookSearchDto();
		bookSearchDto.setIsbnCriteria(isbn);
		List<BookDto> bookList= getBookList(bookSearchDto);
		if (bookList.size() > 0 ) {
			return bookList.get(0);
		}else {
			return null;
		}
	}

}
