
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class StoreDao {
private Connection connection;
	
	public StoreDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Store store) {
		String sql = "insert into store " +
				"(ADRESS,PHONE,MANAGER_ID)" +
				"values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, store.getAdress());
			stmt.setString(2, store.getPhone());
			stmt.setInt(3, store.getManager_ID());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Store> getList(){
		try {
			List<Store> stores = new ArrayList<Store>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from store");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Store store = new Store();
				store.setId(rs.getInt("id"));
				store.setAdress(rs.getString("adress"));
				store.setPhone(rs.getString("phone"));
				store.setManager_ID(rs.getInt("manager_id"));
				
				stores.add(store);
			}
			rs.close();
			stmt.close();
			return stores;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
			
	}
	
}

