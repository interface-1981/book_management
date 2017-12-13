package jp.iface.books.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import jp.iface.books.dto.BookDataResponseDto;
import jp.iface.books.service.BookService;
import jp.iface.common.AbstractAction;


@Namespace("/")
@ParentPackage(value="json-default")
@Results({
@Result(name="success", type="json", params={"root", "response"})
})
public class GetBookDataAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public String isbn;
    public BookDataResponseDto response;

    @Action("/get_book_data")
    public String getBookData() throws Exception {

    	if (this.isbn == null) {
    		this.response.setStatus(BookDataResponseDto.Status.FORMAT_ERROR);
    		return "success";
    	}

		this.response = new BookDataResponseDto();

		//図書マスタから書籍情報を取得
		this.response.setBookData(bookService.getBook(isbn));
		if(this.response.getBookData() != null) {
			this.response.setStatus(BookDataResponseDto.Status.FOUND_MASTER_DB);
			return "success";

		}

		//WebAPIから書籍情報を取得
		this.response.setBookData(bookService.getBookDataFromWebAPI(isbn));
		if (this.response.getBookData() != null) {
			this.response.setStatus(BookDataResponseDto.Status.FOUND_WEBSERVICE);
		} else {
			//該当なし
			this.response.setStatus(BookDataResponseDto.Status.NOTFOUND_WEBSERVICE);
		}
        return "success";
    }
}
