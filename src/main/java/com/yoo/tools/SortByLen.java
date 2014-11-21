package com.yoo.tools;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

/**
 *
 */
public class SortByLen {
    public static void main(final String[] args) throws IOException {
        final File fi = new File(args[0]);
        final File fo = new File(args[1]);

        final Set<String> bb = new TreeSet<>();

        BufferedReader bi = null;
        BufferedWriter bo = null;

        try {
            bi = new BufferedReader(new InputStreamReader(new FileInputStream(fi), Charsets.UTF_8));
            bo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fo), Charsets.UTF_8));

            String line;

            while ((line = bi.readLine()) != null) {
                final String l0 = StringUtils.trim(line);

                bb.add(l0);
            }

            final String[] bb1 = bb.toArray(new String[bb.size()]);

            Collections.sort(Arrays.asList(bb1), new Comparator<String>() {
                public int compare(final String s1, final String s2) {
                    return s1.length() - s2.length();
                }
            });

            for (final String b : bb1) {
                bo.write(b);
                bo.newLine();
            }

        } finally {
            IOUtils.closeQuietly(bi);
            IOUtils.closeQuietly(bo);
        }

    }
}
