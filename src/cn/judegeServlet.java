package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by doctli on 2016/1/4.
 */
@WebServlet(name = "judegeServlet",urlPatterns = {"/judegeServlet"})
public class judegeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Pnojudege=request.getParameter("Pnojudege");
        System.out.println("请求批改试卷"+Pnojudege);
        request.getSession().setAttribute("Pnojudege",Pnojudege);
        response.sendRedirect("answerjudege.jsp");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
