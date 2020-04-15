package final_project.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

import final_project.domain.Movie;

@Service
public class MovieService {

   private RestTemplate restTemplate;
   private String moviesUrl;
   private final String imageUrlStart = "http://image.tmdb.org/t/p/original";
   
   public MovieService(
         @Value("${movie.url}") final String moviesUrl) {
      this.restTemplate = new RestTemplate();
      this.moviesUrl = moviesUrl;
   }
   
   public Movie getMovieObjectInfo(int movieIndex) {
      ResponseEntity<JsonNode> response = restTemplate.getForEntity(moviesUrl, JsonNode.class);
      JsonNode json = response.getBody().get("results").get(movieIndex);
      
      String movieTitle = json.get("original_title").asText();
      int id = json.get("id").asInt();
      String releaseDate = json.get("release_date").asText();
      String imageUrl = imageUrlStart + json.get("poster_path").asText();

      return new Movie(movieTitle, id, releaseDate, imageUrl);
   }
   
}