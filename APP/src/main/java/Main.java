import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//int year = 1953; int month = 10; int day = 01;
		//Date data = new Date(year-1900,day-1,day);
		
		//Client client = new Client("Sandra", "Palmeiras", data ,"123415123", "sandra@email", "103123131", "1234123");
		
		//System.out.println(client.getDate_of_birth());
		ClientDao dao = new ClientDao();
		
		//dao.insert(client);
		
		List <Client> clients =  dao.getList();
		
		for (Client client : clients) {
			System.out.println("Id: " + client.getId());
			System.out.println("Nome: " + client.getName());
			System.out.println("Adress: " + client.getAdress());
			System.out.println("Date of Birth: " + client.getDate_of_birth());
			System.out.println("CPF: " + client.getCpf());
			System.out.println("email: " + client.getPhone());
			System.out.println("passwd: " + client.getPasswd());
			System.out.println();
		}
		
		
	}
}
