package foo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OmojanServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=Windows-31J");
        PrintWriter out = response.getWriter();

        String s = "<HTML>"
        		+ "<HEAD>"
                + "<TITLE>AI�ʐ�</TITLE>" 
                + "</HEAD>" 
                + "<BODY>" 
                //+ "<H2>�V���[��p�@���͂悤</H2>"
                + "<H2>" + new Omojan().getWord()+ "</H2>" 
                + "</BODY>" 
                + "</HTML>"
                ;

        out.println(s);
    }
}
