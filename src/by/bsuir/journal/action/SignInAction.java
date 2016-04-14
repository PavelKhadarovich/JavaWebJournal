package by.bsuir.journal.action;

import by.bsuir.journal.model.entity.UserType;
import by.bsuir.journal.model.service.SignInService;
import by.bsuir.journal.model.service.exception.ServiceException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by Veronika.
 */
public class SignInAction extends ActionSupport implements SessionAware {
    private SessionMap<String, Object> sessionMap;

    private String email;
    private String password;
    private String name;
    private String surname;
    private UserType userType;

    private SignInService signInService = new SignInService();

    @Override
    public void setSession(Map<String, Object> map) {
        sessionMap = (SessionMap<String, Object>) map;
    }

    public String execute() {
        try {
            signInService.signInNewUser(email, password, name, surname, userType);
        } catch (ServiceException e) {
            return INPUT;
        }

        sessionMap.put("email", email);
        return SUCCESS;
    }

    public void validate() {
        try {
            signInService.checkIsThisEmailRegistered(email);
        } catch (ServiceException e) {
            addFieldError("email", e.getMessage());
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

    @RequiredStringValidator(message = "Field must not be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequiredStringValidator(message = "Field must not be empty")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @RequiredFieldValidator(message = "User type must be selected")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public List<UserType> getUserTypes() {
        return SignInService.getUserTypes();
    }
}
