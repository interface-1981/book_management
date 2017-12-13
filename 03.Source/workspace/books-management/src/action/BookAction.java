package action;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import jp.iface.books.dto.BookDto;
import jp.iface.books.service.BookService;
import jp.iface.common.AbstractAction;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
	@Result(name = "input", location = "book", type="tiles"),
	@Result(name = "success", location = "book", type="tiles")
})
@Validations(
	    visitorFields = {
	        @VisitorFieldValidator(appendPrefix=true , fieldName="book")
	    }
	)
public class BookAction extends AbstractAction {

	@Autowired
	private BookService bookService;

    public BookDto bookDto= new BookDto();
    public File imgFile;

    @Action("/book")
    @SkipValidation
    public String execute() throws Exception {

        return "success";
    }

    @Action("/book/regist")
    public String regist() throws Exception {

    	this.bookService.registBook(this.bookDto);
    	super.addActionMessage("登録しました");
        return "success";
    }

    @Action("/book/upload")
    public String upload() throws Exception {

    	String fooPath = BookAction.class.getResource( "BookAction.class" ).toString();
    	char[] data = new char[1024];

    	FileReader fileReader = new FileReader(this.imgFile);
    	FileWriter fileWriter = new FileWriter(new File("D:\\作業フォルダ\\図書管理システム\\03.Source\\workspace\\books-management\\WebContent\\upload\\"+ this.imgFile.getName()));
    	try {
    	while(fileReader.ready()){
    		fileReader.read(data);
    		fileWriter.write(data);
    	}
    	} finally {
    		fileReader.close();
    		fileWriter.close();
    	}

    	return "success";
    }

}
