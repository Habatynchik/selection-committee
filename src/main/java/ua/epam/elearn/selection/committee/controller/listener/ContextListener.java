package ua.epam.elearn.selection.committee.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.epam.elearn.selection.committee.model.dao.database.DBManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private static final Logger logger = LogManager.getLogger(ContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        if (DBManager.getInstance() == null) {
            logger.error("Unable to get database connection");
        }

        logger.info("Database connection received");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        DBManager.getInstance().closeConnection();
        logger.debug("Database connection closed");
    }
}
