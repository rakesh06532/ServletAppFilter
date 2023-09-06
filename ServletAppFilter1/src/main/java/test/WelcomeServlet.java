package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/log")
public class WelcomeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws IOException, ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String name=(String)req.getAttribute("name");
		pw.println("Welcome: "+name+"<br>");
	}

}
