package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.BookDto;
import dto.OwnedBooksDto;
import dto.UserDto;
import service.BookService;
import service.OwnedBooksService;
import service.UserService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "owned_books", type="tiles")
})
public class OwnedBooksAction extends AbstractAction {

	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@Autowired
	private OwnedBooksService ownedBooksService;

	public OwnedBooksDto ownedbooks;
	private UserDto[] userList;
	private BookDto[] bookList;

	public Integer userId;
	public Integer bookId;


    public UserDto user = new UserDto();

    private void initialize() {
    	this.bookList = this.bookService.getBookList().toArray(new BookDto[0]);
    	this.userList = this.userService.getUserList().toArray(new UserDto[0]);
    	this.bookId = this.ownedbooks.getBookId();
    	this.userId = this.ownedbooks.getUserId();

    }
    @Action("/owned_books")
    public String execute() throws Exception {

    	this.ownedbooks = new OwnedBooksDto();
    	this.initialize();
        return "success";
    }

    @Action("/owned_books/regist")
    public String regist() throws Exception {

    	this.ownedbooks = new OwnedBooksDto();
    	this.ownedbooks.setBookId(bookId);
    	this.ownedbooks.setUserId(userId);
    	this.ownedBooksService.registOwnedBooks(this.ownedbooks);
    	this.initialize();
        return "success";
    }

	public UserDto[] getUserList() {
		return userList;
	}

	public BookDto[] getBookList() {
		return bookList;
	}

}
