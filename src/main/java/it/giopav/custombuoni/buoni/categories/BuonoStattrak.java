package it.giopav.custombuoni.buoni.categories;

import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import org.bukkit.ChatColor;

public class BuonoStattrak extends Buono {
    public BuonoStattrak() {
        super(BuonoType.STATTRAK,
                ChatColor.WHITE + "Buono " + ChatColor.YELLOW + "stattrak",
                ChatColor.DARK_GRAY + "Aggiungi stattrak ad un item!");
    }
}
