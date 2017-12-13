package jp.iface.books.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import jp.iface.books.dto.BookSearchDto;
import jp.iface.books.service.BookService;
import jp.iface.common.AbstractAction;
import jp.iface.common.Configuration;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "book_list", type="tiles")
})
public class BookSearchAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public BookSearchDto bookSearchDto = new BookSearchDto();

    @Action("/book_list")
    /**
     * 図書検索画面の初期表示を行う
     *
     * @return 処理結果
     * @throws Exception
     */
    public String initView() throws Exception {
    	bookSearchDto.setPageDisplayCount(Configuration.getValueInt(P_PAGE_DISPLAY_COUNT));
    	bookSearchDto.pageInit();

        return "success";
    }

    @Action("/book_list/search")
    /**
     * 図書検索画面の検索処理を行う
     *
     * @return 処理結果
     * @throws Exception
     */
    public String search() throws Exception {

    	bookSearchDto.setResults(bookService.getBookList(bookSearchDto));
        return "success";
    }
}
