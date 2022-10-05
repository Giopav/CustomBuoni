package it.giopav.custombuoni.command.buono;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Descrizione {
    public static boolean onBuonoDescrizione(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai un buono descrizione in mano!");
        return true;
    }
}
