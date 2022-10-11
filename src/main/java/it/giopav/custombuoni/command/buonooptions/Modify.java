package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Modify {
    public static boolean modify(Player player, String value) {
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (!Buono.is(mainHandItem)) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano principale.");
            return false;
        }
        if (value == null) {
            player.sendMessage(ChatColor.RED + "Devi aggiungere un valore da dare al buono nome.");
            player.sendMessage(ChatColor.RED + "Se vuoi rimuovere il valore scrivi /buono cancel.");
            return false;
        }
        value = value.replace("&", "§");
        Buono buono = Buono.getBuonoFrom(mainHandItem);
        if (buono == Buono.NOME || buono == Buono.DESCRIZIONE) {
            mainHandItem.setItemMeta(buono.getModifiedItemMeta(value));
            player.sendMessage(ChatColor.GREEN + "Il buono " + buono.getStringNormalized() + " è stato modificato in \"" + value + ChatColor.GREEN +"\".");
            return true;
        }
        player.sendMessage(ChatColor.RED + "Questo buono è applicabile con /buono apply senza essere modificato.");
        return false;
    }

}
