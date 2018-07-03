
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MovieDao {

	private Connection connection;
	
	public MovieDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Movie movie) {
		String sql = "insert into movie " +
				"(TITLE, RELEASE_DATE,RATING,DIRECTOR_ID)" +
				"values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, movie.getTitle());
			stmt.setDate(2, new Date(movie.getRelease_date().getTime()));			
			stmt.setInt(3, movie.getRating());
			stmt.setInt(4, movie.getDirector_id());

			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Movie> getList(){
		try {
			List<Movie> movies = new ArrayList<Movie>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from movie");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Movie movie = new Movie();
				movie.setId(rs.getInt("id"));
				movie.setTitle(rs.getString("title"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("release_date"));
				movie.setRelease_date(new Date(date.getTimeInMillis()));
				movie.setRating(rs.getInt("rating"));
				movie.setDirector_id(rs.getInt("director_id"));
				
				movies.add(movie);
			}
			rs.close();
			stmt.close();
			return movies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
		
		
	}
	
	
}

