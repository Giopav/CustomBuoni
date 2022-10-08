package it.giopav.custombuoni.command.buono;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Mobtrak { //TODO implement edit and apply methods
    public static boolean apply(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai applicato il tuo buono mobtrak!");
        return true;
    }
}
