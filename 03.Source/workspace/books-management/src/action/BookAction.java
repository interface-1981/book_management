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
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "book", type="tiles")
})
public class BookAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public BookDto book = new BookDto();

    @Action("/book")
    public String execute() throws Exception {

    	this.book = new BookDto();

        return "success";
    }

    @Action("/book/regist")
    public String regist() throws Exception {

    	this.bookService.registBook(this.book);
        return "success";
    }

}
