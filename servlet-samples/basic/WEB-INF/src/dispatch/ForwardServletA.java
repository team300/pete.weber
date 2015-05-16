package dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServletA extends HttpServlet {

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("call ForwardServletA");
        
        RequestDispatcher dispatcher = request
                .getRequestDispatcher("/servlet/dispatch.ForwardServletB");

        dispatcher.forward(request, response);
    }
}
