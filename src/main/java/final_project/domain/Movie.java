package final_project.domain;

public class Movie {
	String movieName, releaseDate, imageUrl;
	int movieId;

	public Movie(String movieName, int movieId, String releaseDate, String imageUrl) {
		  super();
		  this.movieName = movieName;
		  this.movieId = movieId;
		  this.releaseDate = releaseDate;
		  this.imageUrl = imageUrl;
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

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
