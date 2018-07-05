import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RentalDao {

	private Connection connection;
	
	public RentalDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Rental rental) {
		String sql = "insert into rentals " +
				"(DATE_OF_RENTAL,DUE_DATE,CLIENT_ID,STORE_ID,MOVIE_ID)" +
				"values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(rental.getDate_of_rental().getTime());
			stmt.setDate(1, new Date(rental.getDate_of_rental().getTime()));
			stmt.setDate(2, new Date(rental.getDue_date().getTime()));
			stmt.setInt(4, rental.getClient_id());
			stmt.setInt(5, rental.getStore_id());
			stmt.setInt(6, rental.getMovie_id());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void deliver(int id) {
		try {
			String sql = "update rentals set date_of_delivery = ? where id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			stmt.setDate(1, new Date(date.getTime()));
			stmt.setInt(2, id);
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
 
	
	public List<Rental> getList(){
		try {
			List<Rental> rentals = new ArrayList<Rental>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select r.*, c.name, s.adress, m.title\n"
					+ "from rentals r\n"
					+ "join client c on r.client_id = c.id\n"
					+ "join store s on r.store_id = s.id\n"
					+ "join movie m on r.movie_id = m.id;");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setId(rs.getInt("id"));
				
				Calendar date_uno = Calendar.getInstance();
				date_uno.setTime(rs.getDate("date_of_rental"));
				rental.setDate_of_rental(new Date(date_uno.getTimeInMillis()));
				
				Calendar date_dos = Calendar.getInstance();
				date_dos.setTime(rs.getDate("date_of_rental"));
				rental.setDue_date(new Date(date_dos.getTimeInMillis()));
				
				if (rs.getDate("date_of_delivery") == null){
					rental.setDate_of_delivery(null);
				}else{
					Calendar date_tres = Calendar.getInstance();
					date_tres.setTime(rs.getDate("date_of_delivery"));
					rental.setDate_of_delivery(new Date(date_tres.getTimeInMillis()));
				}
				
				
				rental.setClient_id(rs.getInt("client_id"));
				rental.setStore_id(rs.getInt("store_id"));
				rental.setMovie_id(rs.getInt("movie_id"));
				rental.setClient_name(rs.getString("name"));
				rental.setMovie_title(rs.getString("title"));
				rental.setStore_adress(rs.getString("adress"));
				
				rentals.add(rental);
			}
			rs.close();
			stmt.close();
			return rentals;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	
	}
	
	public List<Rental> getOpenList(){
		try {
			List<Rental> rentals = new ArrayList<Rental>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select r.*, c.name, s.adress, m.title\n"
					+ "from rentals r\n"
					+ "join client c on r.client_id = c.id\n"
					+ "join store s on r.store_id = s.id\n"
					+ "join movie m on r.movie_id = m.id\n"
					+ "where date_of_delivery is null;");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Rental rental = new Rental();
				rental.setId(rs.getInt("id"));
				
				Calendar date_uno = Calendar.getInstance();
				date_uno.setTime(rs.getDate("date_of_rental"));
				rental.setDate_of_rental(new Date(date_uno.getTimeInMillis()));
				
				Calendar date_dos = Calendar.getInstance();
				date_dos.setTime(rs.getDate("date_of_rental"));
				rental.setDue_date(new Date(date_dos.getTimeInMillis()));
				
				rental.setDate_of_delivery(null);
				
				rental.setClient_id(rs.getInt("client_id"));
				rental.setStore_id(rs.getInt("store_id"));
				rental.setMovie_id(rs.getInt("movie_id"));
				rental.setClient_name(rs.getString("name"));
				rental.setMovie_title(rs.getString("title"));
				rental.setStore_adress(rs.getString("adress"));
				
				rentals.add(rental);
			}
			rs.close();
			stmt.close();
			return rentals;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}	
	}
	
	
}
