package it.giopav.custombuoni.command;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
    public static boolean help(Player player) {
        player.sendMessage(ChatColor.GREEN + "Comandi:");
        player.sendMessage(ChatColor.GREEN + "[]: Obbligatorio; {}: Opzionale;");
        player.sendMessage(ChatColor.GREEN + "/buono - opera sul buono nella mano principale.");
        player.sendMessage(ChatColor.GREEN + "/buono give [buono] - ottieni il buono scelto.");
        player.sendMessage(ChatColor.GREEN + "/buono list - mostra la lista dei buoni.");
        player.sendMessage(ChatColor.GREEN + "/buono help - mostra questo menù.");
        return true;
    }
}
