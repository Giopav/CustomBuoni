package it.giopav.custombuoni;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
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
            ChatColor.DARK_GRAY + "Aggiungi stattrak ad un item!"),
    MOBTRAK (ChatColor.WHITE + "Buono " + ChatColor.GREEN + "mobtrak",
            ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!");

    private final String name;
    private final String[] lore;

    /**
     * Constructor builds the enums with name and lore.
     * @param name will be used as display name to build the ItemStack
     * @param lore will be used as lore to build the ItemStack
     */
    Buono(String name, String... lore) {
        this.name = name;
        this.lore = lore;
    }

    /**
     * Checks if the provided {@param itemStack} is a valid Buono via the Persistent Data Container.
     * @return true if it is, false if it isn't.
     */
    public static boolean is(ItemStack itemStack) {
        return itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey());
    }

    /**
     * @return the valid Buono from the provided {@param itemStack}, null if there is none.
     */
    public static Buono getBuonoFrom(ItemStack itemStack) {
        for (Buono buono : Buono.values()) {
            if (buono.toString().equals(itemStack.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING))) {
                return buono;
            }
        }
        return null;
    }

    /**
     * @return the ItemMeta of the Buono with the string {@param value} at the position 0 in the lore,
     * if the Buono is not NOME or DESCRIZIONE it just returns null (as other Buoni don't have any value).
     */
    public ItemMeta getModifiedItemMeta(String value) {
        if (this != NOME && this != DESCRIZIONE) {
            return null;
        }
        if (value == null) {
            value = "";
        }
        ItemMeta itemMeta = this.getItemStack().getItemMeta();
        List<Component> list = new ArrayList<>();
        list.add(Component.text(ChatColor.GRAY + "» " + ChatColor.WHITE + value));
        list.add(Objects.requireNonNull(itemMeta.lore()).get(1));
        itemMeta.lore(list);
        return itemMeta;
    }

    /**
     * @return the value of the {@param itemStack} Buono (taken from the first line of the lore),
     * if the Buono is not NOME or DESCRIZIONE it just returns null (as other Buoni don't have any value).
     */
    public String getValue(ItemStack itemStack) {
        if (this == NOME || this == DESCRIZIONE) {
            return PlainTextComponentSerializer.plainText().serialize(Objects.requireNonNull(itemStack.getItemMeta().lore()).get(0)).replaceFirst(ChatColor.GRAY + "» ", "");
        }
        return null;
    }

    /**
     * Uses the variables initialized in the constructor as well as the
     * PersistentDataHolder with the instance key (CustomBuoni.getInstance().getKey()) and the Buono.toString as value.
     *
     * @return the respective itemStack of the Buono.
     */
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

    /**
     * @return a normalized string of the selected Buono (ex. BUONO = Buono; STATTRAK = Stattrak).
    */
    public String getStringNormalized() {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }
}