package by.bsuir.journal.listener;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.URL;

/**
 * Created by Veronika.
 * http://web.archive.org/web/20150201070907/http://javaxblog.ru/article/java-struts-3/
 */
public class HibernateListener implements ServletContextListener {
    private Configuration config;
    private SessionFactory factory;
    private static ServiceRegistry registry;
    private static final String KEY_NAME = HibernateListener.class.getName();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            String path = "/resources/hibernate.cfg.xml";
            URL url = HibernateListener.class.getResource(path);
            config = new Configuration().configure(url);
            registry = new ServiceRegistryBuilder().applySettings(
                    config.getProperties()). buildServiceRegistry();
            factory = config.buildSessionFactory(registry);

            //save the Hibernate session factory into serlvet context
            servletContextEvent.getServletContext().setAttribute(KEY_NAME, factory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public Configuration getConfig() {
        return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    public static String getKeyName() {
        return KEY_NAME;
    }
}
