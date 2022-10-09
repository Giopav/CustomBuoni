package it.giopav.custombuoni.command.generaloptions;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class List {
    public static boolean list(Player player) {
        player.sendMessage(ChatColor.GREEN + "Lista dei buoni:");
        for (Buono buono : Buono.values()) {
            player.sendMessage(ChatColor.GREEN + "- " + buono.getStringNormalized());
        }
        return true;
    }
}
