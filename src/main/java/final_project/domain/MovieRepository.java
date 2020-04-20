package final_project.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieReservation, Long>{
	@Query(value = "SELECT * FROM movie_reservation GROUP BY movie_name ORDER BY number_of_tickets",
			nativeQuery=true)
	public List<MovieReservation> findTicketsOrderByShowTime();
}