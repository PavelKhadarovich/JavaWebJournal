package by.bsuir.journal.action;

import by.bsuir.journal.model.service.exception.ServiceException;
import by.bsuir.journal.model.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

/**
 * Created by Veronika.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private SessionMap<String, Object> sessionMap;

    private LoginService loginService = new LoginService();

    private String email;
    private String password;

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String execute() {
        sessionMap.put("email", email);
        return SUCCESS;
    }

    public void validate() {
        try {
            loginService.authenticateUser(email, password);
        } catch (ServiceException e) {
            addActionError(e.getMessage());
        }
    }

    @Validations(
            requiredStrings = {@RequiredStringValidator(message = "Email field must not be empty")},
            emails = {@EmailValidator(message = "Input email format is wrong")}
    )
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @RequiredStringValidator(message = "Field must not be empty")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
