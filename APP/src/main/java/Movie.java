import java.sql.Date;


public class Movie {
	private int id;
	private String title;
	private Date release_date;
	private int rating;
	private int director_id;
	
	public Movie (){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getDirector_id() {
		return director_id;
	}

	public void setDirector_id(int director_id) {
		this.director_id = director_id;
	}

	
}
