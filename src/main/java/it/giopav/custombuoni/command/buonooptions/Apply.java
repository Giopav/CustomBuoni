package it.giopav.custombuoni.command.buonooptions;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import it.giopav.custombuoni.buoni.categories.BuonoDescrizione;
import it.giopav.custombuoni.buoni.categories.BuonoNome;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collections;

public class Apply {
    public static boolean apply(Player player) {
        ItemStack offHandItem = player.getEquipment().getItemInOffHand();
        PersistentDataContainer offHandPersistentDataContainer = offHandItem.getItemMeta().getPersistentDataContainer();
        if (!offHandPersistentDataContainer.has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano secondaria.");
            return false;
        }
        ItemStack mainHandItem = player.getEquipment().getItemInMainHand();
        if (mainHandItem.getType().isAir()) {
            player.sendMessage(ChatColor.RED + "Per applicare un buono devi avere un item in mano primaria.");
            return false;
        }
        if (mainHandItem.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey())) {
            player.sendMessage(ChatColor.RED + "Non puoi applicare un buono ad un altro buono.");
            return false;
        }

        BuonoType buonoType = CustomBuoni.getBuoniTypeHashMap()
                .get(offHandPersistentDataContainer.get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING));
        Buono buono = CustomBuoni.getBuoniHashMap().get(buonoType);
        offHandItem.subtract();
        switch (buonoType) {
            case NOME:
                applyNome(mainHandItem, ((BuonoNome) buono).extractValue(offHandItem));
                break;
            case DESCRIZIONE:
                applyDescrizione(mainHandItem, ((BuonoDescrizione) buono).extractValue(offHandItem));
                break;
            case STATTRAK:
                applyStattrak(mainHandItem);
                break;
            case MOBTRAK:
                applyMobtrak(mainHandItem);
                break;
            default:
                player.sendMessage(ChatColor.RED + "Questo buono non può essere applicato.");
                return false;
        }

        player.sendMessage(ChatColor.GREEN + "Il buono " + buono.getNormalizedString() + " è stato applicato.");
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