package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import it.giopav.custombuoni.buoni.categories.BuonoDescrizione;
import it.giopav.custombuoni.buoni.categories.BuonoNome;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class Modify {
    public static boolean modify(Player player, String value) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (value == null) {
            player.sendMessage(ChatColor.RED + "Devi inserire un valore per il buono.");
            player.sendMessage(ChatColor.RED + "Se vuoi rimuovere il valore scrivi /buono cancel.");
            return false;
        }
        Buono heldBuono;
        if (mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            String heldMetaData = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
            BuonoType heldBuonoType = CustomBuoni.getBuoniTypeHashMap().get(heldMetaData);
            heldBuono = CustomBuoni.getBuoniHashMap().get(heldBuonoType);
        } else {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano principale.");
            return false;
        }

        value = ChatColor.translateAlternateColorCodes('&', value);
        if (heldBuono instanceof BuonoNome) {
            mainHandItem.setItemMeta(((BuonoNome) heldBuono).value(value).getItemMeta());
        } else if (heldBuono instanceof BuonoDescrizione) {
            mainHandItem.setItemMeta(((BuonoDescrizione) heldBuono).value(value).getItemMeta());
        } else {
            player.sendMessage(ChatColor.RED + "Questo buono è applicabile con /buono apply senza essere modificato.");
            return false;
        }

        player.sendMessage(ChatColor.GREEN + "Il buono " + heldBuono.getNormalizedString() + " è stato modificato in \"" + value + ChatColor.GREEN + "\".");
        return true;
    }
}