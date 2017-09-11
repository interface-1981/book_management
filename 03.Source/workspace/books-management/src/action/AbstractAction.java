package action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AbstractAction extends ActionSupport implements ServletResponseAware,SessionAware, Action {

    private static final long serialVersionUID = 1L;

    public HttpServletResponse response;

    public Map sessionMap;

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSession(Map sessionMap) {
        this.sessionMap = sessionMap;
    }

    /*
     * View Helper Method
     */
	public String zeroToBlank(int num) {

		if (num == 0) {
			return "";
		} else {
			return new Integer(num).toString();
		}
	}

	public String toString(Date date) {

		if(date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return df.format(date);
	}

	public String toString(double value) {

		return String.format("%f", value);
	}
}
