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
import jp.iface.books.service.BookService;
import jp.iface.books.webapi.BookApiClient;
import jp.iface.books.webapi.impl.GoogleBookApiClient;
import jp.iface.books.webapi.impl.NDLBookApiClient;
import jp.iface.common.AbstractDBAccessComponent;

@Component
@Scope("prototype")
public class BookServiceImpl extends AbstractDBAccessComponent implements BookService{

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

			//抽出条件：登録日
			if (bookSearchDto.getRegistDateFromCriteria() != null && bookSearchDto.getRegistDateToCriteria() != null) {
				criteria.add(Restrictions.between("registDatetime", bookSearchDto.getRegistDateFromCriteria(), bookSearchDto.getRegistDateToCriteria()));
			}else if (bookSearchDto.getRegistDateFromCriteria() != null ) {
				criteria.add(Restrictions.ge("registDatetime", bookSearchDto.getRegistDateFromCriteria()));
			}else if (bookSearchDto.getRegistDateToCriteria() != null) {
				criteria.add(Restrictions.le("registDatetime", bookSearchDto.getRegistDateToCriteria()));
			}

			//抽出条件：更新日
			if (bookSearchDto.getModifyDateFromCriteria() != null && bookSearchDto.getModifyDateToCriteria() != null) {
				criteria.add(Restrictions.between("modifyDatetime", bookSearchDto.getModifyDateFromCriteria(), bookSearchDto.getModifyDateToCriteria()));
			}else if (bookSearchDto.getModifyDateFromCriteria() != null ) {
				criteria.add(Restrictions.ge("modifyDatetime", bookSearchDto.getModifyDateFromCriteria()));
			}else if (bookSearchDto.getModifyDateToCriteria() != null) {
				criteria.add(Restrictions.le("modifyDatetime", bookSearchDto.getModifyDateToCriteria()));
			}

			//抽出条件：ISBN
			if (bookSearchDto.getIsbnCriteria() != null && !bookSearchDto.getIsbnCriteria().equals("")) {
				criteria.add(Restrictions.like("isbn", bookSearchDto.getIsbnCriteria()));

			}

			//抽出条件：キーワード（タイトル、著者、説明文を対象）
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
					//登録者、登録日を設定
					book.setRegistUser("System");
					book.setRegistDatetime(new Date());
					//更新者、更新日を設定
					book.setModifyUser("System");
					book.setModifyDatetime(new Date());
					//削除フラグにFalseを設定
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

		BookApiClient api = new GoogleBookApiClient();
		bookDto = api.getBookData(isbn);

		if (bookDto == null) {
			api = new NDLBookApiClient();
			return api.getBookData(isbn);
		} else {
			api = new NDLBookApiClient();
			BookDto bookDtoWk =  api.getBookData(isbn);
			if (bookDtoWk != null) {
				//著者
				if (util.isEmpty(bookDto.getAuthor())) {
					bookDto.setAuthor(bookDtoWk.getAuthor());
				}
				//タイトル
				if (util.isEmpty(bookDto.getTitle())) {
					bookDto.setTitle(bookDtoWk.getTitle());
				}
				//巻
				if (util.isEmpty(bookDto.getVolume())) {
					bookDto.setVolume(bookDtoWk.getVolume());
				}
				//出版社
				if (util.isEmpty(bookDto.getPublisher())) {
					bookDto.setPublisher(bookDtoWk.getPublisher());
				}
				//出版日
				if (bookDto.getPublicationDate() == null) {
					bookDto.setPublicationDate(bookDtoWk.getPublicationDate());
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
