package miage.util;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




public class HibernateListener implements ServletContextListener {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(HibernateListener.class);

    /**
     * This method is call when the program is started (when server start for example)
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {
        logger.debug("Started...");
        HibernateUtil.getSessionFactory(); // Just call the static initializer of that class
    }

    /**
     * This method is call when the java program is shutdown (server shutdown for exemple)
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {
        HibernateUtil.getSessionFactory().close(); // Free all resources
        logger.debug("Done!");
    }
}