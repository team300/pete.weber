package validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EtoServlet extends HttpServlet {
    
    final static String[] ETOS = new String[]{
            "�q(��)",
            "�N(����)",
            "��(�Ƃ�)",
            "�K(��)",
            "�C(����)",
            "��(��)",
            "��(����)",
            "��(�Ђ�)",
            "�\(����)",
            "��(�Ƃ�)",
            "��(����)",
            "��(��)",
    };
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        String yearStr = request.getParameter("year");
        int year = Integer.parseInt(yearStr);
        
        int index = (year + 8) % 12;   
        String etoText = ETOS[index];        

        response.setContentType("text/plain; charset=Windows-31J");        
        PrintWriter out = response.getWriter();  

        out.println("���Ȃ��̊��x�F" + etoText);
    }

}
