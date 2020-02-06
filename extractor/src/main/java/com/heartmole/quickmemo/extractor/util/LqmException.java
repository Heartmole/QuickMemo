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

package com.heartmole.quickmemo.extractor.util;

/**
 *
 * @author Heartmole
 */
public class LqmException extends Exception {

    /**
     * Creates a new exception without a message.
     */
    public LqmException() {}

    /**
     * Creates a new exception with the specified detail message.
     * @param msg the detail message.
     */
    public LqmException(String msg) {
        super(msg);
    }

    /**
     * Creates a new exception with the specified detail message and cause.
     * @param  msg the detail message.
     * @param  cause the cause of the exception.
     */
    public LqmException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
