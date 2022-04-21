package it.engineering.web.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.engineering.web.configuration.MyIoCConfiguration;
import it.engineering.web.domain.User;


/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyIoCConfiguration.class);
    	sce.getServletContext().setAttribute("application-context", applicationContext);
    	List<User> activeUsers = new ArrayList<>();
		sce.getServletContext().setAttribute("activeUsers", activeUsers);
         
    }
	
}
