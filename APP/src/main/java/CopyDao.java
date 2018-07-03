
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class CopyDao {
private Connection connection;
	
	public CopyDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Copy copy) {
		String sql = "insert into copy " +
				"(STORE_ID,MOVIE_ID,TOTAL,AVAILABLE)" +
				"values (?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, copy.getStore_id());
			stmt.setInt(2, copy.getMovie_id());
			stmt.setInt(3, copy.getTotal());
			stmt.setInt(3, copy.getAvailable());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Copy> getList(){
		try {
			List<Copy> copies = new ArrayList<Copy>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from copy");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Copy copy = new Copy();
				copy.setStore_id(rs.getInt("store_id"));
				copy.setMovie_id(rs.getInt("movie_id"));
				copy.setTotal(rs.getInt("total"));
				copy.setAvailable(rs.getInt("available"));
				
				
				copies.add(copy);
			}
			rs.close();
			stmt.close();
			return copies;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
			
	}
	
}

