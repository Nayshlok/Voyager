package models;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@javax.servlet.annotation.WebListener
public class WebListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
				
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.setAttribute("data", new DatabaseAccess());
	}
}
