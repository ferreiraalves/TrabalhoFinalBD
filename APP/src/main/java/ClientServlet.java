import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clients")
public class ClientServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		ClientDao dao = new ClientDao();
		List <Client> clients =  dao.getList();
		
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
		out.println("  <title>Clientes</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("  <div class=\"centeredColumn\">");		
		out.println("    <img src=\"https://sambatech.com/wp-content/themes/tema-sambatech/home-samba-play-2017/img/logo-sambatech-rodape.png\" alt=\"logo\">");
		out.println("    <div class=\"\">");
		out.println("      <a href=\"/\">Home</a>");
		out.println("      <a href=\"/result\">Catalogo</a>");
		out.println("    </div>");
		out.println("  </div>");
		out.println("  	<h1 id=\"title\" class=\"display-4\" style=\"text-align: center;\">Clientes</h1>");
		out.println("  <div class=\"content centeredColumn\">");
		
		for (Client client : clients) {
			out.println("<div class=\"jumbotron\">");
            out.println("<p> Id: " + client.getId() + "</p>");
            out.println("<p> Name: " + client.getName() + "</p>");
            out.println("<p> Adress: " + client.getAdress() + "</p>");
            out.println("<p> Date of Birth: " + client.getDate_of_birth() + "</p>");
            out.println("<p> CPF: " + client.getCpf() + "</p>");
            out.println("<p> Email: " + client.getEmail() + "</p>");
            out.println("<p> Phone: " + client.getPhone() + "</p>");
            out.println("<p> Password: " + client.getPasswd() + "</p>");
            out.println("</div>");
		}
		
		out.println("  </div>");
		out.println("  </body>");
		out.println(" </html>");
		out.close();
		
		
		
		
		
	}
}
