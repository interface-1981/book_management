package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.BookDto;
import service.BookService;


@Namespace("/")
@ParentPackage(value="json-default")
@Results({
@Result(name="success", type="json", params={"root", "book"})
})
public class GetBookDataAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public Long isbn;
    public BookDto book;

    @Action("/get_book_data")
    public String getSampleList() throws Exception {

    	if (this.isbn != null) {
        	this.book = this.bookService.getBookByISBN(this.isbn);
    	}

        return "success";
    }
}
