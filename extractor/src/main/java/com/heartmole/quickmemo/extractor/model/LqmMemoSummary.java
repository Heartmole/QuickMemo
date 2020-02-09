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
import java.util.Date;

/**
 *
 * @author Heartmole
 */
public class LqmMemoSummary {

    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_STRIPPED = 1;

    @SerializedName("CreatedTime")
    private long createdTime;
    
    @SerializedName("ModifiedTime")
    private long modifiedTime;

    @SerializedName("DeviceWidth")
    private int width;

    @SerializedName("DrawLayoutHeight")
    private int height;

    @SerializedName("FontSizePx")
    private int fontSize;

    @SerializedName("Color")
    private int color;

    @SerializedName("DrawImage")
    private String drawImage;

    @SerializedName("PreviewImage")
    private String previewImage;

    @SerializedName("Style")
    private int style;

    public Date getCreatedTime() {
        return new Date(createdTime);
    }
    public Date getModifiedTime() {
        return new Date(modifiedTime);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getFontSize() {
        return fontSize;
    }
    public int getColor() {
        return color;
    }
    public String getDrawImage() {
        return drawImage;
    }
    public String getPreviewImage() {
        return previewImage;
    }
    public int getStyle() {
        return style;
    }

}
