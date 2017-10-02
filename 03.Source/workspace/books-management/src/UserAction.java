

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import action.AbstractAction;
import dto.UserDto;
import service.UserService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
	@Result(name = "input", location = "user", type="tiles"),
	@Result(name = "success", location = "user", type="tiles")
})
@Validations(
	    visitorFields = {
	        @VisitorFieldValidator(appendPrefix=true , fieldName="user")
	    }
	)
public class UserAction extends AbstractAction {

	@Autowired
	private UserService userService;

    public UserDto user = new UserDto();

    @Action("/user")
    @SkipValidation
    public String execute() throws Exception {

    	this.user = new UserDto();

        return "success";
    }

    @Action("/user/regist")
    public String regist() throws Exception {

    	this.userService.registUser(this.user);
        return "success";
    }

}
