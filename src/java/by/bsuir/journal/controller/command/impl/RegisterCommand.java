package by.bsuir.journal.controller.command.impl;


import by.bsuir.journal.controller.command.Command;
import by.bsuir.journal.controller.command.exception.CommandException;
import by.bsuir.journal.controller.name.JspPageName;
import by.bsuir.journal.entity.User;
import org.hibernate.service.spi.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ResourceBundle;

import static by.bsuir.journal.controller.name.RequestParameterName.*;

/**
 * Control users registration to site.
 * Handle "register" button.
 */
public class RegisterCommand implements Command {

    /**
     * Service provides work with database (user table)
     */
    private static UserService userService = UserService.getInstance();

    /**
     * Get from request user parameters and create new user.
     * If everything is fine, return hello page value.
     *
     * @return page to forward to
     * @throws CommandException if can't create new user
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);
        String payCard = request.getParameter(PAY_CARD_ID);

        String result = JspPageName.REGISTER_JSP;
        try {
            if (userService.get(login) == null) {
                System.out.println("no such login yet");
                User user = userService.create(name, surname, email, payCard, login, password);
                System.out.println(user.toString());
                result = JspPageName.LOGIN_JSP;//зарегался - теперь залогинься
            } else {
                String path = I18N;
                String currentLanguage = (String) request.getSession().getAttribute(LANGUAGE);
                if (currentLanguage != null && !currentLanguage.equals(EN)) {
                    path += UNDERLINE + currentLanguage;
                }
                ResourceBundle rb = ResourceBundle.getBundle(path);
                request.setAttribute(REQUIRED_MESSAGE, rb.getString(REGISTER_WRONG));
            }
        } catch (ServiceException e) {
            throw new CommandException("Registration failed", e);
        }

        return result;
    }
}
