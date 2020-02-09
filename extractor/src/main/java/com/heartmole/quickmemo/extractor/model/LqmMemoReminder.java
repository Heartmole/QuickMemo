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
public class LqmMemoReminder {

    @SerializedName("ModifiedTime")
    private long modifiedTime;

    @SerializedName("RemindTime")
    private long remindTime;

    /** Default constructor required by Gson. */
    public LqmMemoReminder() {}

    public Date getModifiedTime() {
        return new Date(modifiedTime);
    }
    public Date getRemindTime() {
        return new Date(remindTime);
    }

}
