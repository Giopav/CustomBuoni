package it.giopav.custombuoni.command.buoni;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buono.Tipo;
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
        String mainHandContainer = offHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Tipo.NOME.toString())) {
            return Nome.apply(player);
        } else if (Objects.equals(mainHandContainer, Tipo.DESCRIZIONE.toString())) {
            return Descrizione.apply(player);
        } else if (Objects.equals(mainHandContainer, Tipo.STATTRAK.toString())) {
            return Stattrak.apply(player);
        } else if (Objects.equals(mainHandContainer, Tipo.MOBTRAK.toString())) {
            return Mobtrak.apply(player);
        }
        return true;
    }
}
