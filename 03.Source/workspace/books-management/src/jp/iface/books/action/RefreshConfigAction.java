package jp.iface.books.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import jp.iface.common.AbstractAction;
import jp.iface.common.Configuration;


@Namespace("/")
@ParentPackage("tiles-default")
@Results({
@Result(name = "success", location = "refresh", type="tiles")
})
public class RefreshConfigAction extends AbstractAction {

    @Action("/refresh")
    /**
     * 定義内容の変更を反映する
     *
     * @return 処理結果
     * @throws Exception
     */
    public String refresh() throws Exception {
    	Configuration.refresh();

        return "success";
    }

}
