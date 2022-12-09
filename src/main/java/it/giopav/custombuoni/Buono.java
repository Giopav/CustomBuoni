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
     * Checks if the provided {@link ItemStack} is a valid Buono via the
     * {@link org.bukkit.persistence.PersistentDataContainer}.
     *
     * @param itemStack The ItemStack to check.
     *
     * @return true if it's a valid buono.
     */
    public static boolean is(ItemStack itemStack) {
        return itemStack.hasItemMeta() && itemStack.getItemMeta().getPersistentDataContainer().has(CustomBuoni.getInstance().getKey());
    }

    /**
     * Checks if the {@link org.bukkit.persistence.PersistentDataContainer} of the {@param itemStack} equals one of
     * a Buono.
     *
     * @param itemStack The ItemStack to check.
     *
     * @return the valid Buono from the provided {@param itemStack}, null if there is none.
     */
    public static Buono getBuono(ItemStack itemStack) {
        for (Buono buono : Buono.values()) {
            if (buono.toString().equals(itemStack.getItemMeta().getPersistentDataContainer().get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING))) {
                return buono;
            }
        }
        return null;
    }

    /**
     * Checks if the entered {@param string} matches any Buono name.
     *
     * @param string The String to match.
     *
     * @return the valid Buono corresponding to the {@param string}, if there isn't one, it just returns null.
     */
    public static Buono getBuono(String string) {
        Buono buono = null;
        for (Buono possibleBuono : Buono.values()) {
            if (possibleBuono.toString().equals(string)) {
                buono = possibleBuono;
            }
        }
        return buono;
    }

    /**
     * @param value The String to use as the Buono's value.
     *
     * @return The {@link ItemMeta} of the Buono with the string {@param value} at the position 0 in the lore,
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
     * For the {@param itemStack} it selects the first lore line and removes the first characters "» ",
     * what remains is the value to return.
     *
     * @param itemStack The {@link ItemStack} of the Buono.
     *
     * @return The value of the Buono {@param itemStack} only if the Buono is a NOME or DESCRIZIONE,
     * else it returns null.
     */
    public String getValue(ItemStack itemStack) {
        if (this == NOME || this == DESCRIZIONE) {
            return PlainTextComponentSerializer.plainText().serialize(Objects.requireNonNull(itemStack.getItemMeta().lore()).get(0)).replaceFirst(ChatColor.GRAY + "» ", "");
        }
        return null;
    }

    /**
     * Uses the variables initialized in the constructor as well as the
     * {@link org.bukkit.persistence.PersistentDataHolder} with the
     * {@link CustomBuoni#getInstance()} key and the {@link Buono#toString()} as value.
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
