package it.giopav.custombuoni.command.buono;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Stattrak {
    public static boolean onBuono(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai un buono stattrak in mano!");
        return true;
    }
}
