/*
 *       _____  _       _    _____                                _
 *      |  __ \| |     | |  / ____|                              | |
 *      | |__) | | ___ | |_| (___   __ _ _   _  __ _ _ __ ___  __| |
 *      |  ___/| |/ _ \| __|\___ \ / _` | | | |/ _` | '__/ _ \/ _` |
 *      | |    | | (_) | |_ ____) | (_| | |_| | (_| | | |  __/ (_| |
 *      |_|    |_|\___/ \__|_____/ \__, |\__,_|\__,_|_|  \___|\__,_|
 *                                    | |
 *                                    |_|
 *            PlotSquared plot management system for Minecraft
 *               Copyright (C) 2014 - 2022 IntellectualSites
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.plotsquared.bukkit.placeholder;

import com.plotsquared.bukkit.player.BukkitPlayer;
import com.plotsquared.core.configuration.caption.ChatFormatter;
import com.plotsquared.core.player.PlotPlayer;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

public class PlaceholderFormatter implements ChatFormatter {

    @Override
    public void format(final @NonNull ChatContext context) {
        final PlotPlayer<?> recipient = context.getRecipient();
        if (recipient instanceof BukkitPlayer) {
            if (context.isRawOutput()) {
                context.setMessage(context.getMessage().replace('%', '\u2010'));
            } else {
                final Player player = ((BukkitPlayer) recipient).player;
                context.setMessage(PlaceholderAPI.setPlaceholders(player, context.getMessage()));
            }
        }
    }

}
