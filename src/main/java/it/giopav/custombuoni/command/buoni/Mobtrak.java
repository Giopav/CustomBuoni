package it.giopav.custombuoni.command.buoni;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Mobtrak {
    public static boolean apply(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai applicato il tuo buono mobtrak!");
        return true;
    }
}
