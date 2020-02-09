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

package com.heartmole.quickmemo.extractor.model;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Heartmole
 */
public class LqmMemoObject {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VOICE = 3;
    public static final int TYPE_VIDEO = 4;
    public static final int TYPE_CHECKBOX = 5;
    public static final int TYPE_DRAWING = 6;

    @SerializedName("Id")
    private int id;
    @SerializedName("Type")
    private int type;
    @SerializedName("Height")
    private int height;
    @SerializedName("Width")
    private int width;
    @SerializedName("X")
    private int x;
    @SerializedName("Y")
    private int y;
    @SerializedName("Desc")
    private String description;
    @SerializedName("DescRaw")
    private String rawDescription;
    @SerializedName("OrderNum")
    private int order;
    @SerializedName("FileName")
    private String filename;
    @SerializedName("IsChecked")
    private int checked;

    /// <editor-fold desc="[Getters]">
    public int getId() {
        return id;
    }
    public int getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public String getRawDescription() {
        return rawDescription;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getOrder() {
        return order;
    }
    public String getFilename() {
        return filename;
    }
    public int getChecked() {
        return checked;
    }
    /// </editor-fold>

}
