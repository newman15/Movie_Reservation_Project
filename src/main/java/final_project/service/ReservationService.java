
package final_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;

@Service
public class ReservationService {

   private MovieService movieService;
   
   @Autowired
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
   
   public ReservationService(ReservationRepository reservationRepository) {
      super();
      this.reservationRepository = reservationRepository;
   }
   
   /*
    * public ReservationService() { this.reservationNum = 0; this.movieTitle =
    * null; this.numTickets = 0; this.showTime = null; }
    * 
    * public ReservationService(int resNum, MovieReservation movieReservation) {
    * this.reservationNum = resNum; this.movieTitle =
    * movieReservation.getMovieName(); this.numTickets =
    * movieReservation.getNumberOfTickets(); this.showTime =
    * movieReservation.getShowTime(); }
    */

	public MovieReservation getMovieReservation(int resNum) {
	     
	  Optional<MovieReservation> movieReservation;
	  movieReservation = reservationRepository.findById((long) resNum);
    
	  /*
       * //pull movie name String movieNameById =
       * reservationRepository.findMovieNameById(resNum); movieTitle = movieNameById;
       * 
       * //pull amount of tickets int numTicketsById =
       * reservationRepository.findNumOfTicketsById(resNum); numTickets =
       * numTicketsById; //whatever is in the database at resNum#
       * 
       * //pull movie show time String showTimeById =
       * reservationRepository.findShowTimeById(resNum); showTime = showTimeById;
       * //whatever is in the database at resNum#
       */
	  
	  //set
	  //movieReservation = new MovieReservation(movieTitle, numTickets, showTime);
	  
	  if (movieReservation.isPresent()) {
	     return movieReservation.get();
	  }
	  else {
	     //if null
	     return null;
	  }
	}
	
}