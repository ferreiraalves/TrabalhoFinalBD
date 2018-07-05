
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-open-rentals")
public class RentalListOpenServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		RentalDao dao = new RentalDao();
		List <Rental> rentals =  dao.getOpenList();
		
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
		out.println("table {");
		out.println("    font-family: arial, sans-serif;");
		out.println("    border-collapse: collapse;");
		out.println("    width: 100%;");
		out.println("}");
		out.println("td, th {");
		out.println("    border: 1px solid #dddddd;");
		out.println("    text-align: left;");
		out.println("    padding: 8px;");
		out.println("}");
		out.println("tr:nth-child(even) {");
		out.println("    background-color: #dddddd;");
		out.println("}");
		out.println("  </style>");
		out.println("  <title>Rentals</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("  <div class=\"centeredColumn\">");		
		out.println("    <img src=\"https://cdn.discordapp.com/attachments/404053019827896333/463500783959146499/move.png\" height=\"20%\" width=\"20%\" alt=\"logo\">");		out.println("    <div class=\"\">");
		out.println("      <a href=\"/\">Home</a>");
		out.println("      <a href=\"/list-clients\">Clientes</a>");
		out.println("      <a href=\"/list-employees\">Employees</a>");
		out.println("      <a href=\"/list-stores\">Stores</a>");
		out.println("      <a href=\"/list-movies\">Movies</a>");
		out.println("      <a href=\"/list-copies\">Copies</a>");
		out.println("      <a href=\"/list-rentals\">Rentals</a>");
		out.println("    </div>");
		out.println("  </div>");
		out.println("  	<h1 id=\"title\" class=\"display-4\" style=\"text-align: center;\">Rentals</h1>");
		out.println("  <div class=\"content centeredColumn\">");
		out.println("      <a href=\"/list-rentals\">All rentals</a>");
		out.println("   <table>");
		out.println("   <tr>");
		out.println("   <th>Id</th>");
		out.println("   <th>Date of Rental</th>");
		out.println("   <th>Due Date</th>");
		out.println("   <th>Date of Delievery</th>");
		out.println("   <th>Client Name</th>");
		out.println("   <th>Store Adress</th>");
		out.println("   <th>Movie Title</th>");
		out.println("   <th>Delivery</th>");
		out.println("   </tr>");
		
		
		for (Rental rental : rentals) {
			
			
			out.println("<tr>");
            out.println("<td>" + rental.getId() + "</td>");
            out.println("<td>" + rental.getDate_of_rental() + "</td>");
            out.println("<td>" + rental.getDue_date() + "</td>");
            out.println("<td>" + rental.getDate_of_delivery() + "</td>");
            out.println("<td>" + rental.getClient_name() + "</td>");
            out.println("<td>" + rental.getStore_adress() + "</td>");
            out.println("<td>" + rental.getMovie_title() + "</td>");
            if(rental.getDate_of_delivery() == null){
                out.println("<td>");
        		out.println("<form action = \"deliver\" method = \"POST\">");
        		out.println("<input type=\"hidden\" name=\"rental_id\" value=\"" + rental.getId() + "\" />");
        		out.println("<input type=\"submit\" value=\"Deliver\"/><br/ >");
                out.println("</td>");
        		
            }else{
            	out.println("<td>Closed</td>");
            }
            out.println("</tr>");

		}
		out.println("</table>");
		out.println("  </div>");
		out.println("  </body>");
		out.println(" </html>");
		out.close();
		
	}
}


