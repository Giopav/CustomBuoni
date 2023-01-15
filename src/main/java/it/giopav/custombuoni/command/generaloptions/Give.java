package it.giopav.custombuoni.command.generaloptions;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
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
        args[1] = args[1].toUpperCase();
        Buono buono = CustomBuoni.getBuoniTypeHashMap().containsKey(args[1]) ?
                CustomBuoni.getBuoniHashMap().get(BuonoType.valueOf(args[1])) : null;
        if (buono == null) {
            player.sendMessage(ChatColor.RED + "Non riconosco il buono \"" + args[1] + "\".");
            return false;
        }

        player.getInventory().addItem(buono.getItemStack());
        player.sendMessage(ChatColor.GREEN + "Ho aggiunto il buono \"" + buono.getNormalizedString() + "\" nel tuo inventario!");
        return true;
    }
}