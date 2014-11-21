package com.yoo.tools;

import org.apache.commons.lang.StringUtils;

public class Matcher {
    public boolean matches(final String l1) {
        return StringUtils.indexOfIgnoreCase(l1, "dio ") == 0 ||
                StringUtils.indexOfIgnoreCase(l1, "cristo ") == 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porco") == 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porcodio") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "dioporco") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "cristoporco") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "diocane") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " cristo") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " satana") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " demoni") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "belzeb") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " maledett") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " pilato") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "asinello") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " sandali") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " vatican") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, " prelat") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porcocristo") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porcamadonna") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porcacc") >= 0 ||
                StringUtils.indexOfIgnoreCase(l1, "porca") == 0 ||
                StringUtils.indexOfIgnoreCase(l1, "madonna ") == 0 ||
                StringUtils.indexOfIgnoreCase(l1, " madonna") > 0;
    }
}
