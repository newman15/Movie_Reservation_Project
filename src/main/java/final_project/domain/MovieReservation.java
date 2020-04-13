package final_project.domain;

public class MovieReservation {

	String movieName, personName;
	int ticketNumber, seatNumber;
	
	public MovieReservation(String movieName, String personName,
			int ticketNumber, int seatNumber) {
		super();
		this.movieName = movieName;
		this.personName = personName;
		this.ticketNumber = ticketNumber;
		this.seatNumber = seatNumber;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
}
