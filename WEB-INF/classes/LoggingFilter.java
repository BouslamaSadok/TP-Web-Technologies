import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("[LoggingFilter] init : filtre initialisé");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("[LoggingFilter] AVANT  : " + req.getRequestURL());

        chain.doFilter(request, response);   // continue vers le servlet

        System.out.println("[LoggingFilter] APRÈS  : traitement terminé");
    }

    @Override
    public void destroy() {
        System.out.println("[LoggingFilter] destroy : filtre détruit");
    }
}