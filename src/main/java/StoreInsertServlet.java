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

@WebServlet("/insert-store")
public class StoreInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String adress = req.getParameter("adress");
		String phone = req.getParameter("phone");
		String manager_id_text = req.getParameter("manager_id");
		int manager_id = Integer.parseInt(manager_id_text);			


		Store store = new Store();
		store.setAdress(adress);
		store.setPhone(phone);
		store.setManager_ID(manager_id);
		
		
		StoreDao dao = new StoreDao();
		dao.insert(store);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Store "+ store.getAdress() +" inserted</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}

