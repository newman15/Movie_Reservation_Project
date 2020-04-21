package final_project.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;

import final_project.domain.Movie;

public class MovieServiceTest {
   
   private MovieService movieService; //this is the class under test
   
   private String moviesUrl = new String("https://api.themoviedb.org/3/movie/now_playing?api_key=2e9106137e566a1c862c47d7251bb5fe&language=en-US&page=1");
   
   @BeforeEach
   public void setUpEach() {
      MockitoAnnotations.initMocks(this);
      movieService = new MovieService(moviesUrl);
   }

   @Test
   public void getMovieTest() {
      Movie testMovie = 
            new Movie("Sonic the Hedgehog", 454626, "2020-02-12", "http://image.tmdb.org/t/p/original/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg");
   
   //This assumes that the movie at index 1 in the json query is Sonic the Hedgehog.
      
      /* 
       * test against null for name and release date
       * check for http in image url
       * and check response or for exceptions
       */
      
   //given will return
   
   Movie actual = movieService.getMovieObjectInfo(1);
   
   assertThat( actual.getMovieName()).isEqualTo(testMovie.getMovieName());
   assertThat( actual.getMovieId()).isEqualTo(testMovie.getMovieId());
   assertThat( actual.getReleaseDate()).isEqualTo(testMovie.getReleaseDate());
   
   }
   
}
