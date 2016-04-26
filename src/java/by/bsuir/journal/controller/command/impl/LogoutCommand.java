package by.bsuir.journal.controller.command.impl;

import by.bsuir.journal.controller.command.Command;
import by.bsuir.journal.controller.command.exception.CommandException;
import by.bsuir.journal.controller.name.JspPageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Control user logout from site.
 * Handle "logout" button.
 */
public class LogoutCommand implements Command {

    /**
     * Get current session and invalidate it.
     * Return index page.
     *
     * @return page to forward to
     * @throws CommandException if can't logout
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        HttpSession currentSession = request.getSession(false);
        if (currentSession != null) {
            currentSession.invalidate();
        }
        return JspPageName.INDEX_JSP;
    }
}
