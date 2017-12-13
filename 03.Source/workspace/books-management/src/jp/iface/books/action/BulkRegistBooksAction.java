package jp.iface.books.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import jp.iface.books.dto.BookDto;
import jp.iface.books.service.BookService;

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
    /**
     *
     * @return
     * @throws Exception
     */
    public String initView() throws Exception {

    	//一括登録リストの初期化
    	this.list = createBookList();
        return "success";
    }

    @Action("/bulk_regist_books/regist")
    /**
     *
     * @return
     * @throws Exception
     */
    public String regist() throws Exception {
    	//ローカル変数の定義
    	boolean isError = false;
    	List<BookDto> registList = new ArrayList<BookDto>();

    	//入力データチェック
		for(BookDto bookDto : this.list) {
			//初回レコード、削除レコード以外をチェックし登録対象リストへ追加
			if (bookDto.getIsbn() != null && bookDto.getIsbn().length() == 13) {

				if(bookService.getBook(bookDto.getIsbn()) != null) {
			    	super.addActionError("既に登録済みの書籍です ISBN:["+ bookDto.getIsbn() + "]");
			    	bookDto.setStyle("color:RED;");
			    	isError = true;
				}
				registList.add(bookDto);
			}
		}
		if (registList.size() == 0) {
			super.addActionError("登録対象がありません");
			isError = true;
		}
		//登録処理
		if (!isError) {
			//サムネイル画像のURLからバイナリデータ（Base64フォーマット）を取得
			for(BookDto bookDto : registList) {
				bookDto.setThumbnailImage("data:image/jpeg;base64,"
						+ super.util.getImageBase64(bookDto.getFileImgUrl()));
			}
			//一括登録の実行
	    	this.bookService.bulkRegistBook(registList);
	    	super.addActionMessage("一括登録が完了しました");

		}

		//一括登録リストの初期化
    	this.list=createBookList();
    	//一括登録リストに登録対象を追加
    	this.list.addAll(registList);
        return "success";
    }

    private List<BookDto> createBookList() {
    	List<BookDto> list = new ArrayList<BookDto>();
    	//初回レコード（クライアント側のフォーム複製で使用するためのレコード）の作成
    	list.add(new BookDto());
    	list.get(0).setStyle("display:none;");
    	return list;
    }
}
