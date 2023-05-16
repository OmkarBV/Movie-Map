package movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMappingBetweenPages {

	@RequestMapping("/")
	public String showLoginPage() {
		return "userlogin";
	}

	@RequestMapping("/gotouserregister")
	public String goToRegister() {
		return "userregister";
	}

	@RequestMapping("/gotoadminlogin")
	public String goToAdminLogin() {
		return "adminlogin";
	}

	@RequestMapping("/gotoadminregister")
	public String goToAdminRegister() {
		return "adminregister";
	}

	@RequestMapping("/gotouserlogin")
	public String goToUserLogin() {
		return "userlogin";
	}

	@RequestMapping("/forgotpassword")
	public String forgotPassword() {
		return "forgotpassword";
	}
}
