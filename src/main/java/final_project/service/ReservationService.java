
package final_project.service;

import org.springframework.stereotype.Service;

import final_project.domain.Movie;
import final_project.domain.MovieReservation;

@Service
public class ReservationService {

   private MovieService movieService;

	public MovieReservation getMovieReservation(int movieIndex) {
	     
	  MovieReservation movieReservation;
	  Movie movie;
	  int numberOfTickets;
	 
	  //get the movie object
	  movie = movieService.getMovieObjectInfo(movieIndex);
	  //reserve amount of tickets
	  numberOfTickets = 1;
	 
	  //set
	  movieReservation = new MovieReservation(movie, numberOfTickets);
	 
	  return movieReservation;
	}
	
}