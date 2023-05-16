package movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.dao.DaoLoginRegister;
import movies.entity.Admin;
import movies.entity.User;

@Service
public class ServiceLoginRegister {
	@Autowired
	DaoLoginRegister dao;

	public String sms = null;

	public boolean adminLogin(Admin admin) {
		List<Admin> s = dao.adminLogin(admin);
		if (s.size() == 0) {
			sms = "Invalid Admin";
			return false;
		} else {
			if (s.get(0).getNumber().equals(admin.getNumber()) && s.get(0).getPassword().equals(admin.getPassword())) {
				return true;
			} else {
				sms = "Invalid Password";
				return false;
			}
		}
	}

	public boolean checkAvailable(Admin admin) {
		List<Admin> l = dao.adminLogin(admin);
		if (l.size() == 0) {
			sms = "Register Successfuly";
			return true;
		} else {
			sms = "Registration Failed Number Already Register";
			return false;

		}
	}

	public void registerNewAdmin(Admin admin) {
		dao.registerNewAdmin(admin);
	}

	public boolean userLogin(User user) {
		List<User> s = dao.userLogin(user);
		if (s.size() == 0) {
			sms = "Invalid User";
			return false;
		} else {
			if (s.get(0).getNumber().equals(user.getNumber())
					&& s.get(0).getPassword().equals(user.getPassword())) {
				return true;
			} else {
				sms = "Invalid Password";
				return false;
			}
		}
	}

	public boolean checkAvailable(User user) {
		List<User> l = dao.userLogin(user);
		if (l.size() == 0) {
			sms = "Register Successfuly";
			return true;
		} else {
			sms = "Registration Failed Number Already Register";
			return false;

		}
	}

	public void registerNewUser(User user) {
		dao.registerNewUser(user);
	}

	public void updatePassword(String email, String password) {
		dao.updatePassword(email,password);
	}

	
}
