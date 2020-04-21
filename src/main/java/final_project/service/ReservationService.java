
package final_project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;

/*
 * This service is used to return pertinent movieReservation
 * information used to display to the user
 */
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
   
	public MovieReservation getMovieReservation(int resNum) {
	     
	  Optional<MovieReservation> movieReservation;
	  movieReservation = reservationRepository.findById((long) resNum);

	  if (movieReservation.isPresent()) {
	     return movieReservation.get();
	  }
	  else {
	     //if null
	     return null;
	  }
	}
	
}