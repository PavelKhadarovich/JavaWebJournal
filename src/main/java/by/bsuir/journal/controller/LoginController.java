package by.bsuir.journal.controller;

import by.bsuir.journal.model.User;
import by.bsuir.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UserService userService;
    //--------------------------------------------------------------------------------------------------//
    //--------------------------------------------JSON--------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//



    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<Void> loginUser(@RequestBody User user, UriComponentsBuilder ucBuilder, HttpSession session) {

//        if (user!=null && user.getPassword().equals(password))) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        session.setAttribute("user", user);
        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //--------------------------------------------------------------------------------------------------//
    //------------------------------------------JSP-----------------------------------------------------//
    //--------------------------------------------------------------------------------------------------//

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("ssoId") String sso,
                            @RequestParam("password") String password, Model model, HttpSession session) {

        User persistedUser = userService.findBySSO(sso);
        if (persistedUser != null && persistedUser.getPassword().equals(password)) {
            session.setAttribute("user", persistedUser);
            model.addAttribute("success", "User " + persistedUser.getFirstName() + " "+ persistedUser.getLastName() + " signed in successfully");
            //return "home";
            return "jsonTemplate";
        } else {
            model.addAttribute("error", "Incorrect username or password, Please try again!");
            //return "login";
            return "jsonTemplate";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutUser(HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.invalidate();
        }
        //return "index";
        return "jsonTemplate";
    }

    @RequestMapping(value = "/showlogin", method = RequestMethod.GET)
    public String showloginPage() {
        return "login";
    }

}
