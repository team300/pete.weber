package validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EtoServlet2 extends HttpServlet {
    
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

        String error = null;
        String etoText = null;

        if(yearStr == null || yearStr.length() == 0){
            error = "��������Ă�";
        }
        
        if(error == null){
	        try{
	            //���l�`�F�b�N�����l�ɕϊ�
	            int year = Integer.parseInt(yearStr);
	            //�Ó����`�F�b�N
	            if(year < 0){
	                error = "�I���O�̐l�̓T�|�[�g�O�ł�";
	            }else{
	            	int index = (year + 8) % 12;   
	            	etoText = ETOS[index];
	            }
	            
	        }catch(NumberFormatException e) {
	            error = "�N�����Ă�������";
	        }
        }
      
        response.setContentType("text/plain; charset=Windows-31J");        
        PrintWriter out = response.getWriter();  

        if(error != null){
            out.println(error);
        }else{
            out.println("���Ȃ��̊��x�F" + etoText);
        }
    }

}
