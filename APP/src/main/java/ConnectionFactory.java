import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/trabalho final", "postgres",
					"606238");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
