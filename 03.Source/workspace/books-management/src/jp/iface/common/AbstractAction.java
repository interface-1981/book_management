package jp.iface.common;

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

public class AbstractAction extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware,SessionAware, Action, Constants {

	protected enum MESSAGE {
		COMPLETE_REGIST,
		ALREADY_REGIST_BOOK,
		NOTFOUND_REGIST_BOOK
	}

    private static final long serialVersionUID = 1L;

    public CommonUtil util = new CommonUtil();

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ServletContext context;

    @SuppressWarnings("rawtypes")
	Map sessionMap;

    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    @SuppressWarnings("rawtypes")
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

	protected String getMessage(MESSAGE message) {
		return Configuration.getValue(message.toString());
	}

}
