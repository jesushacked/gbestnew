package com.yoo;

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
            synchronized (Auth.class) {
                if (authCode == null) {
                    authCode = DigestUtils.sha256Hex("XOXO" + new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()));
                }
            }
        }

        return authCode;
    }


}
