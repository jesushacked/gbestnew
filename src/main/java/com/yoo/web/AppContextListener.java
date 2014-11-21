package com.yoo.web;

import com.yoo.web.security.AuthCodeUpdater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Timer;

/**
 *
 */
public class AppContextListener implements ServletContextListener,
        HttpSessionListener {

    private static final Logger logger = LoggerFactory.getLogger(AppContextListener.class);

    final Timer internalScheduler;
    final AuthCodeUpdater authCodeUpdater;

    public AppContextListener() {
        internalScheduler = new Timer(true);
        authCodeUpdater = new AuthCodeUpdater();

        logger.info("gb initialized");
    }

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        internalScheduler.scheduleAtFixedRate(authCodeUpdater, 0, 1000 * 3600);
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        authCodeUpdater.cancel();
        internalScheduler.cancel();
    }

    @Override
    public void sessionCreated(final HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(final HttpSessionEvent se) {
    }

}
