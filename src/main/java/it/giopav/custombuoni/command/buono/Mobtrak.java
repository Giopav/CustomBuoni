package it.giopav.custombuoni.command.buono;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Mobtrak {
    public static boolean onBuonoMobtrak(Player player) {
        player.sendMessage(ChatColor.GREEN + "Hai un buono mobtrak in mano!");
        return true;
    }
}
