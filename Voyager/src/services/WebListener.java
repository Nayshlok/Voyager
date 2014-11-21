package services;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("voyagerUnit");
		EntityManagerDataService emds = new EntityManagerDataService();
		emds.em = emf.createEntityManager();
		context.setAttribute("data", emds);
	}
}
