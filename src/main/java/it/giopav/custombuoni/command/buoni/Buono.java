package it.giopav.custombuoni.command.buoni;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buono.Tipo;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Buono {
    public static boolean buono(Player player) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getType().equals(Material.AIR)) {
            player.sendMessage(ChatColor.RED + "Non hai niente in mano.");
            return false;
        }
        if (!mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        String mainHandContainer = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Tipo.NOME.toString())) {
            return Nome.edit(player);
        } else if (Objects.equals(mainHandContainer, Tipo.DESCRIZIONE.toString())) {
            return Descrizione.edit(player);
        } else if (Objects.equals(mainHandContainer, Tipo.STATTRAK.toString())) {
            player.sendMessage(ChatColor.RED + "Il buono stattrak non è modificabile.");
            return false;
        } else if (Objects.equals(mainHandContainer, Tipo.MOBTRAK.toString())) {
            player.sendMessage(ChatColor.RED + "Il buono mobtrak non è modificabile.");
            return false;
        }
        player.sendMessage(ChatColor.RED + "Non capisco che buono hai in mano.");
        return false;
    }
}
