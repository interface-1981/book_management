package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.UserDto;
import service.SampleService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "user", type="tiles")
})
public class UserAction extends AbstractAction {

	@Autowired
	private SampleService sampleService;

    public UserDto user = new UserDto();

    @Action("/user")
    public String execute() throws Exception {

    	this.user = new UserDto();

        return "success";
    }

    @Action("/user/regist")
    public String regist() throws Exception {

    	this.sampleService.registUser(this.user);
        return "success";
    }

}
