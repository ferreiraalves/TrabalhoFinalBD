
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new-copy")
public class CopyFormServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		
        out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("  <meta charset=\"utf-8\">");
		out.println("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("  <style>");
		out.println("    .centeredColumn {");
		out.println("    display: flex;");
		out.println("    flex-direction: column;");
		out.println("    align-items: center;");
		out.println("    justify-content: center;");
		out.println("  }");
		out.println("  a {");
		out.println("    padding: 0px 5px;");
		out.println("    text-decoration: none;");
		out.println("  }");
		out.println("  .content {");
		out.println("    width: 80vw;");
		out.println("    margin-left: 10vw;");
		out.println("    min-height: calc(100vh - 124px);");
		out.println("  }");
		out.println("  .submitButton {");
		out.println("    display: flex;");
		out.println("    align-items: center;");
		out.println("    justify-content: flex-end;");
		out.println("  }");
		out.println("  </style>");
		out.println("  <title>New Copy</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("  <div class=\"centeredColumn\">");		
		out.println("    <img src=\"https://cdn.discordapp.com/attachments/404053019827896333/463500783959146499/move.png\" height=\"20%\" width=\"20%\" alt=\"logo\">");		out.println("    <div class=\"\">");
		out.println("      <a href=\"/APP/\">Home</a>");
		out.println("      <a href=\"/APP/list-clients\">Clientes</a>");
		out.println("      <a href=\"/APP/list-employees\">Employees</a>");
		out.println("      <a href=\"/APP/list-stores\">Stores</a>");
		out.println("      <a href=\"/APP/list-movies\">Movies</a>");
		out.println("      <a href=\"/APP/list-copies\">Copies</a>");
		out.println("      <a href=\"/APP/list-rentals\">Rentals</a>");
		out.println("    </div>");
		out.println("  </div>");
		out.println("  	<h1 id=\"title\" class=\"display-4\" style=\"text-align: center;\">New Copy</h1>");
		out.println("  <div class=\"content centeredColumn\">");
		out.println("<form action = \"insert-copy\" method = \"POST\">");		
		out.println("Store ID: <input type=\"text\" name=\"store_id\"/><br/ >");
		out.println("Movie Id: <input type=\"text\" name=\"movie_id\"/><br/ >");
		out.println("Total Copies: <input type=\"text\" name=\"total\"/><br/ >");
		out.println("Available Copies: <input type=\"text\" name=\"available\"/><br/ >");
		out.println("<input type=\"submit\" value=\"save\"/><br/ >");
		
		out.println("</form>");
		out.println("  </div>");
		out.println("  </body>");
		out.println(" </html>");
		out.close();
		
		
	}
}


