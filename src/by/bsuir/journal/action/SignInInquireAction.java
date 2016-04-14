package by.bsuir.journal.action;

import by.bsuir.journal.model.service.SignInService;
import by.bsuir.journal.model.entity.UserType;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by Veronika.
 */
public class SignInInquireAction extends ActionSupport {

    public String execute() {
        return SUCCESS;
    }

    public List<UserType> getUserTypes() {
        return SignInService.getUserTypes();
    }
}
