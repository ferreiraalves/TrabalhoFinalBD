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

@WebServlet("/insert-movie")
public class MovieInsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		String title = req.getParameter("title");
		String release_date_text = req.getParameter("release_date");
		int rating = Integer.parseInt(req.getParameter("rating"));
		int director_id = Integer.parseInt(req.getParameter("director_id"));
		
		Date parsed;
		try{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			parsed = new Date(format.parse(release_date_text).getYear(),format.parse(release_date_text).getMonth(),format.parse(release_date_text).getDay() );
		}catch(ParseException e){
			out.println("erro de conversao da data");
			return;
		}

		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setRelease_date(parsed);
		movie.setRating(rating);
		movie.setDirector_id(director_id);
		
		
		MovieDao dao = new MovieDao();
		dao.insert(movie);
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Filme "+ movie.getTitle() +" inserido</p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}
}
