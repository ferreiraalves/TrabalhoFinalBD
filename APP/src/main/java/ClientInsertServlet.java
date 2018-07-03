import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert-client")
public class ClientInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		String adress = req.getParameter("adress");
		String date_of_birth_text = req.getParameter("date_of_birth");
		String cpf = req.getParameter("cpf");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String passwd = req.getParameter("passwd");
		
		Date parsed;
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			parsed = new Date(format.parse(date_of_birth_text).getYear(),format.parse(date_of_birth_text).getMonth(),format.parse(date_of_birth_text).getDay() );
		}catch(ParseException e){
			out.println("erro de conversao da data");
			return;
		}

		Client client = new Client();
		client.setName(name);
		client.setAdress(adress);
		client.setDate_of_birth(parsed);
		client.setCpf(cpf);
		client.setEmail(email);
		client.setPhone(phone);
		client.setPasswd(passwd);
		
		
		ClientDao dao = new ClientDao();
		dao.insert(client);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Cliente "+ client.getName() +" inserido</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}
