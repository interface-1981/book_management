package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.OwnedBooksLSearchDto;
import jp.iface.books.action.AbstractAction;
import service.OwnedBooksService;

@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "owned_books_list", type="tiles")
})
public class OwnedBooksListAction extends AbstractAction {

	@Autowired
	private OwnedBooksService ownedBooksService;

    public OwnedBooksLSearchDto ownedBooksSearchDto = new OwnedBooksLSearchDto();

    @Action("/owned_books_list")
    public String execute() throws Exception {

        return "success";
    }

    @Action("/owned_books_list/search")
    public String search() throws Exception {

    	ownedBooksSearchDto.setResults(ownedBooksService.getOwnedBooksList(this.ownedBooksSearchDto));
        return "success";
    }
}
