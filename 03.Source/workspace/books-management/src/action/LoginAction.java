package action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import dto.UserDto;
import jp.iface.books.action.AbstractAction;
import service.UserService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
	@Result(name = "input", location = "login", type="tiles"),
	@Result(name = "success", location = "login", type="tiles")
})
public class LoginAction extends AbstractAction {

	@Autowired
	private UserService userService;

    public UserDto user = new UserDto();

    @Action("/")
    @SkipValidation
    public String execute() throws Exception {

    	this.user = new UserDto();

        return "success";
    }

    @Action("/login")
    public String regist() throws Exception {

    	this.userService.registUser(this.user);
        return "success";
    }

}
