import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list-employees")
public class EmployeeListServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		EmployeeDao dao = new EmployeeDao();
		List <Employee> employees =  dao.getList();
		
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
		out.println("  <title>Clientes</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("  <div class=\"centeredColumn\">");		
		out.println("    <img src=\"https://cdn.discordapp.com/attachments/404053019827896333/463500783959146499/move.png\" height=\"20%\" width=\"20%\" alt=\"logo\">");		out.println("    <div class=\"\">");
		out.println("      <a href=\"/APP/\">Home</a>");
		out.println("      <a href=\"/APP/list-clients\">Clientes</a>");
		out.println("      <a href=\"/APP/list-employees\">Employees</a>");
		out.println("      <a href=\"/APP/list-stores\">Stores</a>");	
		out.println("      <a href=\"/APP/list-movies\">Movies</a>");		
		out.println("    </div>");
		out.println("  </div>");
		out.println("  	<h1 id=\"title\" class=\"display-4\" style=\"text-align: center;\">Clients</h1>");
		out.println("  <div class=\"content centeredColumn\">");
		out.println("      <a href=\"/APP/new-employee\">New Employee</a>");
		out.println("   <table>");
		out.println("   <tr>");
		out.println("   <th>Id</th>");
		out.println("   <th>Name</th>");
		out.println("   <th>Adress</th>");
		out.println("   <th>Date of Birth</th>");
		out.println("   <th>CPF</th>");
		out.println("   <th>emal</th>");
		out.println("   <th>phone</th>");
		out.println("   <th>store_id</th>");
		out.println("   </tr>");
		
		
		for (Employee employee : employees) {
			
			
			out.println("<tr>");
            out.println("<td>" + employee.getId() + "</td>");
            out.println("<td>" + employee.getName() + "</td>");
            out.println("<td>" + employee.getAdress() + "</td>");
            out.println("<td>" + employee.getDate_of_birth() + "</td>");
            out.println("<td>" + employee.getCpf() + "</td>");
            out.println("<td>" + employee.getEmail() + "</td>");
            out.println("<td>" + employee.getPhone() + "</td>");
            out.println("<td>" + employee.getStore_id() + "</td>");
    		out.println("</tr>");

		}
		out.println("</table>");
		out.println("  </div>");
		out.println("  </body>");
		out.println(" </html>");
		out.close();
		
	}
}

