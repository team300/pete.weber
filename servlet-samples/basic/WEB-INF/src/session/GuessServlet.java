package session;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GuessServlet extends HttpServlet {

    //private int hit = new Random().nextInt(10);    
    
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String numberStr = request.getParameter("number");

        String error = null;
        int number = -1;

        if(numberStr == null || numberStr.length() == 0){
            error = "��������Ă�";
        }
        
        if(error == null){
	        try{
	            //���l�`�F�b�N�����l�ɕϊ�
	            number = Integer.parseInt(numberStr);
	            //�Ó����`�F�b�N
	            if( number < 0 || 9 < number ){
	                error = "0����9�܂ł̐��������Ă�������";
	            }
	            
	        }catch(NumberFormatException e) {
	            error = "���������Ă�������";
	        }
        }
      

        String path;
        
        if(error != null){
            request.setAttribute("message", error);
            path = "/session/guess.jsp";
        }else{

            //�Z�b�V�������瓖���萔�����擾
            //�Ȃ���΍��
            HttpSession session = request.getSession();
            Integer hit = (Integer)session.getAttribute("hit");
            if(hit == null){
                hit = new Integer(new Random().nextInt(10));
                session.setAttribute("hit", hit);
            }
            
            if(hit.intValue() == number){
                request.setAttribute("message", "������B����=" + number);
                path = "/session/guess_hit.jsp";

                //�������炠���萔�����N���A
                session.removeAttribute("hit");
            }else{
                request.setAttribute("message", "�͂���B����=" + number);
                path = "/session/guess.jsp";
            }

        }


		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);

    }
}
