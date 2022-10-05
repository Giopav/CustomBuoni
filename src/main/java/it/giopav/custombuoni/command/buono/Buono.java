package it.giopav.custombuoni.command.buono;

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
        if (!mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getIstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        String mainHandContainer = mainHandItem.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getIstance().getKey(), PersistentDataType.STRING);
        if (Objects.equals(mainHandContainer, Tipo.NOME.toString())) {
            return Nome.call(player);
        } else if (Objects.equals(mainHandContainer, Tipo.DESCRIZIONE.toString())) {
            return Descrizione.onBuonoDescrizione(player);
        } else if (Objects.equals(mainHandContainer, Tipo.STATTRAK.toString())) {
            return Stattrak.onBuono(player);
        } else if (Objects.equals(mainHandContainer, Tipo.MOBTRAK.toString())) {
            return Mobtrak.onBuonoMobtrak(player);
        }
        player.sendMessage(ChatColor.RED + "Non capisco che buono hai in mano.");
        return false;
    }
}
