package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import it.giopav.custombuoni.CustomBuoni;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Cancel {
    public static boolean cancel(Player player) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (Buono.isDifferentThan(mainHandItem)) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        String mainHandContainer = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Buono.NOME.toString())) {
            mainHandItem.setItemMeta(Buono.NOME.getModifiedItemMeta(null));
            player.sendMessage(ChatColor.GREEN + "Il buono nome è stato cancellato.");
            return true;
        } else if (Objects.equals(mainHandContainer, Buono.DESCRIZIONE.toString())) {
            mainHandItem.setItemMeta(Buono.NOME.getModifiedItemMeta(null));
            player.sendMessage(ChatColor.GREEN + "Il buono descrizione è stato cancellato.");
            return true;
        }
        player.sendMessage(ChatColor.RED + "Questo buono non ha niente da cancellare.");
        return false;
    }

}
