package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebFilter("/log")
public class LoginFilter implements Filter {
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain) throws IOException, ServletException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String fname=new LoginDAO().login(req);
		if(fname==null) {
			pw.println("Invalid login details...");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else {
		    req.setAttribute("name", fname);
		    chain.doFilter(req, res);//Linking Servlet_Program with same url_pattern
		}
	}

}
