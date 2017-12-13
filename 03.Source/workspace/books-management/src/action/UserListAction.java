package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.UserSearchDto;
import jp.iface.books.action.AbstractAction;
import service.UserService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "user_list", type="tiles")
})
public class UserListAction extends AbstractAction {

	@Autowired
	private UserService userService;

    public UserSearchDto userSearchDto = new UserSearchDto();

    @Action("/user_list")
    public String execute() throws Exception {

        return "success";
    }

    @Action("/user_list/search")
    public String search() throws Exception {

    	userSearchDto.setResults(userService.getUserList(userSearchDto));
        return "success";
    }
}
