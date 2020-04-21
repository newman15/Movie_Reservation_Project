package final_project.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<MovieReservation, Long>{
	@Query(value = "SELECT * FROM movie_reservation ORDER BY id, number_of_tickets, movie_name",
			nativeQuery=true)
	public List<MovieReservation> findMoviesOrderByTickets();
	
   /*
    * @Query(value = "SELECT movie_name FROM movie_reservation WHERE id = ?1",
    * nativeQuery=true) public String findMovieNameById(int id);
    * 
    * @Query(value =
    * "SELECT number_of_tickets FROM movie_reservation WHERE id = ?1",
    * nativeQuery=true) public int findNumOfTicketsById(int id);
    * 
    * @Query(value = "SELECT show_time FROM movie_reservation WHERE id = ?1",
    * nativeQuery=true) public String findShowTimeById(int id);
    */
}
