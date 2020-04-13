package final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import final_project.domain.MovieRepository;
import final_project.domain.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public MovieInfo getMovieInfo(String movieName) {
		//May not be needed since API will be providing the info
	}
}
