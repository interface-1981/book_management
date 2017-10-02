package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.BookSearchDto;
import service.BookService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "book_list", type="tiles")
})
public class BookListAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public BookSearchDto bookSearchDto = new BookSearchDto();

    @Action("/book_list")
    public String execute() throws Exception {

        return "success";
    }

    @Action("/book_list/search")
    public String search() throws Exception {

    	bookSearchDto.setResults(bookService.getBookList(bookSearchDto));
        return "success";
    }
}
