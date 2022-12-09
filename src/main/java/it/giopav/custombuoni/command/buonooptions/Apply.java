package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.Buono;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Apply {
    public static boolean apply(Player player) {
        ItemStack offHandItem = player.getEquipment().getItemInOffHand();
        if (!Buono.is(offHandItem)) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano secondaria.");
            return false;
        }
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "Per applicare un buono devi avere un item in mano primaria.");
            return false;
        }
        if (Buono.is(mainHandItem)) {
            player.sendMessage(ChatColor.RED + "Non puoi applicare un buono ad un altro buono.");
            return false;
        }

        Buono buono = Buono.getBuono(offHandItem);
        assert buono != null;
        switch (buono) {
            case NOME:
                offHandItem.subtract();
                applyNome(mainHandItem, buono.getValue(offHandItem));
                break;
            case DESCRIZIONE:
                offHandItem.subtract();
                applyDescrizione(mainHandItem, buono.getValue(offHandItem));
                break;
            case STATTRAK:
                offHandItem.subtract();
                applyStattrak(mainHandItem);
                break;
            case MOBTRAK:
                offHandItem.subtract();
                applyMobtrak(mainHandItem);
                break;
            default:
                player.sendMessage(ChatColor.RED + "Questo buono non può essere applicato.");
                return false;
        }

        player.sendMessage(ChatColor.GREEN + "Il buono " + buono.getStringNormalized() + " è stato applicato.");
        return true;
    }

    public static void applyNome(ItemStack itemStack, String value) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.displayName(Component.text(value));
        itemStack.setItemMeta(itemMeta);
    }

    public static void applyDescrizione(ItemStack itemStack, String value) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.lore(Collections.singletonList(Component.text(value)));
        itemStack.setItemMeta(itemMeta);
    }

    public static void applyStattrak(ItemStack itemStack) {
        //TODO
    }

    public static void applyMobtrak(ItemStack itemStack) {
        //TODO
    }
}
