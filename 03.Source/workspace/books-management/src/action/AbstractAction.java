package action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AbstractAction extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware,SessionAware, Action {

    private static final long serialVersionUID = 1L;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;
    Map sessionMap;

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setSession(Map sessionMap) {
        this.sessionMap = sessionMap;
    }

	@Override
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}
}
