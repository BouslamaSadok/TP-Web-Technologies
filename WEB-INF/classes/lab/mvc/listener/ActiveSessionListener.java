package lab.mvc.listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {

        int current = counter.incrementAndGet();

        ServletContext context =
                event.getSession().getServletContext();

        context.setAttribute("activeSessions", current);

        System.out.println("Nouvelle session. Sessions actives : " + current);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        int current = counter.decrementAndGet();

        ServletContext context =
                event.getSession().getServletContext();

        context.setAttribute("activeSessions", current);

        System.out.println("Session detruite. Sessions actives : " + current);
    }
}