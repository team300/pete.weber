package http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoServlet extends HttpServlet {

    public void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain; charset=Windows-31J");
        PrintWriter out = response.getWriter();

        out.println(
            "���Ȃ��̃A�N�Z�X�����y�[�W"+ "\n"
            + request.getRequestURL() + "\n"
            + "\n"
            + "�����p�̃u���E�U�͂��Ԃ�" + "\n"
            + request.getHeader("USER-AGENT") + "\n"
            + "\n"
            + "�����N����" + "\n"
            + request.getHeader("REFERER") + "\n"
            + "\n"
            + "IP�A�h���X��\n"
            + request.getRemoteAddr()
        );
    }

}
