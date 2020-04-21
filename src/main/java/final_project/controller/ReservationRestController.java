package final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import final_project.domain.MovieReservation;
import final_project.service.ReservationService;

@RestController
public class ReservationRestController {

   @Autowired
   private ReservationService reservationService;
   
   @GetMapping("/api/reservations/{resId}")
   public ResponseEntity<MovieReservation> getReservation(@PathVariable("resId") int reservationId){
      
      MovieReservation movieReservation = reservationService.getMovieReservation(reservationId);
      
      if (movieReservation == null) {
         return new ResponseEntity<MovieReservation>(HttpStatus.NOT_FOUND);
      }
      
      return new ResponseEntity<MovieReservation>(movieReservation, HttpStatus.OK);
      
   }
   
}
