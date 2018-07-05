
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

@WebServlet("/deliver")
public class RentalDeliverServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String rental_id_text = req.getParameter("rental_id");
		int rental_id = Integer.parseInt(rental_id_text);			
		
		RentalDao dao = new RentalDao();
		dao.deliver(rental_id);
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Delivered "+ rental_id +"</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}


