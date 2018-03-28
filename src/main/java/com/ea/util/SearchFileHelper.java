// Copyright (c) 2018-2018 Lewis.Liu Limited. All rights reserved.
// ============================================================================
// CURRENT VERSION EA.1.0.0
// ============================================================================
// CHANGE LOG
// EA.1.0.0 : 2018年3月25日, Lewis.Liu created
// ============================================================================
package com.ea.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lewis.Liu
 *
 */
//TODO :    search the file in directory
public class SearchFileHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFileHelper.class);

    private SearchFileHelper() {}

    public static List<File> searchFile(final File directory, final String keyword) {
        if (directory == null || (directory != null && !directory.exists())) {
            LOGGER.info("Directory doesn't exist!");
            return null;
        }
        if (directory.isFile()) {
            LOGGER.info("Please specific a correct directory to search file.");
            return null;
        }
        final List<File> result = new ArrayList<File>();
        final File[] files = directory.listFiles(new FileFilter() {

            @Override
            public boolean accept(final File pathname) {
                if (pathname.isDirectory()) {
                    return true;
                } else if (StringUtils.contains(pathname.getName(), keyword)) {
                    return true;
                }
                return false;
            }
        });
        for (final File file : files) {
            if (file.isFile()) {
                result.add(file);
            } else {
                searchFile(file, keyword);
            }
        }

        return result;
    }

}
