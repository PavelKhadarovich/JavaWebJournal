package by.bsuir.journal.controller;

import by.bsuir.journal.model.User;
import by.bsuir.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author anirudh
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;

    //==============JSON===========================



    //==============JSP===========================
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("ssoId") String sso,
                            @RequestParam("password") String password, Model model, HttpSession session) {

        User persistedUser = userService.findBySSO(sso);
        if (persistedUser != null && persistedUser.getPassword().equals(password)) {
            session.setAttribute("user", persistedUser);
            model.addAttribute("success", "User " + persistedUser.getFirstName() + " "+ persistedUser.getLastName() + " signed in successfully");
            return "home";
        } else {
            model.addAttribute("error", "Incorrect username or password, Please try again!");
            return "login";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping(value = "/showlogin", method = RequestMethod.GET)
    public String showloginPage() {
        return "login";
    }

}
