package movies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	private int id;
	private String name;
	private String genres;
	private double budget;
	private double gross;
	private String director;
	private int release_year;
	private int rating;
	private String country;
	private String runtime;

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double buget) {
		this.budget = buget;
	}

	public double getGross() {
		return gross;
	}

	public void setGross(double gross) {
		this.gross = gross;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genres=" + genres + ", buget=" + budget + ", gross=" + gross
				+ ", director=" + director + ", relese=" + release_year + ", rating=" + rating + ", country=" + country
				+ ", runtime=" + runtime + "]";
	}

}
