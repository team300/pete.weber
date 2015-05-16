package reqattr;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {
    
    private int hit = new Random().nextInt(10);


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
            path = "/reqattr/guess.jsp";
        }else{
            if(hit == number){
                request.setAttribute("message", "������B����=" + number);
                path = "/reqattr/guess_hit.jsp";
            }else{
                request.setAttribute("message", "�͂���B����=" + number);
                path = "/reqattr/guess.jsp";
            }
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
}
