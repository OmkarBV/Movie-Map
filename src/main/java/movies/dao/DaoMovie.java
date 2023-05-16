package movies.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import movies.entity.Movie;

@SuppressWarnings({ "unchecked", "deprecation" })

@Repository
public class DaoMovie {

	@Autowired
	SessionFactory sf;

	public List<Movie> allData() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		return cri.list();
	}

	public List<Movie> sortBugetLH() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.addOrder(Order.asc("buget"));
		return cri.list();
	}

	public List<Movie> sortBugetHL() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.addOrder(Order.desc("buget"));
		return cri.list();
	}

	public List<Movie> searchMovie(Movie movie) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("name", movie.getName()));
		return cri.list();
	}

	public List<Movie> releseYear(int year) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("relese", year));
		return cri.list();
	}

	public List<Movie> releseBetweenYear(int firsty, int lasty) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.between("relese", firsty, lasty));
		return cri.list();
	}

	public List<Movie> searchDirector(String name) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("director", name));
		return cri.list();
	}

	public List<Movie> sortGrossLH() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.addOrder(Order.asc("gross"));
		return cri.list();
	}

	public List<Movie> sortGrossHL() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.addOrder(Order.desc("gross"));
		return cri.list();
	}

	public List<Movie> hitMovie() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.geProperty("gross", "buget"));
		return cri.list();
	}

	public List<Movie> flopMovie() {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.leProperty("gross", "buget"));
		return cri.list();
	}

	public List<Movie> insertMovie(Movie movie) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(movie);
		t.commit();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("name", movie.getName()));
		return cri.list();
	}

	public List<Movie> ratingGross(int rating, double gross) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.ge("rating", rating));
		cri.add(Restrictions.ge("gross", gross));
		return cri.list();
	}

	public List<Movie> updateMovie(Movie m) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		System.out.println(m);
		session.update(m);
		tr.commit();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("name", m.getName()));
		return cri.list();
	}

	public String deleteMovie(String name) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Movie m = session.load(Movie.class, name);
		m.setName(name);
		session.delete(m);
		tr.commit();
		return "Data Deleted Successfully";
	}

	public List<Movie> searchCountry(String country) {
		Session session = sf.openSession();
		Criteria cri = session.createCriteria(Movie.class);
		cri.add(Restrictions.eq("country", country));
		return cri.list();
	}

}
