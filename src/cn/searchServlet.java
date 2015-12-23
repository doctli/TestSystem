package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.ResultSet;

/**
 * Created by doctli on 2015/12/19.
 */
@WebServlet(name = "SearchServlet",urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {


    ResultSet rs=null;
    public  SearchServlet() {
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,

            IOException
    {
        String tag = request.getParameter("tag");
        try
        {
            Method method = this.getClass().getDeclaredMethod(tag, new Class[] {HttpServletRequest.class, HttpServletResponse.class });
            method.invoke(this, new Object[] { request, response });
        } catch (Exception e) {e.printStackTrace();}
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        rs=new DB().search("select subject,score from testsystem.courseschedule where Sno='"+request.getSession().getAttribute("userno")+"';");
        request.getSession().setAttribute("sresultset",rs);
        response.sendRedirect("goalsearch.jsp");
        System.out.println("all");
    }

    public void pass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        rs=new DB().search("select subject,score from testsystem.courseschedule where Sno='"+request.getSession().getAttribute("userno")+"HAVING score>60"+"';");
        request.getSession().setAttribute("sresultset",rs);
        response.sendRedirect("goalsearch.jsp");
        System.out.print("pass");
    }

    public void notpass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        rs=new DB().search("select subject,score from testsystem.courseschedule where Sno='"+request.getSession().getAttribute("userno")+"HAVING score>60"+"';");
        request.getSession().setAttribute("sresultset",rs);
        response.sendRedirect("goalsearch.jsp");
        System.out.println("notpass");
    }

}