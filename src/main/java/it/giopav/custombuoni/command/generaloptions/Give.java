package it.giopav.custombuoni.command.generaloptions;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Give {
    public static boolean give(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + "Devi selezionare quale buono vuoi.");
            return false;
        }
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.RED + "Il tuo inventario è pieno.");
            return false;
        }
        Buono buono = Buono.getBuono(args[1].toUpperCase());
        if (buono == null) {
            player.sendMessage(ChatColor.RED + "Non riconosco il buono \"" + args[1] + "\".");
            return false;
        }

        player.getInventory().addItem(buono.getItemStack());
        player.sendMessage(ChatColor.GREEN + "Ho aggiunto il buono \"" + buono.getStringNormalized() + "\" nel tuo inventario!");
        return true;
    }
}