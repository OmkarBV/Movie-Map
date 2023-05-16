package movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	@Autowired
	JavaMailSender mailsender;

	static boolean isadmin = false;
	public static String number;

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
				number = user.getNumber();
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

//				SimpleMailMessage sms = new SimpleMailMessage();
//				sms.setTo(user.getEmail());
//				sms.setSubject("Thnaks For Registration");
//				sms.setText("Welcome to MovieMap Family ");
//				mailsender.send(sms);

				service.registerNewUser(user);
				mv.setViewName("userlogin");
			} else {
				mv.setViewName("userlogin");
			}

		}
		return mv;
	}

	// *************Forgot Password********************
	int otp = (int) ((Math.random() * 8889) + 1111);
	String email = "";

	@RequestMapping("/forgotpass")
	public ModelAndView forgotPassword(String email) {
//		this.email = email;
//		SimpleMailMessage sms = new SimpleMailMessage();
//		sms.setTo(email);
//		sms.setSubject("OTP from MovieMap");
//		sms.setText(otp + " Do Not Share");
//		mailsender.send(sms);
		System.out.println(this.otp);
		ModelAndView mv = new ModelAndView();
		mv.addObject("sms", "OTP Send");
		mv.setViewName("forgotpassword");
		return mv;
	}

	@RequestMapping("/enterotp")
	public ModelAndView enterOtp(Integer otp, String password, String confirmpassword) {
		ModelAndView mv = new ModelAndView();
		if (this.otp == otp) {
			if (password.equals(confirmpassword)) {
				service.updatePassword(email, password);
				mv.addObject("sms", "Password Changed Successful");
				mv.setViewName("userlogin");
			} else {
				System.out.println(password + "++" + confirmpassword);

				mv.addObject("smsotp", "PassWord Doesnt Match");
				mv.setViewName("forgotpassword");
			}
		} else {
			mv.addObject("smsotp", "Wrong OTP");
			mv.setViewName("forgotpassword");
		}
		return mv;
	}

}
