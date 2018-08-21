import javax.servlet.*;
import java.io.*;

public class MyFirstServlet extends GenericServlet{
	public void init(){
			System.out.println("init method is called");
	}
	
	public void service(ServletRequest request,
		ServletResponse response)
		throws ServletException, IOException{
		
		System.out.println("service method is called");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("Congratulation. <br> My First Servlet is working!");
		writer.close();
	}

}