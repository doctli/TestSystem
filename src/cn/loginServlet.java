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
            System.err.println(request.getParameter("userno")+request.getParameter("password")+request.getParameter("identity"));
            switch (identity){
                case "teacher":
                    try {
                        System.err.print("跳转到教师登录模块");
                        teacherlogin(request,response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "student":
                    try {
                        studentlogin(request,response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.err.print("什么地方也没去");
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
        System.out.println("进入教师模块");
        String no=request.getParameter("userno");
        String password=request.getParameter("password");
        System.out.println("获取到工号密码"+no+password);
        if(true) {
            sql = "select * from testsystem.teacherinfo where Wno='" + no + "';";
            System.err.print(sql);
            try {
                ResultSet rs = (new DB().search(sql));
                while (rs.next()) {
                    username = rs.getString("name");
                    System.err.print(username);
                    userpass = rs.getString("passwd");
                    System.err.print(userpass);
                }
                if(!username.equals(null)&&password.equals(userpass)){
                    System.err.print("教师登录成功");
                    request.getSession().setAttribute("userno", request.getParameter("userno"));
                    request.getSession().setAttribute("username", username);
                    String sqlt= "select * from testsystem.teachlist where Wno='" + no + "';";
                    ResultSet rst = (new DB().search(sqlt));
                    while (rst.next()) {
                        request.getSession().setAttribute("subject", rst.getString("subject"));
                    }
                    response.sendRedirect("teacher.jsp");
                }
                else {
                    response.sendRedirect("error.jsp");
                }
            }
            catch(Exception e){}
        }
    }
    public static boolean isInteger(String str) {                                  //判断一个字符串是否为数字
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
