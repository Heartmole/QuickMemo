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
package com.heartmole.quickmemo.extractor.controller;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.heartmole.quickmemo.extractor.model.LqmMemo;
import com.heartmole.quickmemo.extractor.model.LqmMemoObject;
import com.heartmole.quickmemo.extractor.util.LqmException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * A reader for LG QuickMemo+ files. This class can read .LQM files, which are
 * just regular ZIP files, and parse their file entries. The main file inside a
 * .LQM file is <code>memoinfo.jlqm</code>, a JSON file which contains the main
 * information that QuickMemo+ needs to display the memo in their application.
 * @author Heartmole
 */
public class LqmReader {

    private static final Logger LOGGER = Logger.getLogger("LqmReader");
    private static final String MEMOINFO_FILENAME = "memoinfo.jlqm";
    private static final String METADATA_FILENAME = "metadata.mtd";
    private static final String FOLDER_AUDIOS = "audios/";
    private static final String FOLDER_DRAWINGS = "drawings/";
    private static final String FOLDER_IMAGES = "images/";
    private static final String FOLDER_VIDEOS = "videos/";
    private static final int METADATA_VERSION = 10;

    private final File path;

    /**
     * Creates a new instance of <code>LqmReader</code> and verifies if the
     * QuickMemo+ file is valid. To be considered a valid file, QuickMemo+
     * files must be valid ZIP files, and must contain both a memo information
     * file entry (<code>memoinfo.jlqm</code>) and a metadata file entry
     * (<code>metadata.mtd</code>).
     * @param path the {@link File} with the path to the QuickMemo+ file.
     * @throws LqmException if the file could not be read or is not valid.
     */
    public LqmReader(File path) throws LqmException {
        this.path = path;
        // Read zip file and check it's a valid LQM file
        try (ZipFile zip = new ZipFile(path)) {
            // Make sure QuickMemo+ file contains the memoinfo file entry
            if (zip.getEntry(MEMOINFO_FILENAME) == null) {
                throw new LqmException("QuickMemo+ file is not valid. Memo "
                        + "information JSON file entry could not be found.");
            }
            // Make sure QuickMemo+ file contains the metadata file entry
            if (zip.getEntry(METADATA_FILENAME) == null) {
                throw new LqmException("QuickMemo+ file is not valid. "
                        + "Metadata file entry could not be found.");
            }
        } catch (IOException ex) {
            throw new LqmException("QuickMemo+ file could not be read. Make "
                    + "sure it is a valid ZIP file.", ex);
        }
    }

    /**
     * Extracts the information
     * @param destination
     * @param type The output type
     * @throws LqmException if an exception was found during extraction
     */
    public void extract(File destination, int type) throws LqmException {
        try (ZipFile zip = new ZipFile(path)) {
            // Parse the QuickMemo+ memoinfo file as JSON
            ZipEntry entry = zip.getEntry(MEMOINFO_FILENAME);
            InputStream stream = zip.getInputStream(entry);
            Reader reader = new InputStreamReader(stream, "UTF-8");
            LqmMemo memoinfo = new Gson().fromJson(reader, LqmMemo.class);
            // TEST
            for (LqmMemoObject object : memoinfo.getMemoObjectList()) {
                LOGGER.info(String.format("\nType: %d\nDesc: %s\nFile: %s",
                        object.getType(), object.getDescription(),
                        object.getFilename()));
            }
        } catch (JsonParseException ex) {
            throw new LqmException("Could not parse memo information from the "
                    + "QuickMemo+ file correctly.", ex);
        } catch (NullPointerException ex) {
            throw new LqmException("Could not find memo information file "
                    + "entry in the QuickMemo+ file.", ex);
        } catch (IOException ex) {
            throw new LqmException("Unknown error during extraction of the "
                    + "QuickMemo+ file.", ex);
        }
    }

}
