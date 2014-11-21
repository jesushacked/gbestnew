package com.yoo.best;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/**
 *
 */
public class SayEngine {
    private static final Logger logger = LoggerFactory.getLogger(SayEngine.class);

    public void say(final String say) {
        final File fs = new File("/var/said.txt");

        BufferedWriter bo = null;

        try {
            final FileOutputStream fo = new FileOutputStream(fs, true);
            bo = new BufferedWriter(new OutputStreamWriter(fo, Charsets.UTF_8));

            int attempts = 0;
            boolean written = false;
            do {
                try {
                    final FileLock lock = fo.getChannel().lock();
                    try {
                        bo.write(say);
                        bo.newLine();
                        written = true;
                    } finally {
                        lock.release();
                    }
                } catch (final OverlappingFileLockException ofle) {
                    attempts++;

                    try {
                        Thread.sleep(666);
                    } catch (final InterruptedException ex) {
                        logger.warn("", ex);
                    }
                }
            } while (attempts < 10 && !written);
        } catch (final IOException ex) {
            logger.warn("Failed to write [{}]", fs, ex);
        } finally {
            IOUtils.closeQuietly(bo);
        }
    }
}
