package by.bsuir.journal.controller;

import by.bsuir.journal.model.User;
import by.bsuir.journal.model.UserProfile;
import by.bsuir.journal.service.UserProfileService;
import by.bsuir.journal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
	public String goToIndex(ModelMap model) {
		return "index";
	}

	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "userslist";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.GET)
	public String editUser(@PathVariable String ssoId, ModelMap model) {
		User user = userService.findBySSO(ssoId);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = {"/edit-user-{ssoId}"}, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
							 ModelMap model, @PathVariable String ssoId) {
		if (result.hasErrors()) {
			return "registration";
		}
		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/
		userService.updateUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " " + user.getLastName() + " updated successfully");
		return "home";
	}


	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = {"/delete-user-{ssoId}"}, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String ssoId) {
		userService.deleteUserBySSO(ssoId);
		return "redirect:/list";
	}



	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

}