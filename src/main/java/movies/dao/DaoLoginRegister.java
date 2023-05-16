package movies.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movies.entity.Admin;
import movies.entity.User;

@SuppressWarnings({ "unchecked", "deprecation" })

@Repository
public class DaoLoginRegister {
	@Autowired
	SessionFactory sf;

	public List<Admin> adminLogin(Admin admin) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Admin.class);
		cri.add(Restrictions.eq("number", admin.getNumber()));
		return cri.list();
	}

	public void registerNewAdmin(Admin admin) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(admin);
		tr.commit();
	}

	public List<User> userLogin(User user) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("number", user.getNumber()));
		return cri.list();
	}

	public void registerNewUser(User user) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		tr.commit();
	}

	public void updatePassword(String email, String password) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(User.class);
		cri.add(Restrictions.eq("email", email));
		User user = (User) cri.list().get(0);
		user.setPassword(password);

		Transaction tr = session.beginTransaction();
		session.update(user);
		tr.commit();
	}

}
