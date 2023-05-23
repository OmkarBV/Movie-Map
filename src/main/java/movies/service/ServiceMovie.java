package movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movies.dao.DaoMovie;
import movies.entity.Movie;

@Service
public class ServiceMovie {

	@Autowired
	DaoMovie dao;

	public List<Movie> allData() {
		return dao.allData();
	}

	public List<Movie> sortBugetLH() {
		return dao.sortBugetLH();
	}

	public List<Movie> sortBugetHL() {
		return dao.sortBugetHL();
	}

	public List<Movie> searchMovie(Movie movie) {
		return dao.searchMovie(movie);
	}

	public List<Movie> releseYear(int year) {
		return dao.releseYear(year);
	}

	public List<Movie> releseBetweenYear(int firsty, int lasty) {
		return dao.releseBetweenYear(firsty, lasty);
	}

	public List<Movie> searchDirector(String name) {
		return dao.searchDirector(name);
	}

	public List<Movie> sortGrossLH() {
		return dao.sortGrossLH();
	}

	public List<Movie> sortGrossHL() {
		return dao.sortGrossHL();
	}

	public List<Movie> hitMovie() {
		return dao.hitMovie();
	}

	public List<Movie> flopMovie() {
		return dao.flopMovie();
	}

	public List<Movie> insertMovie(Movie movie) {
		return dao.insertMovie(movie);
	}

	public List<Movie> ratingGross(int rating, double gross) {
		return dao.ratingGross(rating, gross);
	}

	public List<Movie> updateMovie(Movie m) {
		return dao.updateMovie(m);
	}

	public String deleteMovie(String name) {
		return dao.deleteMovie(name);
	}

	public List<Movie> searchCountry(String country) {
		return dao.searchCountry(country);
	}
}
