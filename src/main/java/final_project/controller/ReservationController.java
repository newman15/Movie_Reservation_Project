package final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import final_project.domain.Movie;
import final_project.service.MovieService;

@Controller
public class ReservationController {
	
	@Autowired
	private MovieService movieService;
	
	int movieSelection;
	
	@GetMapping("/movies")
	public String getMovieInfo(Model model) {

	   Movie movie1 = movieService.getMovieObjectInfo(0);
	   Movie movie2 = movieService.getMovieObjectInfo(1);
	   Movie movie3 = movieService.getMovieObjectInfo(2);
	   
	   model.addAttribute("movie1", movie1);
	   model.addAttribute("movie2", movie2);
	   model.addAttribute("movie3", movie3);
		
		return "show_movies";
	} 
	

	@GetMapping("/movies/reservation")
	public String createReservation(
	    @RequestParam("reserveId") int reserveId,
	    Model model) {
	   
	   Movie movieChoice = movieService.getMovieObjectInfo(reserveId);
	   movieSelection = reserveId;
	   
	   model.addAttribute("movieChoice", movieChoice);
	   //model.addAttribute("value", reserveId);

	return "create_reservation";
	}
	
	@GetMapping("/movies/success")
	public String reservationCreated(
	      @RequestParam("reserveId") int reserveId,
	      @RequestParam("ticketsRequested") int ticketsRequested, 
	      Model model) {
	   
	   int ticketsReq = ticketsRequested;
	   
	   Movie ticketSuccess = movieService.getMovieObjectInfo(reserveId);
	   model.addAttribute("ticketSuccess", ticketSuccess);
	   //model.addAttribute("ticketsRequested", ticketsReq);
	   
	   return "show_reservation";
	}
	
	
}