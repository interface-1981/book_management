package unit_test;

import dto.BookDto;
import service.BookService;
import service.impl.BookServiceImpl;

public class BookServiceTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		BookService service = new BookServiceImpl();
		long isbn = 9784822282288L;
		//long isbn = 9784822282000L;
		BookDto b = service.getBookByISBN(isbn);
		service.registBook(b);
	}

}
