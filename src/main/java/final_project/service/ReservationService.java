
package final_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import final_project.domain.Movie;
import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;

@Service
public class ReservationService {

   private MovieService movieService;
   private ReservationRepository reservationRepository;
   private int reservationNum;
  
   public int getReservationNum() {
      return reservationNum;
   }

   public void setReservationNum(int reservationNum) {
      this.reservationNum = reservationNum;
   }

   private String movieTitle;
   private int numTickets;
   private String showTime;
   
   public ReservationService() {
      this.reservationNum = 0;
      this.movieTitle = null;
      this.numTickets = 0;
      this.showTime = null;
   }
   
   public ReservationService(int resNum, MovieReservation movieReservation) {
      this.reservationNum = resNum;
      this.movieTitle = movieReservation.getMovieName();
      this.numTickets = movieReservation.getNumberOfTickets();
      this.showTime = movieReservation.getShowTime();
   }

	public MovieReservation getMovieReservation(int resNum) {
	     
	  MovieReservation movieReservation;
	  
	  //pull movie name
	  String movieNameById = reservationRepository.findMovieNameById();
	  movieTitle = movieNameById;
	  
	  //pull amount of tickets
	  int numTicketsById = reservationRepository.findNumOfTicketsById();
	  numTickets = numTicketsById; //whatever is in the database at resNum#
	 
	  //pull movie show time
	  String showTimeById = reservationRepository.findShowTimeById();
	  showTime = showTimeById; //whatever is in the database at resNum#
	  
	  //set
	  movieReservation = new MovieReservation(movieTitle, numTickets, showTime);
	 
	  return movieReservation;
	}
	
}