package com.yoo.web.security;

import org.apache.commons.codec.digest.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 */
public class Auth {
    private static String authCode = null;


    public String authCode() {
        if (authCode == null) {
            refresh(false);
        }

        return authCode;
    }


    public synchronized void refresh(boolean force) {
        if (authCode == null || force) {
            authCode = DigestUtils.sha256Hex("XOXO" + new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()));
        }
    }


}
