package by.bsuir.journal.controller.command.impl;


import by.bsuir.journal.controller.command.Command;
import by.bsuir.journal.controller.command.exception.CommandException;
import by.bsuir.journal.controller.name.JspPageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Control unhandled situations.
 */
public class UnknownCommand implements Command {

    /**
     * Handle situations if there is no such command in application.
     *
     * @return error page
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        return JspPageName.ERROR_JSP;
    }
}
