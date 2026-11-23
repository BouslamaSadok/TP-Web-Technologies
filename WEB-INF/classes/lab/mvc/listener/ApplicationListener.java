package lab.mvc.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("ApplicationListener : Application demarree");

        ServletContext context = sce.getServletContext();

        context.setAttribute("appName", "ING1 Web Application");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("ApplicationListener : Application arretee");
    }
}