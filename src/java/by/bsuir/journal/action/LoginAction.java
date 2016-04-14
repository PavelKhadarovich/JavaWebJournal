package by.bsuir.journal.action;

import by.bsuir.journal.model.dao.UserDao;
import by.bsuir.journal.model.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class LoginAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(LoginAction.class);

    UserDao dao = new UserDao();
    User user;

    @Override
    public void validate() {
        if (user.getName().length() == (0)) {
            this.addFieldError("user.name", "Name is required");
            LOGGER.info("Name is required");
        }
        if (user.getPasswordHash().length() == (0)) {
            this.addFieldError("user.passwordHash", "Password is required");
        }
    }

    @Override
    public String execute() {
        if (dao.find(user.getName(), user.getPasswordHash())) {
            return SUCCESS;
        } else {
            this.addActionError("Invalid username and password");
        }
        return INPUT;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}