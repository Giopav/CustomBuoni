package it.giopav.custombuoni.command.buoni;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Stattrak { //TODO implement edit and apply methods
    public static boolean apply(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai applicato il tuo buono stattrak!");
        return true;
    }
}
