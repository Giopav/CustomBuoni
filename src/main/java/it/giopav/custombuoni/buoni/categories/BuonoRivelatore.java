package it.giopav.custombuoni.buoni.categories;

import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import org.bukkit.ChatColor;

public class BuonoRivelatore extends Buono {
    public BuonoRivelatore() {
        super(BuonoType.RIVELATORE,
                ChatColor.WHITE + "Buono " + ChatColor.GOLD + "rivelatore",
                ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!");
    }
}
