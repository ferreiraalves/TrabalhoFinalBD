
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

@WebServlet("/insert-copy")
public class CopyInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		int store_id = Integer.parseInt(req.getParameter("store_id"));
		int movie_id = Integer.parseInt(req.getParameter("movie_id"));
		int total = Integer.parseInt(req.getParameter("total"));
		int available = Integer.parseInt(req.getParameter("available"));
		


		Copy copy = new Copy();
		copy.setStore_id(store_id);
		copy.setMovie_id(movie_id);
		copy.setTotal(total);
		copy.setAvailable(available);
		
		
		CopyDao dao = new CopyDao();
		dao.insert(copy);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Copy inserted</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}


