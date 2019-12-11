package day1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Count1
 */
@WebServlet("/Count1")
public class Count1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		PrintWriter pw = response.getWriter();
		
		double one = Double.parseDouble(request.getParameter("addOne"));
		double two = Double.parseDouble(request.getParameter("addTwo"));
		pw.println("ºÍÎª:"+(one+two));
		
		pw.flush();
		pw.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
