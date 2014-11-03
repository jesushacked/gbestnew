package com.yoo.tools;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public class Nrm {
    public static void main(final String[] args) throws IOException {
        final File fi = new File(args[0]);
        final File fo = new File(args[1]);

        final Set<String> bb = new TreeSet<String>();

        BufferedReader bi = null;
        BufferedWriter bo = null;

        try {
            bi = new BufferedReader(new InputStreamReader(new FileInputStream(fi), Charsets.UTF_8));
            bo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fo), Charsets.UTF_8));

            String line = null;

            while ((line = bi.readLine()) != null) {
                final String l0 = StringUtils.trim(line);

                final String l1 = StringUtils.replace(l0, "`", "'");

                final String l2 = StringUtils.replaceEachRepeatedly(l1,
                        new String[] { "esu'", "che'" },
                        new String[] { "esù", "ché" }

                );

                bb.add(l2);
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
