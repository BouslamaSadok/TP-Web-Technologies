
package lab.mvc.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Récupérer les données du formulaire
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        // 2. Créer un objet Person
        Person person = new Person(
            firstName, lastName, birthDay, sex
        );

        // 3. Ajouter le bean à la requête
        request.setAttribute("person", person);

        // 4. Extraire l'année de naissance
        int year = Integer.parseInt(
            birthDay.substring(birthDay.lastIndexOf("/") + 1)
        );

        // 5. Choisir la JSP appropriée
        String page;

        if (year < 1990) {
            page = "/jsp/old.jsp";
        } else {
            page = "/jsp/young.jsp";
        }

        // 6. Transmettre la requête à la JSP
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(page);

        dispatcher.forward(request, response);
    }
}
