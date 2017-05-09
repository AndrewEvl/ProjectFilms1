package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lino on 09.05.2017.
 */
@WebFilter ({"/filmsave", "/actdirsave"})
public class adminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String  admin ="User";
            Object role = httpServletRequest.getSession().getAttribute("userRole");
            if (admin.equals(role) && !httpServletRequest.getRequestURI().contains("/login")) {
                ((HttpServletResponse)servletResponse).sendRedirect("/login");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
