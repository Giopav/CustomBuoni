package it.giopav.custombuoni.buoni;

import it.giopav.custombuoni.CustomBuoni;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public abstract class Buono {

    private final BuonoType buonoType;
    private final ItemStack itemStack;
    private final PersistentDataContainer persistentDataContainer;

    protected Buono(BuonoType buonoType, String name, String... lore) {
        this.buonoType = buonoType;
        this.itemStack = produceItemStack(buonoType, name, lore);
        this.persistentDataContainer = this.itemStack.getItemMeta().getPersistentDataContainer();
    }

    private static ItemStack produceItemStack(BuonoType buonoType, String name, String[] lore) {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING, buonoType.toString());
        List<Component> list = new ArrayList<>();
        itemMeta.displayName(Component.text(name));
        for (String line : lore) {
            list.add(Component.text(line));
        }
        itemMeta.lore(list);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public String getNormalizedString() {
        String[] buonoTypeWords = buonoType.toString().replace("_", " ").split(" ");
        return buonoTypeWords[0].toUpperCase() + buonoTypeWords[1].toLowerCase();
    }

    public BuonoType getBuonoType() {
        return buonoType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public PersistentDataContainer getPersistentDataContainer() {
        return persistentDataContainer;
    }
}