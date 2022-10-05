package it.giopav.custombuoni.command.buoni;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Nome { //TODO implement edit and apply methods
    public static boolean edit(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai modificato il tuo buono nome!");
        return true;
    }

    public static boolean apply(Player player) {
        player.getEquipment().setItemInOffHand(null);
        player.sendMessage(ChatColor.GREEN + "Hai applicato il tuo buono nome!");
        return true;
    }
}