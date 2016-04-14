package by.bsuir.journal.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Veronika.
 */
public class LoginInquireAction extends ActionSupport implements SessionAware {

    private SessionMap<String, Object> sessionMap;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String execute() {
        if (sessionMap.containsKey("email")) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
