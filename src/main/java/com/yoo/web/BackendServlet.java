package com.yoo.web;

import com.yoo.best.DictionaryEngine;
import com.yoo.best.SayEngine;
import com.yoo.model.Result;
import com.yoo.web.security.Auth;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
public class BackendServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(BackendServlet.class);

    private final DictionaryEngine dictionaryEngine;
    private final SayEngine sayEngine;
    private final Auth auth;

    public BackendServlet() {
        auth = new Auth();
        dictionaryEngine = new DictionaryEngine();
        sayEngine = new SayEngine();
    }


    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        resp.setStatus(508);
    }


    protected void doPost(final HttpServletRequest req, final HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        handle(req, resp);
    }


    private void handle(final HttpServletRequest req, final HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        if (req.getSession().getAttribute("auth") == null) {
            resp.setStatus(501);
            return;
        }

        if (!auth.authCode().equals(req.getHeader("j"))) {
            resp.setStatus(506);
            return;
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        final String op = req.getParameter("op");

        if ("q".equals(op)) {
            final String q = dictionaryEngine.normalizeSearchTerm(req.getParameter("q"));

            Result[] r;

            if (StringUtils.isNotBlank(q)) {
                r = dictionaryEngine.search2(q);

                logger.debug("Request handled [{}]", q);
            } else {
                r = dictionaryEngine.any2();

                logger.debug("Request handled");
            }

            resp.getWriter().print("{\"d\":[");

            resp.getWriter().print(
                    "{\"s\":\"" + r[0].getRes() + "\",\"n\":" + r[0].getResNum() + ",\"o\":" + r[0].getResNumOf() + "}");

            if (r.length > 1) {
                resp.getWriter().print(
                        ",{\"s\":\"" + r[1].getRes() + "\",\"n\":" + r[1].getResNum() + ",\"o\":" + r[1].getResNumOf() + "}");
            }

            resp.getWriter().print("]}");

        } else if ("p".equals(op)) {
//            final String b = req.getParameter("b");

        } else if ("s".equals(op)) {
            final String say = req.getParameter("s");

            if (StringUtils.isNotBlank(say)) {
                sayEngine.say(say);
            }

            resp.getWriter().print("{}");
        }
    }

}
