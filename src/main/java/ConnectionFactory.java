import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = System.getenv("DATABASE_URL");
			System.out.println(url);
			if (url == null){
				return DriverManager.getConnection(
						"jdbc:postgresql://localhost:5432/trabalhofinal", "postgres",
						"");
			}
			else{
				return DriverManager.getConnection(url);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
