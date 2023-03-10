package movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import movies.entity.Admin;
import movies.entity.User;
import movies.service.ServiceLoginRegister;

@Controller
public class ControllerLoginRegister {
	@Autowired
	ServiceLoginRegister service;

	@Autowired
	ControllerMovie movie;

	static boolean isadmin = false;

	@RequestMapping("/adminlogin")
	public ModelAndView adminLogin(Admin admin) {
		ModelAndView mv = new ModelAndView();
		boolean valid = service.adminLogin(admin);
		mv.addObject("sms", null);
		if (admin.getNumber() != null && admin.getPassword() != null) {
			if (valid) {
				mv.addObject("isadmin", true);
				isadmin = true;
				mv.setViewName("home");
			} else {
				mv.addObject("sms", service.sms);
				mv.setViewName("adminlogin");
			}
		}
		return mv;
	}

	@RequestMapping("/adminregister")
	public ModelAndView registerNewAdmin(Admin admin) {
		ModelAndView mv = new ModelAndView();
		boolean avialable = service.checkAvailable(admin);
		if (admin.getNumber() != null && admin.getName() != null && admin.getPassword() != null
				&& admin.getEmail() != null) {
			mv.addObject("sms", service.sms);
			if (avialable) {
				service.registerNewAdmin(admin);
				mv.setViewName("adminlogin");
			} else {
				mv.setViewName("adminregister");
			}

		}
		return mv;
	}

	@RequestMapping("/userlogin")
	public ModelAndView userLogin(User user) {
		ModelAndView mv = new ModelAndView();
		boolean valid = service.userLogin(user);
		mv.addObject("sms", null);
		if (user.getNumber() != null && user.getPassword() != null) {
			if (valid) {
				mv.addObject("isadmin", false);
				isadmin = false;
				mv.setViewName("home");
			} else {
				mv.addObject("sms", service.sms);
				mv.setViewName("userlogin");
			}
		}
		return mv;
	}

	@RequestMapping("/userregister")
	public ModelAndView userNewAdmin(User user) {
		ModelAndView mv = new ModelAndView();
		boolean avialable = service.checkAvailable(user);
		if (user.getNumber() != null && user.getName() != null && user.getPassword() != null
				&& user.getEmail() != null) {
			mv.addObject("sms", service.sms);
			if (avialable) {
				service.registerNewAdmin(user);
				mv.setViewName("userlogin");
			} else {
				mv.setViewName("userlogin");
			}

		}
		return mv;
	}

}
