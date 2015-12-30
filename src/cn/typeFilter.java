package cn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by doctli on 2015/12/24.
 */
@WebFilter(filterName = "typeFilter")
public class typeFilter implements Filter {
    public void destroy() {
    }
    
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }
    
    public void init(FilterConfig config) throws ServletException {
        
    }
    
}
