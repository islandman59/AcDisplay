/*
 * Copyright (C) 2014 AChep@xda <artemchep@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package com.achep.acdisplay.blacklist.options;

import android.content.Context;
import android.widget.CompoundButton;

import com.achep.acdisplay.Operator;
import com.achep.acdisplay.R;
import com.achep.acdisplay.blacklist.AppConfig;
import com.achep.acdisplay.blacklist.BlacklistEnabler;

/**
 * An option for {@link com.achep.acdisplay.blacklist.fragments.BlacklistAppFragment app settings}
 * to allow enabling non-clearable notifications.
 *
 * @author Artem Chepurnoy
 */
public class NonClearableOption extends Option {

    public NonClearableOption(Context context, CompoundButton cb, BlacklistEnabler enabler) {
        super(context, cb, enabler,
                context.getResources().getDrawable(R.drawable.ic_settings_non_clearable_notifies),
                context.getResources().getString(R.string.blacklist_app_non_clearable_title),
                context.getResources().getString(R.string.blacklist_app_non_clearable_summary));
    }

    @Override
    public boolean[] extractVariable(AppConfig config) {
        return config.nonClearable;
    }

    @Override
    public boolean isChanged(int diff) {
        return Operator.bitAnd(diff, AppConfig.DIFF_NON_CLEARABLE);
    }
}
