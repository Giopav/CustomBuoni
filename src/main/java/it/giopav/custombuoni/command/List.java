package it.giopav.custombuoni.command;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class List {
    public static boolean list(Player player) {
        player.sendMessage(ChatColor.GREEN + "Lista dei buoni:");
        for (int i = 0; i < Buono.values().length; i++) {
            player.sendMessage(ChatColor.GREEN + "- " + Buono.values()[i].getNormalizedString());
        }
        return true;
    }
}
