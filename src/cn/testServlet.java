package cn;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by doctli on 2015/11/30.
 */
@WebServlet(name = "cn.testServlet")
public class testServlet extends HttpServlet {


    protected void service(HttpServletRequest request,HttpServletResponse response){
        String method=request.getParameter("method");
        if(method!=null&&"".equals(method.trim())){
            //method参数出错
        }
        else{
            //反射
            Method m=null;
            try {
                m=this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            try {
                m.invoke(request,response);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            }

        }
    public void fun1(HttpServletRequest request,HttpServletResponse response){
        try {
            response.getWriter().print("fun1……");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

