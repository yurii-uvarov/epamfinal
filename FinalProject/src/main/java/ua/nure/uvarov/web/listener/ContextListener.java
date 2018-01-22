package ua.nure.uvarov.web.listener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import ua.nure.uvarov.constants.Parameters;
import ua.nure.uvarov.dao.UserDao;
import ua.nure.uvarov.dao.mysql.UserDaoImpl;
import ua.nure.uvarov.exceptions.AppInitializationException;
import ua.nure.uvarov.services.RegisterService;
import ua.nure.uvarov.services.UserService;
import ua.nure.uvarov.services.UserServiceImpl;
import ua.nure.uvarov.transaction.DBManager;


@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        System.out.println(servletContext.getContextPath());
        DataSource dataSource;
        try {
            Context initContext = new InitialContext();
            dataSource = (DataSource) initContext.lookup("java:/comp/env/jdbc/librarydb");
        } catch (NamingException e) {
            throw new AppInitializationException();
        }

        DBManager dbManager = new DBManager(dataSource);


        UserDao userDao = new UserDaoImpl();


        UserService userService = new UserServiceImpl(userDao,dbManager);
        RegisterService registerService = new RegisterService();

        servletContext.setAttribute(Parameters.USER_SERVICE, userService);
        servletContext.setAttribute(Parameters.REGISTER_SERVICE, registerService);
    }
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
