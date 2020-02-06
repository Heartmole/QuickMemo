/*
 * Copyright (C) 2020 Heartmole
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.heartmole.quickmemo.extractor.view;

import java.io.File;
import java.util.StringJoiner;
import javax.swing.filechooser.FileFilter;

/**
 * Collection of {@link FileFilter}s used in the QuickMemo+ Extractor.
 * @author Heartmole
 */
public class LqmFileFilters extends FileFilter {

    public static final LqmFileFilters QUICKMEMO =
            new LqmFileFilters("LG QuickMemo+ file", "lqm", "zip");
    public static final LqmFileFilters HTML =
            new LqmFileFilters("HTML file", "htm", "html");
    public static final LqmFileFilters TEXT =
            new LqmFileFilters("Plain text file", "txt", "text");

    private final String description;
    private final String[] extensions;

    private LqmFileFilters(String description, String... extensions) {
        this.description = description;
        this.extensions = extensions;
    }

    /**
     * Checks whether the given file path is accepted by this filter.
     * @param file the file path object representation.
     * @return whether the given file path is accepted by this filter.
     */
    @Override
    public boolean accept(File file) {
        // Show directories in file chooser
        if (file.isDirectory()) return true;
        // Get the file extension
        String filename = file.getName();
        int index = filename.lastIndexOf('.');
        if (index >= 0 && index < filename.length() - 1) {
            // Show files that match the desired extensions
            String extension = filename.substring(index + 1).toLowerCase();
            for (String desiredExtension : extensions) {
                if (desiredExtension.equals(extension)) return true;
            }
        }
        return false;
    }

    /**
     * The description of this file filter, to be displayed in the file chooser
     * window.
     * @return the description of this file filter.
     */
    @Override
    public String getDescription() {
        // Do not use Arrays.stream since the extensions array isn't too big.
        StringJoiner joiner = new StringJoiner(", ", description + " (", ")");
        for (String extension: extensions) {
            joiner.add("*." + extension);
        }
        return joiner.toString();
    }

}
