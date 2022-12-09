package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cancel {
    public static boolean cancel(Player player) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (!Buono.is(mainHandItem)) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano principale.");
            return false;
        }
        Buono buono = Buono.getBuono(mainHandItem);
        if (buono == Buono.NOME || buono == Buono.DESCRIZIONE) {
            mainHandItem.setItemMeta(buono.getModifiedItemMeta(null));
            player.sendMessage(ChatColor.GREEN + "Il buono " + buono.getStringNormalized() + " è stato cancellato.");
            return true;
        }

        player.sendMessage(ChatColor.RED + "Questo buono non ha niente da cancellare.");
        return false;
    }

}
