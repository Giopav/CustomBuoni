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

public class Buono {

    private final Tipo tipo;
    private String value = null;

    public Buono(Tipo tipo) {
        this.tipo = tipo;
    }

    public ItemStack getItemStack() {
        ItemStack itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.getPersistentDataContainer().set(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING, this.toString());
        List<Component> list = new ArrayList<>();
        itemMeta.displayName(Component.text(tipo.getName()));
        switch (tipo) {
            case NOME:
                list.add(Component.text(ChatColor.GRAY + "» " + value));
                list.add(Component.text(ChatColor.DARK_GRAY + "Cambia il nome di un item!"));
                break;
            case DESCRIZIONE:
                list.add(Component.text(ChatColor.GRAY + "» " + value));
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

    public String getValue() {
        return value;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setValue(String value) {
        //TODO need to set that value cannot exist if the Buono is Stattrak or Mobtrak
        this.value = value;
    }
}