package movies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	private int id;
	private String name;
	private String genres;
	private double buget;
	private double gross;
	private String director;
	private int relese;
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

	public double getBuget() {
		return buget;
	}

	public void setBuget(double buget) {
		this.buget = buget;
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

	public int getRelese() {
		return relese;
	}

	public void setRelese(int relese) {
		this.relese = relese;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", genres=" + genres + ", buget=" + buget + ", gross=" + gross
				+ ", director=" + director + ", relese=" + relese + ", rating=" + rating + ", country=" + country
				+ ", runtime=" + runtime + "]";
	}

}
