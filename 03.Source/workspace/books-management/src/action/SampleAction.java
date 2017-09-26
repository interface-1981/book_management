package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import dto.SampleDto;
import service.SampleService;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "sample", type="tiles")
})
public class SampleAction extends AbstractAction {

	@Autowired
	private SampleService sampleService;

    public List<SampleDto> list = new ArrayList<SampleDto>();

    @Action("/sample")
    public String execute() throws Exception {


    	this.list = new ArrayList<SampleDto>();
    	SampleDto dto = new SampleDto();

    	dto.setSampleString("AAA");
    	dto.setSampleInteger(1);
    	dto.setSampleDate(new Date());
    	this.list.add(dto);

    	dto = new SampleDto();

    	dto.setSampleString("BBB");
    	dto.setSampleInteger(2);
    	dto.setSampleDate(new Date());
    	this.list.add(dto);

        return "success";
    }

    @Action("/sample/regist")
    public String regist() throws Exception {

    	this.sampleService.save(this.list);
        return "success";
    }
    @Action("/sample/list")
    public String getSampleList() throws Exception {

    	this.list = this.sampleService.getSampleDtoList();
    	if(this.list == null || this.list.size() == 0) {

    		return this.execute();
    	}
        return "success";
    }
}
