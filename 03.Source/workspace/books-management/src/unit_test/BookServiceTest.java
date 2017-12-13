package unit_test;

import jp.iface.books.dto.BookDto;
import jp.iface.books.webapi.impl.GoogleBookApiClient;

public class BookServiceTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>test";
		s = s.replace("<?xml[.]*?>", "");
		//NDLBookApi api = new NDLBookApi();
		GoogleBookApiClient api = new GoogleBookApiClient();
		BookDto b = api.getBookData("9784062778305");
		b.getAuthor();
	}

}
