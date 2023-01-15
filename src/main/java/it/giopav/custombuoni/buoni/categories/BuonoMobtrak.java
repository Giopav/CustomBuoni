package it.giopav.custombuoni.buoni.categories;

import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import org.bukkit.ChatColor;

public class BuonoMobtrak extends Buono {
    public BuonoMobtrak() {
        super(BuonoType.MOBTRAK,
                ChatColor.WHITE + "Buono " + ChatColor.GREEN + "mobtrak",
                ChatColor.DARK_GRAY + "Aggiungi mobtrak ad un item!");
    }
}
