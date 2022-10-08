package it.giopav.custombuoni.command;

import it.giopav.custombuoni.CustomBuoni;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Cancel {
    public static boolean cancel(Player player) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            //TODO
        }
        return true;
    }
}
