package lab.mvc.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SessionAttributeListener
        implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println(
            "Attribut ajoute : " + event.getName()
            + " = " + event.getValue()
        );
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println(
            "Attribut modifie : " + event.getName()
            + " = " + event.getValue()
        );
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println(
            "Attribut supprime : " + event.getName()
            + " = " + event.getValue()
        );
    }
}