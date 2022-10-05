package it.giopav.custombuoni.buono;

import org.bukkit.inventory.ItemStack;


public class Buono {

    private final Tipo tipo;

    public Buono(Tipo tipo) {
        this.tipo = tipo;
    }

    public ItemStack getItemStack() {
        return tipo.getItemStack();
    }

    public Tipo getTipo() {
        return tipo;
    }
}