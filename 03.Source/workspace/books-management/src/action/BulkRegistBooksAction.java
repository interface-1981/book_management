package action;

import java.util.ArrayList;
import java.util.List;

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
@Result(name = "success", location = "bulk_regist_books", type="tiles")
})
public class BulkRegistBooksAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public List<BookDto> list = new ArrayList<BookDto>();

    @Action("/bulk_regist_books")
    public String execute() throws Exception {


    	this.list = new ArrayList<BookDto>();
    	BookDto dto = new BookDto();

    	this.list.add(dto);

        return "success";
    }

    @Action("/bulk_regist_books/regist")
    public String regist() throws Exception {

    	this.bookService.bulkRegistBook(this.list);
        return "success";
    }
}
