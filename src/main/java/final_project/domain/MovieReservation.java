package final_project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class MovieReservation {

	@Id
	@GeneratedValue
	private long id;
	
    private String movieName, showTime;
    private int numberOfTickets;
    
    public MovieReservation() {
    	movieName = null;
    	showTime = null;
    	numberOfTickets = 0;
    }
    
    public MovieReservation(Movie movieName, int numberOfTickets, String showTime)
    {
        this.movieName = movieName.getMovieName();
        this.numberOfTickets = numberOfTickets;
        this.showTime = showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

    
}