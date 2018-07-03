import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClientDao {

	private Connection connection;
	
	public ClientDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Client client) {
		String sql = "insert into client " +
				"(NAME,ADRESS, DATE_OF_BIRTH,CPF,EMAIL,PHONE,PASSWD)" +
				"values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, client.getName());
			stmt.setString(2, client.getAdress());
			
			stmt.setDate(3, new Date(client.getDate_of_birth().getTime()));
			
			stmt.setString(4, client.getCpf());
			stmt.setString(5, client.getEmail());
			stmt.setString(6, client.getPhone());
			stmt.setString(7, client.getPasswd());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Client> getList(){
		try {
			List<Client> clients = new ArrayList<Client>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from client");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Client client = new Client();
				client.setId(rs.getInt("id"));
				client.setName(rs.getString("name"));
				client.setAdress(rs.getString("adress"));;
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("date_of_birth"));
				client.setDate_of_birth(new Date(date.getTimeInMillis()));
				client.setCpf(rs.getString("cpf"));
				client.setEmail(rs.getString("email"));
				client.setPhone(rs.getString("phone"));
				client.setPasswd(rs.getString("passwd"));
				
				clients.add(client);
			}
			rs.close();
			stmt.close();
			return clients;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
		
		
	}
	
	
}
