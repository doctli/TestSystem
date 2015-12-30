package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by doctli on 2015/12/24.
 */
@WebServlet(name = "testsubmitServlet",urlPatterns = {"/testsubmitServlet"})
public class testsubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Sno=request.getParameter("Sno");
        String Pno=request.getParameter("Pno");
        String sql=null;
        String[] Qnum={"01","02","03","04","05","06","07","08","09","10"};
        DB db=new DB();
        for(int i=0;i<Qnum.length;i++){
            sql="insert into testsystem.answer values ('"+Sno+"','"+Pno+"','"+Qnum[i]+"','"+request.getParameter(Qnum[i])+"',null);";
            db.update(sql);
            System.out.println(sql);
        }
        response.sendRedirect("student.jsp");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
