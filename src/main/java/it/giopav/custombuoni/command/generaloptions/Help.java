package it.giopav.custombuoni.command.generaloptions;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
    public static boolean help(Player player) {
        player.sendMessage(ChatColor.GREEN + "Comandi:");
        player.sendMessage(ChatColor.GREEN + "[]: Obbligatorio; {}: Opzionale;");
        player.sendMessage(ChatColor.GREEN + "/buono - Modificail buono nella mano principale.");
        player.sendMessage(ChatColor.GREEN + "/buono apply - Applica un buono ad un item.");
        player.sendMessage(ChatColor.GREEN + "/buono give [buono] - Ricevi il buono selezionato.");
        player.sendMessage(ChatColor.GREEN + "/buono help - Mostra questo menù.");
        player.sendMessage(ChatColor.GREEN + "/buono list - Mostra la lista dei buoni.");
        return true;
    }
}
