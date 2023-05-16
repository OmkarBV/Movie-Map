package movies.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import movies.entity.Movie;
import movies.entity.User;
import movies.service.ServiceMovie;

@Controller
public class ControllerMovie {

	@Autowired
	ServiceMovie service;

	@RequestMapping("/alldata")
	public ModelAndView allData() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.allData());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/searchmovie")
	public ModelAndView searchMovie(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.searchMovie(movie));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/releseyear")
	public ModelAndView releseYear(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.releseYear(movie.getRelese()));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/relesebetweenyear")
	public ModelAndView releseBetweenYear(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.releseBetweenYear(Integer.parseInt(request.getParameter("firsty")),
				Integer.valueOf(request.getParameter("lasty"))));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/searchdirector")
	public ModelAndView searchDirector(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.searchDirector(movie.getDirector()));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/ratinggross")
	public ModelAndView ratingGross(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.ratingGross(movie.getRating(), movie.getGross()));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/searchcountry")
	public ModelAndView searchCountry(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.searchCountry(movie.getCountry()));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/sortbugetlh")
	public ModelAndView sortBugetLH() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.sortBugetLH());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/sortbugethl")
	public ModelAndView sortBugetHL() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.sortBugetHL());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/sortgrosslh")
	public ModelAndView sortGrossLH() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.sortGrossLH());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("/sortgrosshl")
	public ModelAndView sortGrossHL() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.sortGrossHL());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/hitmovie")
	public ModelAndView hitMovie() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.hitMovie());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;

	}

	@RequestMapping("/flopmovie")
	public ModelAndView flopMovie() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.flopMovie());
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insertMovie(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.insertMovie(movie));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView updateMovie(Movie movie) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", service.updateMovie(movie));
		mv.addObject("isadmin", ControllerLoginRegister.isadmin);
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteMovie(Movie movie) {
		ModelAndView mv = new ModelAndView();
		String available = "true";
		if (service.searchMovie(movie).size() != 0) {
			service.deleteMovie(movie.getName());
			mv.addObject("sms", available);
			mv.addObject("isadmin", ControllerLoginRegister.isadmin);
			mv.addObject("data", service.allData());
			mv.setViewName("home");
			return mv;
		} else {
			available = "false";
			mv.addObject("sms", available);
			mv.setViewName("home");
			return mv;
		}
	}
}
