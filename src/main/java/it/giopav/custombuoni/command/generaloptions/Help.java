package it.giopav.custombuoni.command.generaloptions;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Help {
    public static boolean help(Player player) {
        player.sendMessage(ChatColor.GREEN + "Comandi:");
        player.sendMessage(ChatColor.GREEN + "[]: Obbligatorio; {}: Opzionale;");
        player.sendMessage(ChatColor.GREEN + "/buono - Modifica il buono della mano principale.");
        player.sendMessage(ChatColor.GREEN + "/buono apply - Applica un buono ad un item.");
        player.sendMessage(ChatColor.GREEN + "/buono cancel - Resetta il buono della mano principale.");
        player.sendMessage(ChatColor.GREEN + "/buono give [buono] - Ricevi il buono selezionato.");
        player.sendMessage(ChatColor.GREEN + "/buono help - Mostra questo menù.");
        player.sendMessage(ChatColor.GREEN + "/buono list - Mostra la lista dei buoni.");
        player.sendMessage(ChatColor.GREEN + "Se ci sono problemi segnala sul mio github! ~Giopav");
        TextComponent message = Component.text(ChatColor.GREEN + "» Click me! «");
        player.sendMessage(message.clickEvent(ClickEvent.openUrl("https://github.com/Giopav/CustomBuoni/issues")));
        return true;
    }
}
