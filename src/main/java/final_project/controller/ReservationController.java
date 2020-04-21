package final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import final_project.domain.Movie;
import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;
import final_project.service.MovieService;
import final_project.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ReservationService reservationService;
	
	/*
	 * Uses the movieService class to obtain the first 6 movies 
	 * that are currently showing in the U.S.,
	 * And stores them as Movie objects
	 */
	@GetMapping("/movies")
	public String getMovieInfo(Model model) {

	   Movie movie1 = movieService.getMovieObjectInfo(0);
	   Movie movie2 = movieService.getMovieObjectInfo(1);
	   Movie movie3 = movieService.getMovieObjectInfo(2);
	   Movie movie4 = movieService.getMovieObjectInfo(3);
	   Movie movie5 = movieService.getMovieObjectInfo(4);
	   Movie movie6 = movieService.getMovieObjectInfo(5);
	   
	   model.addAttribute("movie1", movie1);
	   model.addAttribute("movie2", movie2);
	   model.addAttribute("movie3", movie3);
	   model.addAttribute("movie4", movie4);
	   model.addAttribute("movie5", movie5);
	   model.addAttribute("movie6", movie6);
		
	   return "show_movies";
	} 
	
	/*
	 * Obtains a reservation Id based off the user's movie selection,
	 * and passes it to the movieReservation class to create a reservation
	 */
	@GetMapping("/movies/reservation")
	public String createReservation(
	    @RequestParam("reserveId") int reserveId,
	    Model model) {
	   
	   //Obtain the reserveId from user's selection
	   int movieNumber = reserveId;
	   
	   //Gets the movie info from the rest API based off the reserveId
	   Movie movieChoice = movieService.getMovieObjectInfo(reserveId);

	   model.addAttribute("movieChoice", movieChoice);
	   model.addAttribute("movieNumber",  movieNumber);

	   return "create_reservation";
	}
	
	/*
	 * Obtains the user's desired number of tickets and show time for the selected movie, 
	 * and creates a reservation to be stored in the Database
	 */
	@GetMapping("/movies/success") 
	public String reservationCreated( 
			@RequestParam("ticketsRequested") int ticketsRequested, 
			@RequestParam("movieNumber") String movieNumber, 
			@RequestParam("movieTimes") String movieTimes, Model model) {
	  
		//Cast string to int to be used as the reserveId
		int result = Integer.parseInt(movieNumber); 
		
		//Gets the movie info from the rest API based off the reserveId
		Movie ticketSuccess = movieService.getMovieObjectInfo(result);
		
		//Create a new movie reservation using a movie object, ticketNum, and show time
		MovieReservation movieReservation = new MovieReservation(ticketSuccess, ticketsRequested, movieTimes);
	
		model.addAttribute("ticketSuccess", ticketSuccess);
		
		//Save movie reservation to the Database
		reservationRepository.save(movieReservation);
		
		//Find the newly created reservation Id in the database
		String findId = reservationRepository.findLastEntry();
		int resNum = Integer.parseInt(findId);
		
		//Search Database for reservation and return the reservation details
		MovieReservation searchReservation = reservationService.getMovieReservation(resNum); 
		
		model.addAttribute("searchReservation", searchReservation);
		
		return "show_reservation"; 
	}
	 
	/* 
	 * Sends query to the database to return ALL saved reservations 
	 */
	@GetMapping("/movies/show-reservations")
	public String showAllReservations(Model model) {
	   
	   //Store response in an iterable object to be displayed as table in html template
	   Iterable<MovieReservation> reservationRepo = reservationRepository.findMoviesOrderByTickets();
	   model.addAttribute("reservations", reservationRepo);
	   
	   return "show_all_reservations";
	}
	
	/*
	 * Obtains a user entered reservation number to search for their existing
	 * reservation
	 */
	@GetMapping("/movies/search-reservation")
	public String searchForReservation(@RequestParam("resNum") int resNum, Model model) {
		
	   //Uses the reservationService to search for the reservation based off resNum
	   MovieReservation searchReservation = reservationService.getMovieReservation(resNum); 
	   
	   model.addAttribute("searchReservation", searchReservation);
	   
	   return "search_reservation";
	}

}