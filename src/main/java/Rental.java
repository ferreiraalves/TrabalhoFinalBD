import java.sql.Date;


public class Rental {
	private int id;
	private Date date_of_rental;
	private Date due_date;
	private Date date_of_delivery;
	private int client_id;
	private int store_id;
	private int movie_id;
	private String client_name;
	private String movie_title;
	private String store_adress;
	
	public Rental(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate_of_rental() {
		return date_of_rental;
	}
	public void setDate_of_rental(Date date_of_rental) {
		this.date_of_rental = date_of_rental;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDate_of_delivery() {
		return date_of_delivery;
	}
	public void setDate_of_delivery(Date date_of_delivery) {
		this.date_of_delivery = date_of_delivery;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getStore_adress() {
		return store_adress;
	}

	public void setStore_adress(String store_adress) {
		this.store_adress = store_adress;
	}
}
