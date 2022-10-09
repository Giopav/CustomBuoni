package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import it.giopav.custombuoni.CustomBuoni;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Apply {
    public static boolean apply(Player player) {
        ItemStack offHandItem = player.getEquipment().getItemInOffHand();
        if (offHandItem.getType().equals(Material.AIR) ||
                !offHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Per applicare un buono devi averne uno in mano secondaria.");
            return false;
        }
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getType().equals(Material.AIR)) {
            player.sendMessage(ChatColor.RED + "Per applicare un buono devi avere un item in mano primaria.");
            return false;
        }
        if (mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non puoi applicare un buono ad un altro buono.");
            return false;
        }
        String mainHandContainer = offHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Buono.NOME.toString())) {
            // TODO return ...apply;
        } else if (Objects.equals(mainHandContainer, Buono.DESCRIZIONE.toString())) {
            // TODO return ...apply;
        } else if (Objects.equals(mainHandContainer, Buono.STATTRAK.toString())) {
            // TODO return ...apply;
        } else if (Objects.equals(mainHandContainer, Buono.MOBTRAK.toString())) {
            // TODO return ...apply;
        }
        player.sendMessage(ChatColor.RED + "Questo buono non può essere applicato.");
        return false;
    }
}
