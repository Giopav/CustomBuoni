package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.categories.BuonoDescrizione;
import it.giopav.custombuoni.buoni.categories.BuonoNome;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Cancel {
    public static boolean cancel(Player player) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        PersistentDataContainer mainHandPersistentDataContainer = mainHandItem.getItemMeta().getPersistentDataContainer();
        if (!mainHandPersistentDataContainer.has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano principale.");
            return false;
        }

        Buono heldBuono = CustomBuoni.getBuoniHashMap()
                .get(CustomBuoni.getBuoniTypeHashMap().get(mainHandPersistentDataContainer
                        .get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING)));
        if (heldBuono instanceof BuonoNome) {
            mainHandItem.setItemMeta(((BuonoNome) heldBuono).value().getItemMeta());
        } else if (heldBuono instanceof BuonoDescrizione) {
            mainHandItem.setItemMeta(((BuonoDescrizione) heldBuono).value().getItemMeta());
        } else {
            player.sendMessage(ChatColor.RED + "Questo buono non ha niente da cancellare.");
            return false;
        }
        player.sendMessage(ChatColor.GREEN + "Il buono " + heldBuono.getNormalizedString() + " è stato cancellato.");
        return true;
    }
}