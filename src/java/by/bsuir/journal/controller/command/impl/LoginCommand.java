package by.bsuir.journal.controller.command.impl;

import by.bsuir.journal.controller.command.Command;
import by.bsuir.journal.controller.command.exception.CommandException;
import by.bsuir.journal.controller.name.JspPageName;
import by.bsuir.journal.controller.name.RequestParameterName;
import by.bsuir.journal.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

import static by.bsuir.journal.controller.name.RequestParameterName.*;

/**
 * Controls login user to site.
 * Handle "login" button.
 */
public class LoginCommand implements Command {

    /**
     * Provides work with database users table.
     */
    private static final UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        String result = JspPageName.LOGIN_JSP;

        try {
            User user = userService.login(login, password);
            if (user != null && user.getRole() != User.Role.BLOCKED) {
                result = JspPageName.HELLO_JSP;
                request.getSession().setAttribute(USER, user);

            } else {
                String path = RequestParameterName.I18N;
                String curLan = (String) request.getSession().getAttribute(LANGUAGE);
                if (curLan != null && !curLan.equals(EN))
                    path += UNDERLINE + curLan;
                ResourceBundle rb = ResourceBundle.getBundle(path);
                if (user != null && user.getRole() == User.Role.BLOCKED) { // if user is blocked
                    request.setAttribute(MESSAGE, rb.getString(LOGIN_BLOCKED));
                } else {
                    request.setAttribute(MESSAGE, rb.getString(LOGIN_WRONG));
                }

            }
        } catch (Exception e) {
            throw new CommandException("Cant't execute LoginCommand", e);
        }
        return result;
    }
}
