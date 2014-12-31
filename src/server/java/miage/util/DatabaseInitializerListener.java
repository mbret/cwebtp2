package miage.util;

import miage.dao.DirectoryDAO;
import miage.dao.MessageDAO;
import miage.model.*;
import org.apache.log4j.Logger;
import miage.dao.UserDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;

/**
 * This class is a listener that create the database after all server start
 * This is for development only.
 */
public class DatabaseInitializerListener implements ServletContextListener{

    private static final Logger logger = Logger.getLogger(DatabaseInitializerListener.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.debug("Started...");

        // Fill database
        UserDAO userDao = new UserDAO();
        DirectoryDAO directoryDAO = new DirectoryDAO();
        MessageDAO messageDAO = new MessageDAO();

        userDao.autoTransaction = false;
        userDao.getTransaction().begin();

        // Users
        Company companyA = new Company( new User("companya@user.com", "password"), "Company A" );
        userDao.save( companyA );
        Company companyB = new Company( new User("companyb@user.com", "password"), "Company B" );
        userDao.save( companyB );
        Particular particularA = new Particular( new User("particulara@user.com", "password"), "Maxime", "Bret", new Date());
        userDao.save( particularA );

        // Messages
        messageDAO.save( new Message("A message", "Hello company A", companyB, companyA) ); // We can use this method to save normal message
        companyA.getMessagesSent().add( new Message("One message", "Hello company B", companyA, companyB) ); // We can use this method thanks to the @OneToMany in user and CascadeType.ALL (Important)

        // Directories
        Directory directoryA = new Directory( "General directory" );
        directoryDAO.save(directoryA);
        Directory directoryCompany = new Directory( "Company directory" );
        directoryDAO.save(directoryCompany);
        Directory directoryParticular = new Directory( "Company particular" );
        directoryDAO.save(directoryParticular);

        directoryA.addUser( companyA ); // This is possible thanks to the join and Cascade
        directoryA.addUser( companyB );
        directoryA.addUser( particularA );

        directoryCompany.addUser( companyA );
        directoryCompany.addUser( companyB );
        directoryParticular.addUser( particularA );

        userDao.getTransaction().commit();
        userDao.autoTransaction = true;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug("Done!");
    }
}
