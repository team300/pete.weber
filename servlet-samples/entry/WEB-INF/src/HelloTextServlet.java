import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloTextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
		throws ServletException, IOException {

		response.setContentType("text/plain; charset=Windows-31J");

		PrintWriter out = response.getWriter();
		out.println("���͂悤");
		out.println("����ɂ���");
		out.println("����΂��");
	}
}
