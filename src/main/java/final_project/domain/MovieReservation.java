package final_project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class MovieReservation {

	@Id
	@GeneratedValue
	private long id;
	
    private String movieName;
    private int numberOfTickets;
    
    public MovieReservation() {
    	movieName = null;
    	numberOfTickets = 0;
    }
    
    public MovieReservation(Movie movieName, int numberOfTickets)
    {
        this.movieName = movieName.getMovieName();
        this.numberOfTickets = numberOfTickets;
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

    
}