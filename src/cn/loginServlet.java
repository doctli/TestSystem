package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.regex.Pattern;

/**
 * Created by doctli on 2015/12/5.
 */
@WebServlet(urlPatterns = {"/loginServlet"},name = "loginServlet")
public class loginServlet extends HttpServlet {
    String username = null;
    String userpass = null;
    String sql;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("userno") != (null)) {
            String identity=request.getParameter("identity");
            switch (identity){
                case "teacher":
                    teacherlogin(request,response);
                    break;
                case "student":
                    try {
                        studentlogin(request,response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }

        }
    }
    private void studentlogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String no=request.getParameter("userno");
        String password=request.getParameter("password");
        if(isInteger(no)) {
            sql = "select * from testsystem.studentinfo where Sno='" + no + "';";
            try {

                ResultSet rs = (new DB().search(sql));
                while (rs.next()) {
                    username = rs.getString("name");
                    userpass=rs.getString(4);
                }
                if (!username.equals(null)&&password.equals(userpass)) {
                    request.getSession().setAttribute("userno", request.getParameter("userno"));
                    request.getSession().setAttribute("username", username);
                    response.sendRedirect("student.jsp");
                } else {
                    System.err.println("username.equals(null)" + username);
                    try {
                        response.sendRedirect("error.jsp");
                    }
                    catch (Exception e){}
                }
            } catch (Exception e) {
            }
        }
        else {
            try {
                response.sendRedirect("error.jsp");
            }
            catch (Exception e){}
        }
    }
    private void teacherlogin(HttpServletRequest request, HttpServletResponse response){
        if(request.getParameter("userno").equals("teacher01")&&request.getParameter("password").equals("123")){
            request.getSession().setAttribute("username", "教师");
            try {
                response.sendRedirect("teacher.jsp");
            }
            catch (Exception e){}
        }
        else {
            try {
                response.sendRedirect("error.jsp");
            }
            catch (Exception e){}
        }

    }
    public static boolean isInteger(String str) {                                  //判断一个字符串是否为数字
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
