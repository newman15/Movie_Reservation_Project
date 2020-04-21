package final_project.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import final_project.domain.Movie;

@SpringBootTest
public class MovieServiceTest {
   
   private MovieService movieService; //this is the class under test
   
   //private static final Movie expected = new Movie("Sonic the Hedgehog", 454626, "2020-02-12", 
   //      "http://image.tmdb.org/t/p/original/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg");
   
   private Movie actual;
   
   private String moviesUrl = new String("https://api.themoviedb.org/3/movie/now_playing?api_key=2e9106137e566a1c862c47d7251bb5fe&language=en-US&page=1");
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      
      movieService = new MovieService(moviesUrl);
   }
   
   @Mock
   private Movie movieTest;

   /* 
    * test against null for name and release date
    * check for http in image url
    * and check response or for exceptions
    */
   
   @Test
   public void getMovieTest() {
      
       actual = movieService.getMovieObjectInfo(1);

       assertThat(actual.getImageUrl()).contains("http");
   
   }
   
   @Test
   public void apiTest() {
      
      actual = movieService.getMovieObjectInfo(2);
      
      assertThat(actual).hasNoNullFieldsOrProperties();
      
   }
   
}
