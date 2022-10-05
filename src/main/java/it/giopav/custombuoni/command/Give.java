package it.giopav.custombuoni.command;

import it.giopav.custombuoni.buono.Buono;
import it.giopav.custombuoni.buono.Tipo;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Give {
    public static boolean give(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + "Devi selezionare quale buono vuoi.");
            return true;
        }
        if (player.getInventory().firstEmpty() == -1) {
            player.sendMessage(ChatColor.RED + "Il tuo inventario è pieno.");
            return false;
        }
        Buono buono;
        switch(args[1].toLowerCase()) {
            case "nome":
                buono = new Buono(Tipo.NOME);
                break;
            case "descrizione":
                buono = new Buono(Tipo.DESCRIZIONE);
                break;
            case "stattrak":
                buono = new Buono(Tipo.STATTRAK);
                break;
            case "mobtrak":
                buono = new Buono(Tipo.MOBTRAK);
                break;
            default:
                player.sendMessage(ChatColor.RED + "Non riconosco il buono \"" + args[1] + "\".");
                return false;
        }
        player.getInventory().addItem(buono.getItemStack());
        player.sendMessage(ChatColor.GREEN + "Ho aggiunto il buono \"" + buono.getTipo().getNormalizedString() + "\" nel tuo inventario!");
        return true;
    }
}
