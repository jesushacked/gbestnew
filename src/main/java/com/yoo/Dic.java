package com.yoo;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Dic {
    private final Map<String, List<String>> resCache;
    private final List<String> dic;
    private final Random ran;


    public Dic() throws IOException {
        dic = new ArrayList<String>();
        ran = new Random(System.nanoTime());
        resCache = new HashMap<String, List<String>>();

        reload();
    }

    public void reload() throws IOException {
        for (final String line : FileUtils.readLines(new File("/var/final.txt"), Charsets.UTF_8)) {
            dic.add(escape(line));
        }

        resCache.clear();
    }


    private String escape(final String l) {
        return StringUtils.replaceEach(l, new String[] { "\"", "\r", "\n" }, new String[] { "\\\"", "", "" });
    }


    public Result any() {
        final int resNum = ran.nextInt(dic.size());
        return new Result(dic.get(resNum), resNum, dic.size());
    }


    public String normalize(final String searchTerm) {
        if (StringUtils.isBlank(searchTerm)) {
            return "";
        } else {
            return StringUtils.substring(searchTerm, 0, Math.min(10, searchTerm.length()));
        }

//        final String searchTermShortened = StringUtils.substring(searchTerm, 0, Math.min(10, searchTerm.length()));
//        final StringBuilder normalizedSearchTerm = new StringBuilder();
//
//        for (final char c : searchTermShortened.toCharArray()) {
//            if (CharUtils.isAsciiPrintable(c)) {
//                normalizedSearchTerm.append(c);
//            }
//        }
//
//        return normalizedSearchTerm.toString().toLowerCase();
    }


    public synchronized Result search(final String searchTerm) {
        if (resCache.size() > 10000) {
            resCache.clear();
        }

        List<String> results = resCache.get(searchTerm);

        if (results == null) {
            results = new ArrayList<String>();

            for (final String ss : dic) {
                if (StringUtils.containsIgnoreCase(ss, searchTerm)) {
                    results.add(ss);
                }
            }

            resCache.put(searchTerm, results);
        }

        if (results.size() > 0) {
            final int resNum = ran.nextInt(results.size());

            return new Result(results.get(resNum), resNum, results.size());
        } else {
            return new Result("", 0, 0);
        }
    }

}
