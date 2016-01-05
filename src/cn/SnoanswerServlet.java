package cn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by doctli on 2016/1/5.
 */
@WebServlet(name = "SnoanswerServlet",urlPatterns = {"/SnoanswerServlet"})
public class SnoanswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> Snonum=(List<String>) request.getSession().getAttribute("Snonum");
        int i=0;
        request.getSession().setAttribute("Sno",Snonum.get(i));
        String tag=request.getParameter("tag");
        switch (tag){
            case "pre":
                if(i>0){
                    i--;
                    request.getSession().setAttribute("Sno",Snonum.get(i));
                }
                break;
            case "nex":
                if(i<(Snonum.size()-1)){
                    i++;
                    request.getSession().setAttribute("Sno",Snonum.get(i));
                }
                break;
            case "fir":
                    request.getSession().setAttribute("Sno",Snonum.get(0));
                break;
            case "las":
                    request.getSession().setAttribute("Sno",Snonum.get(Snonum.size()-1));
                break;
        }
    }
}
