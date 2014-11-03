package com.yoo.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 *
 */
public class AuthCodeUpdater extends TimerTask {
    private static final Logger logger = LoggerFactory.getLogger(AuthCodeUpdater.class);

    private final Auth auth;

    public AuthCodeUpdater() {
        auth = new Auth();
    }

    @Override
    public void run() {
        auth.refresh(true);
        logger.debug("AuthCode updated to [{}]", auth.authCode());
    }

}
