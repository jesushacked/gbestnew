package com.yoo.tools;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class Prs {
    public static void main(final String[] args) throws IOException {
        final File fi = new File(args[0]);
        final File fo = new File(args[1]);

        final Set<String> bb = new TreeSet<>();

        BufferedReader bi = null;
        BufferedWriter bo = null;

        try {
            bi = new BufferedReader(new InputStreamReader(new FileInputStream(fi), Charsets.UTF_8));
            bo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fo), Charsets.UTF_8));

            final Matcher matcher = new Matcher();
            String line;

            while ((line = bi.readLine()) != null) {
                final String l0 = StringUtils.trim(line);
                // "text" : "ahah porcodio"
                if (l0.indexOf("\"text\" : ") == 0) {
                    final String l1 = l0.substring(10, l0.length() - 1);
                    if (matcher.matches(l1)) {

                        bb.add(StringUtils.trim(StringEscapeUtils.unescapeJava(l1)));

                    }
                }
            }

            for (final String b : bb) {
                bo.write(b);
                bo.newLine();
            }

        } finally {
            IOUtils.closeQuietly(bi);
            IOUtils.closeQuietly(bo);
        }

    }
}
