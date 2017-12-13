package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.LendingBooksSearchDto;
import jp.iface.books.action.AbstractAction;
import service.LendingBooksService;

@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "lending_books_list", type="tiles")
})
public class LendingBooksListAction extends AbstractAction {

	@Autowired
	private LendingBooksService lendingBooksService;

    public LendingBooksSearchDto lendingBooksSearchDto = new LendingBooksSearchDto();

    @Action("/lending_books_list")
    public String execute() throws Exception {

        return "success";
    }

    @Action("/lending_books_list/search")
    public String search() throws Exception {

    	lendingBooksSearchDto.setResults(lendingBooksService.getLendingBooksList(this.lendingBooksSearchDto));
        return "success";
    }
}
