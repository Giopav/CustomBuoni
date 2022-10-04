package it.giopav.custombuoni.buono;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Buono {

    private final ItemStack itemStack;
    private final Tipo tipo;

    public Buono(Tipo tipo) {
        this.tipo = tipo;
        this.itemStack = new ItemStack(Material.PAPER);
        ItemMeta itemMeta = Bukkit.getItemFactory().getItemMeta(Material.PAPER);
        String buono = ChatColor.WHITE + "Buono ";
        switch (this.tipo) {
            case NOME:
                itemMeta.displayName(Component.text(buono + ChatColor.RED + "nome"));
                itemMeta.lore(Collections.singletonList(Component.text(ChatColor.DARK_GRAY + "Cambia il nome di un item!")));
                break;
            case DESCRIZIONE:
                itemMeta.displayName(Component.text(buono + ChatColor.DARK_PURPLE + "descrizione"));
                itemMeta.lore(Collections.singletonList(Component.text(ChatColor.DARK_GRAY + "Cambia la descrizione di un item!")));
                break;
            case STATTRAK:
                itemMeta.displayName(Component.text(buono + ChatColor.YELLOW + "stattrak"));
                itemMeta.lore(Collections.singletonList(Component.text(ChatColor.DARK_GRAY + "Aggiungi stattrak ad un item!")));
                break;
            case MOBTRAK:
                itemMeta.displayName(Component.text(buono + ChatColor.GREEN + "mobtrak"));
                itemMeta.lore(Collections.singletonList(Component.text(ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!")));
                break;
        }
        itemStack.setItemMeta(itemMeta);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public Tipo getTipo() {
        return tipo;
    }
}