package it.giopav.custombuoni.command.buono;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nome {
    public static boolean call(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai un buono nome in mano!");
        return true;
    }
}