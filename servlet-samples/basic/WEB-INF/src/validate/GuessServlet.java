package validate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

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
      
        response.setContentType("text/plain; charset=Windows-31J");        
        PrintWriter out = response.getWriter();  

        if(error != null){
            out.println(error);
        }else{

            out.println("�����F" + number);
            
            if(hit == number){
                out.println("������I");
            }else{
                out.println("�͂���");
            }            
        }
    }
}
