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

import java.awt.Color;

/**
 * Utility class to convert multiple elements in the LG QuickMemo+ file.
 * @author Heartmole
 */
public class LqmConversions {

    /**
     * Converts a RGBA integer representation into a string representation to
     * use in a CSS style.
     * @param rgba the RGBA integer representation.
     * @return the RGBA string representation used in CSS.
     */
    public static String rgbaToCss(int rgba) {
        Color color = new Color(rgba, true);
        return String.format("rgba(%d, %d, %d, %f)", color.getRed(),
                color.getGreen(), color.getBlue(), color.getAlpha() / 255.0);
    }

}
