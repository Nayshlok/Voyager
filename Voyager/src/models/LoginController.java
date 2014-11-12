package models;
import javax.servlet.http.HttpServletRequest;

public class LoginController {
	public UserService userService;

	public LoginController(UserService us) {
		userService = us;
		userService.createUser("user", "password");
	}

	public ModelAndView login(HttpServletRequest request ) {
		String password = request.getParameter("password");
		
		RegisterUserModel model = new RegisterUserModel();
		try {
			if(userService.getUsers().containsKey(password)) {
				User user = userService.getUsers().get(password);
				model.setUser(user);
			}
			
			return new ModelAndView(model, "/WEB-INF/account/profile.jsp");
		} catch(UsernameAlreadyExistsException e) {
			model.setErrorMessage("Incorrect Login");
			
			return new ModelAndView(model, "/WEB-INF/account/login.jsp");
		}

	}
}
