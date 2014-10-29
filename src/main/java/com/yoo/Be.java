package com.yoo;

import com.yoo.mdl.Result;
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
public class Be extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Be.class);

    private Dic dic;

    public Be() {
        try {
            dic = new Dic();
        } catch (IOException e) {
            logger.error("", e);
        }
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

        if (!"19238183766162".equals(req.getHeader("j"))) {
            resp.setStatus(506);
            return;
        }

        final String q = dic.normalize(req.getParameter("q"));

        final Result[] r = new Result[2];

        if (StringUtils.isNotBlank(q)) {
            r[0] = dic.search(q);
            r[1] = dic.search(q);

            logger.debug("Request handled [{}]", q);
        } else {
            r[0] = dic.any();
            r[1] = dic.any();

            logger.debug("Request handled");
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().print("{\"d\":[" +
                "{\"s\":\"" + r[0].getRes() + "\",\"n\":" + r[0].getResNum() + ",\"o\":" + r[0].getResNumOf() + "}," +
                "{\"s\":\"" + r[1].getRes() + "\",\"n\":" + r[1].getResNum() + ",\"o\":" + r[1].getResNumOf() + "}" +
                "]}");
    }

}
