package it.giopav.custombuoni.command.generaloptions;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class List {
    public static boolean list(Player player) {
        player.sendMessage(ChatColor.GREEN + "Lista dei buoni:");
        for (Buono buono : CustomBuoni.getBuoniHashMap().values()) {
            player.sendMessage(ChatColor.GREEN + "- " + buono.getNormalizedString());
        }
        return true;
    }
}