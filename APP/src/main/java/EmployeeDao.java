import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class EmployeeDao {
private Connection connection;
	
	public EmployeeDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void insert(Employee employee) {
		String sql = "insert into employee " +
				"(NAME,ADRESS, DATE_OF_BIRTH,CPF,EMAIL,PHONE,STORE_ID)" +
				"values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, employee.getName());
			stmt.setString(2, employee.getAdress());
			
			stmt.setDate(3, new Date(employee.getDate_of_birth().getTime()));
			
			stmt.setString(4, employee.getCpf());
			stmt.setString(5, employee.getEmail());
			stmt.setString(6, employee.getPhone());
			stmt.setInt(7, employee.getStore_id());
			
			stmt.execute();
			stmt.close();
			
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Employee> getList(){
		try {
			List<Employee> clients = new ArrayList<Employee>();
			PreparedStatement stmt;
			stmt = this.connection.prepareStatement("select * from employee");			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setAdress(rs.getString("adress"));;
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("date_of_birth"));
				employee.setDate_of_birth(new Date(date.getTimeInMillis()));
				employee.setCpf(rs.getString("cpf"));
				employee.setEmail(rs.getString("email"));
				employee.setPhone(rs.getString("phone"));
				employee.setStore_id(rs.getInt("store_id"));
				
				clients.add(employee);
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
