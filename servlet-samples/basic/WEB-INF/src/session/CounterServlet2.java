package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CounterServlet2 extends HttpServlet{

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
				
		//�Z�b�V�����̎擾
		HttpSession session = request.getSession();
		
		//�Z�b�V��������I�u�W�F�N�g�̎擾
		Integer count = (Integer)session.getAttribute("count");

		//�J�E���^�� +1
		if(count == null){
			count = new Integer(0);
		}		
		count = new Integer(count.intValue() + 1);
		
		//�Z�b�V�����ɃI�u�W�F�N�g�̊i�[
		session.setAttribute("count", count);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>sessionId=" + session.getId());
		out.print("<p>count=" + count);
		String linkUrl = request.getRequestURI();
		linkUrl = response.encodeURL(linkUrl);//URL rewiring
		out.println("<p><a href=\"" +linkUrl+ "\">RELOAD</a>");
		out.println("</body></html>");

	}

}
