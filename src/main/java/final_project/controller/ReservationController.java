package final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import final_project.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	String nameName;
	
	@GetMapping("/movies")
	public String getMovieInfo(String movieName, Model model) {
		MovieInfo movieInfo = reservationService.getMovieInfo(movieName); // May not be needed since API is populating movie info
		return "show_movies";
	} 
	
	@PostMapping("/movies/reservation")
	public String createReservation() {

		return "create_reservation";
	}
	
}
