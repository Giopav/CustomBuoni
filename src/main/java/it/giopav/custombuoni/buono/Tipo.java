package it.giopav.custombuoni.buono;

import it.giopav.custombuoni.CustomBuoni;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
    NOME, DESCRIZIONE, STATTRAK, MOBTRAK;

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(CustomBuoni.getIstance().getKey(), PersistentDataType.STRING, this.toString());
        List<Component> list = new ArrayList<>();
        itemMeta.displayName(Component.text(this.getName()));
        switch (this) {
            case NOME:
                list.add(Component.text(ChatColor.GRAY + "» "));
                list.add(Component.text(ChatColor.DARK_GRAY + "Cambia il nome di un item!"));
                break;
            case DESCRIZIONE:
                list.add(Component.text(ChatColor.GRAY + "» "));
                list.add(Component.text(ChatColor.DARK_GRAY + "Cambia la descrizione di un item!"));
                break;
            case STATTRAK:
                list.add(Component.text(ChatColor.DARK_GRAY + "Aggiungi stattrak ad un item!"));
                break;
            case MOBTRAK:
                list.add(Component.text(ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!"));
                break;
        }
        itemMeta.lore(list);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public String getNormalizedString() {
        return this.toString().substring(0,1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    private String getName() {
        String buono = ChatColor.WHITE + "Buono ";
        switch (this) {
            default:
            case NOME:
                return buono + ChatColor.RED + "nome";
            case DESCRIZIONE:
                return buono + ChatColor.DARK_PURPLE + "descrizione";
            case STATTRAK:
                return buono + ChatColor.YELLOW + "stattrak";
            case MOBTRAK:
                return buono + ChatColor.GREEN + "mobtrak";
        }
    }

}