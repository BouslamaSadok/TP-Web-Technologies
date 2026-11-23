import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Recuperer le username
        String username = request.getParameter("username");

        // 2. Creer ou recuperer la session
        HttpSession session = request.getSession();

        // 3. Stocker le username dans la session
        session.setAttribute("user", username);

        // 4. Afficher une confirmation
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h1>Bienvenue " + username + " !</h1>");

        out.println("<p>Connexion reussie.</p>");

        out.println("<a href='items.html'>");
        out.println("Acceder a la liste des articles");
        out.println("</a>");

        out.println("</body>");
        out.println("</html>");
    }
}
