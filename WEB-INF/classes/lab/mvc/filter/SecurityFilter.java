
package lab.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/ListItems")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        // Verifier si une session existe deja
        HttpSession session = httpRequest.getSession(false);

        // Verifier si l'utilisateur est connecte
        if (session != null && session.getAttribute("user") != null) {

            System.out.println("SecurityFilter : Acces autorise");

            chain.doFilter(request, response);

        } else {

            System.out.println("SecurityFilter : Acces refuse");

            httpResponse.sendRedirect(
                httpRequest.getContextPath() + "/login.html"
            );
        }
    }
}
