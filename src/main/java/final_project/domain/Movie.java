package final_project.domain;

public class Movie {
	String movieName;
	int movieId;
	
	public Movie(String movieName, int movieId){
		super();
		this.movieName = movieName;
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	
}
