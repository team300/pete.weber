package init;

import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BBSServlet extends HttpServlet {

    private List<BBSMessage> chatList; 
    
    
    public void init() throws ServletException {

        chatList = new Vector<BBSMessage>();
    }

    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=Windows-31J");
        PrintWriter out = response.getWriter();

        //���̓p�����[�^�̎擾
        String user = request.getParameter("user");
        String message = request.getParameter("message");
        
        //���͂��������Ƃ��́AchatList�ɓ��͂̔�����ǉ�
        if(message != null){
            BBSMessage newBM = new BBSMessage();
            newBM.setUser(user);
            newBM.setMessage(message);            
        	chatList.add(newBM);
        }
        
        //�ȉ��͏o��
        out.println("<html><body>");
                
        String uri = request.getRequestURI();
        out.println("<a href=\"" +uri+ "\">�����[�h</a>");
        out.println("<form action=\"" +uri+ "\">");
        out.println("���O<input type=\"text\" name=\"user\"><br>");
        out.println("���b�Z�[�W<input type=\"text\" name=\"message\" size=\"60\">");
        out.println("<input type=\"submit\" value=\"����\"");
        out.println("</form>");
        
        //chatList�̈ꗗ���e�[�u���o��
        out.println("<table>");
        for(int i=chatList.size()-1; i>=0; i--){
            BBSMessage cm = chatList.get(i);
            out.println("<tr>");
            out.println("<td>" + cm.getUser());
            out.println("<td>:" + cm.getMessage());
        }        
        out.println("</table>");
        
        out.println("</body></html>");        
    }

        
    public void destroy() {
    }

}
