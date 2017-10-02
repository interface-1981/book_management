package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.LendingBooksDto;
import dto.OwnedBooksDto;
import dto.UserDto;
import service.LendingBooksService;
import service.OwnedBooksService;
import service.UserService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "lending_books", type="tiles")
})
public class LendingBooksAction extends AbstractAction {

	@Autowired
	private UserService userService;
	@Autowired
	private OwnedBooksService ownedBooksService;
	@Autowired
	private LendingBooksService lendingBooksService;

	public LendingBooksDto lendingBooksDto;

	private UserDto[] userList;
	private OwnedBooksDto[] ownedBooksList;
	private String[] statusList;
	public Integer userId;
	public Integer ownedBooksId;
	public String status;


    public UserDto user = new UserDto();

    private void initialize() {
    	this.ownedBooksList = this.ownedBooksService.getOwnedBooksList().toArray(new OwnedBooksDto[0]);
    	this.userList = this.userService.getUserList().toArray(new UserDto[0]);

    	this.statusList = new String[3];
    	this.statusList[0] = "貸出可能";
    	this.statusList[1] = "貸出中";
    	this.statusList[2] ="返却中";

    }
    @Action("/lending_books")
    public String execute() throws Exception {

    	this.lendingBooksDto = new LendingBooksDto();
    	this.initialize();
        return "success";
    }

    @Action("/lending_books/regist")
    public String regist() throws Exception {

    	this.lendingBooksDto = new LendingBooksDto();
    	this.lendingBooksDto.setOwnedBooksId(this.ownedBooksId);
    	this.lendingBooksDto.setUserId(this.userId);
    	this.lendingBooksDto.setStatus(this.status);
    	this.lendingBooksService.registLendingBooks(this.lendingBooksDto);
    	this.initialize();
        return "success";
    }

	public UserDto[] getUserList() {
		return userList;
	}
	public OwnedBooksDto[] getOwnedBooksList() {
		return ownedBooksList;
	}
	public String[] getStatusList() {
		return statusList;
	}


}
