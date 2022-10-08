package it.giopav.custombuoni.command;

import it.giopav.custombuoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Give {
    public static boolean give(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + "Devi selezionare quale buono vuoi.");
            return false;
        }
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.RED + "Il tuo inventario è pieno.");
            return false;
        }
        Buono buono;
        switch(args[1].toLowerCase()) {
            case "nome":
                buono = Buono.NOME;
                break;
            case "descrizione":
                buono = Buono.DESCRIZIONE;
                break;
            case "stattrak":
                buono = Buono.STATTRAK;
                break;
            case "mobtrak":
                buono = Buono.MOBTRAK;
                break;
            default:
                player.sendMessage(ChatColor.RED + "Non riconosco il buono \"" + args[1] + "\".");
                return false;
        }
        player.getInventory().addItem(buono.getItemStack());
        player.sendMessage(ChatColor.GREEN + "Ho aggiunto il buono \"" + buono.getNormalizedString() + "\" nel tuo inventario!");
        return true;
    }
}
