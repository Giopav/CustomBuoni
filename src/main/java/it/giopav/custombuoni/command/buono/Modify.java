package it.giopav.custombuoni.command.buono;

import it.giopav.custombuoni.Buono;
import it.giopav.custombuoni.CustomBuoni;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class Modify {
    public static boolean buono(Player player, String value) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getType().equals(Material.AIR)) {
            player.sendMessage(ChatColor.RED + "Non hai niente in mano.");
            return false;
        }
        if (!mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        if (value == null) {
            player.sendMessage(ChatColor.RED + "Devi aggiungere un valore da dare al buono nome.");
            player.sendMessage(ChatColor.RED + "Per rimuovere il valore scrivi /buono cancel.");
            return false;
        }
        String mainHandContainer = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Buono.NOME.toString())) {
            return Nome.edit(player);
        } else if (Objects.equals(mainHandContainer, Buono.DESCRIZIONE.toString())) {
            return Descrizione.edit(player);
        } else if (Objects.equals(mainHandContainer, Buono.STATTRAK.toString())) {
            player.sendMessage(ChatColor.RED + "Il buono stattrak è utilizzabile senza modifiche.");
            return false;
        } else if (Objects.equals(mainHandContainer, Buono.MOBTRAK.toString())) {
            player.sendMessage(ChatColor.RED + "Il buono mobtrak è utilizzabile senza modifiche.");
            return false;
        }
        player.sendMessage(ChatColor.RED + "Non capisco che buono hai in mano.");
        return false;
    }
}
