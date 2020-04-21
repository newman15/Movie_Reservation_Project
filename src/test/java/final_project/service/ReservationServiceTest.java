package final_project.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.BDDMockito.given;

import final_project.domain.MovieReservation;
import final_project.domain.ReservationRepository;

@SpringBootTest
public class ReservationServiceTest {

   @Autowired
   private ReservationService reservationService; //this is the class under test
   
   private static final MovieReservation expected = new MovieReservation("Bloodshot", 1, "2020-03-05");
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      
      //Assumed populated
      given(reservationRepository.findById(1L)).willReturn(Optional.of(expected));
      
      //Assumed null
      given(reservationRepository.findById(-1L)).willReturn(Optional.empty());
      
      //reservationService = new ReservationService();
   }
   
   //Mock the reservationRepository
   @MockBean
   private ReservationRepository reservationRepository;
   
   @Test
   public void getReservationTest() {
      //MovieReservation testMovieReservation = new MovieReservation();
      
      MovieReservation actual = reservationService.getMovieReservation(1);
      
      assertThat( actual ).isEqualToComparingFieldByField(expected);
      /*
       * assertThat(
       * actual.getMovieName()).isEqualTo(testMovieReservation.getMovieName());
       * assertThat( actual.getNumberOfTickets()).isEqualTo(testMovieReservation.
       * getNumberOfTickets()); assertThat(
       * actual.getShowTime()).isEqualTo(testMovieReservation.getShowTime());
       */
   }
   
   
   
}
