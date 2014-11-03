package com.yoo.web;

import com.yoo.web.security.AuthCodeUpdater;

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

    public AppContextListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final Timer authCodeUpdaterTimer = new Timer(true);
        authCodeUpdaterTimer.scheduleAtFixedRate(new AuthCodeUpdater(), 0, 1000 * 3600);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}
