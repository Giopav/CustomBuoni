package it.giopav.custombuoni.buono;

import org.bukkit.ChatColor;

public enum Tipo {
    NOME, DESCRIZIONE, STATTRAK, MOBTRAK;

    public String getNormalizedString() {
        return this.toString().substring(0,1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }

    public String getName() {
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