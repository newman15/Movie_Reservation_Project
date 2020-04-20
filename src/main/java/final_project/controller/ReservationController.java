package final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import final_project.domain.Movie;
import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;
import final_project.service.MovieService;

@Controller
public class ReservationController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
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
	   
	   int movieNumber = reserveId;
	   Movie movieChoice = movieService.getMovieObjectInfo(reserveId);

	   model.addAttribute("movieChoice", movieChoice);
	   model.addAttribute("movieNumber",  movieNumber);

	   return "create_reservation";
	}
	
	@GetMapping("/movies/success") public String reservationCreated( 
			@RequestParam("ticketsRequested") int ticketsRequested, 
			@RequestParam("movieNumber") String movieNumber, Model model) {
	  
		int result = Integer.parseInt(movieNumber); // Cast string to int
		Movie ticketSuccess = movieService.getMovieObjectInfo(result);
		MovieReservation movieReservation = new MovieReservation(ticketSuccess, ticketsRequested);
	
		model.addAttribute("ticketSuccess", ticketSuccess);
		model.addAttribute("movieNumber", movieNumber);
		model.addAttribute("ticketsRequested", ticketsRequested);
		
		reservationRepository.save(movieReservation);
		return "show_reservation"; 
	}
	 
	@GetMapping("/movies/show-reservations")
	public String showAllReservations(Model model) {
	   
	   Iterable<MovieReservation> reservationRepo = reservationRepository.findMoviesOrderByTitle();
	   model.addAttribute("reservations", reservationRepo);
	   return "show_all_reservations";
	}
	 
	
	
}