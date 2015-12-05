package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by doctli on 2015/12/5.
 */
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = null;
        String sql;
        if (request.getParameter("userno") != (null)) {
            sql = "select * from testmanage.student where student_no='" + request.getParameter("userno") + "';";
            try {
                ResultSet rs = (new DB().search(sql));
                while (rs.next()) {
                    username = rs.getString("student_name");
                }
                if (!username.equals(null)) {
                    System.err.println("username!=null1  " + username);
                    request.getSession().setAttribute("username", username);
                    System.err.println("username!=null2  " + username);
                   response.sendRedirect("student.jsp");

                    System.err.println("username!=null3  " + username);
                } else {
                    System.err.println("username.equals(null)" + username);
                }
            } catch (Exception e) {
            }
        }
    }
}
