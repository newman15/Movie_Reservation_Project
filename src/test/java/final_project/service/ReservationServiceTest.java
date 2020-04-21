package final_project.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import final_project.domain.MovieReservation;

public class ReservationServiceTest {

   private ReservationService reservationService; //this is the class under test
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      reservationService = new ReservationService();
   }
   
   @Test
   public void getReservationTest() {
      MovieReservation testMovieReservation = new MovieReservation();
      
      MovieReservation actual = reservationService.getMovieReservation(0);
      
      assertThat( actual.getMovieName()).isEqualTo(testMovieReservation.getMovieName());
      assertThat( actual.getNumberOfTickets()).isEqualTo(testMovieReservation.getNumberOfTickets());
      assertThat( actual.getShowTime()).isEqualTo(testMovieReservation.getShowTime());
      
   }
   
   
   
}
