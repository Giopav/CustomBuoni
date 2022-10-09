package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import it.giopav.custombuoni.CustomBuoni;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Modify {
    public static boolean modify(Player player, String value) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (Buono.isDifferentThan(mainHandItem)) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        if (value == null) {
            player.sendMessage(ChatColor.RED + "Devi aggiungere un valore da dare al buono nome.");
            player.sendMessage(ChatColor.RED + "Se vuoi rimuovere il valore scrivi /buono cancel.");
            return false;
        }
        String mainHandContainer = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Buono.NOME.toString())) {
            mainHandItem.setItemMeta(Buono.NOME.getModifiedItemMeta(value));
            player.sendMessage(ChatColor.GREEN + "Il buono nome è stato modificato in \"" + value.replace("&", "§") + ChatColor.GREEN +"\".");
            return true;
        } else if (Objects.equals(mainHandContainer, Buono.DESCRIZIONE.toString())) {
            mainHandItem.setItemMeta(Buono.DESCRIZIONE.getModifiedItemMeta(value));
            player.sendMessage(ChatColor.GREEN + "Il buono descrizione è stato modificato in \"" + value.replace("&", "§") + ChatColor.GREEN +"\".");
            return true;
        }
        player.sendMessage(ChatColor.RED + "Questo buono è applicabile con /buono apply senza essere modificato.");
        return false;
    }

}
