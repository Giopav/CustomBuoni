package it.giopav.custombuoni;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public enum Buono {
    NOME (ChatColor.WHITE + "Buono " + ChatColor.RED + "nome",
            ChatColor.GRAY + "» ", ChatColor.DARK_GRAY + "Cambia il nome di un item!"),
    DESCRIZIONE (ChatColor.WHITE + "Buono " + ChatColor.DARK_PURPLE + "descrizione",
            ChatColor.GRAY + "» ", ChatColor.DARK_GRAY + "Cambia la descrizione di un item!"),
    STATTRAK (ChatColor.WHITE + "Buono " + ChatColor.YELLOW + "stattrak",
            ChatColor.GRAY + "» ", ChatColor.DARK_GRAY + "Aggiungi stattrak ad un item!"),
    MOBTRAK (ChatColor.WHITE + "Buono " + ChatColor.GREEN + "mobtrak",
            ChatColor.GRAY + "» ", ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!");

    private final String name;
    private final String[] lore;

    // Constructor with the name.
    Buono(String name, String... lore) {
        this.name = name;
        this.lore = lore;
    }

    // Check if the Buono is different from the provided ItemStack.
    // In other words, it checks if the ItemStack is a Buono.
    public static boolean isDifferentThan(ItemStack itemStack) {
        return !itemStack.hasItemMeta() || !itemStack.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey());
    }

    // Returns the standard lore of the Buono along with the value in it (in the first component).
    // THIS ONLY WORKS WITH NOME AND DESCRIZIONE. Any other Buono does not need a value to work.
    public ItemMeta getModifiedItemMeta(String value) {
        ItemMeta itemMeta = this.getItemStack().getItemMeta();
        List<Component> list = new ArrayList<>();
        list.add(Component.text(ChatColor.GRAY + "» " + ChatColor.WHITE + value));
        list.add(Objects.requireNonNull(itemMeta.lore()).get(1));
        itemMeta.lore(list);
        return itemMeta;
    }

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING, this.toString());
        List<Component> list = new ArrayList<>();
        itemMeta.displayName(Component.text(this.name));
        for (String line : lore) {
            list.add(Component.text(line));
        }
        itemMeta.lore(list);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }


    public String getStringNormalized() {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

}
