package com.yoo.best;

import com.yoo.model.Result;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

/**
 *
 */
public class DictionaryEngine {
    private static final Logger logger = LoggerFactory.getLogger(DictionaryEngine.class);

    private final List<String> dic;
    private final List<File> dicFiles;
    private final Map<String, List<String>> resCache;
    private final Random rnd;


    public DictionaryEngine() {
        dic = new ArrayList<>(100000);
        rnd = new Random(System.nanoTime());
        resCache = new HashMap<>();
        dicFiles = new ArrayList<>(5);
        dicFiles.add(new File("/var/final.txt"));
        dicFiles.add(new File("/var/final_gb.txt"));
        dicFiles.add(new File("/var/final_add.txt"));
        dicFiles.add(new File("/var/said.txt"));

        reload();
    }


    public void reload() {
        for (final File f : dicFiles) {
            if (f.exists() && f.canRead()) {

                try (final BufferedReader bi = new BufferedReader(
                        new InputStreamReader(new FileInputStream(f), Charsets.UTF_8))) {

                    String line;

                    while ((line = bi.readLine()) != null) {
                        final String escaped = normalizeLine(line);

                        dic.add(escaped);
                    }
                } catch (final IOException ex) {
                    logger.error("", ex);
                }
            }
        }

        resCache.clear();

        logger.info("gb loaded");
    }


    private String normalizeLine(final String l) {
        return StringUtils.replaceEach(l,
                new String[] { "\"", "\r", "\n" }, new String[] { "\\\"", "", "" });
    }


    public String normalizeSearchTerm(final String searchTerm) {
        if (StringUtils.isBlank(searchTerm)) {
            return "";
        } else {
            return StringUtils.trim(StringUtils.substring(
                    searchTerm, 0, Math.min(12, searchTerm.length())));
        }
    }


    public Result[] any2() {
        final int resNum1 = rnd.nextInt(dic.size());
        final int resNum2 = nextInt(dic.size(), resNum1);

        return new Result[] {
                new Result(dic.get(resNum1), resNum1, dic.size()),
                new Result(dic.get(resNum2), resNum2, dic.size())
        };
    }


    public Result[] search2(final String searchTerm) {
        List<String> results;

        synchronized (this) {
            if (resCache.size() > 10000) {
                resCache.clear();
            }

            results = resCache.get(searchTerm);

            if (results == null) {
                results = new ArrayList<>(4096);

                for (final String ss : dic) {
                    if (StringUtils.containsIgnoreCase(ss, searchTerm)) {
                        results.add(ss);
                    }
                }

                resCache.put(searchTerm, results);
            }
        }

        if (results.size() > 0) {
            final int resNum1 = rnd.nextInt(results.size());
            final int resNum2 = nextInt(results.size(), resNum1);

            return new Result[] {
                    new Result(results.get(resNum1), resNum1, results.size()),
                    new Result(results.get(resNum2), resNum2, results.size()),
            };

        } else {
            return new Result[] { new Result("", 0, 0) };
        }
    }


    private int nextInt(final int max, final int exclude) {
        int attempts = 0;
        int nrnd = rnd.nextInt(max);

        while (exclude == nrnd && attempts++ < 33) {
            nrnd = rnd.nextInt(max);
        }

        return nrnd;
    }


}
