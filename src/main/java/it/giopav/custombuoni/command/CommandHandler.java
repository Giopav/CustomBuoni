package it.giopav.custombuoni.command;

import it.giopav.custombuoni.command.buoni.Apply;
import it.giopav.custombuoni.command.buoni.Buono;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandHandler implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Il comando può essere eseguito solo dal gioco.");
            return false;
        }
        Player player = (Player) sender;
        if (args.length >= 1) {
            switch (args[0].toLowerCase()) {
                case "apply":
                    return Apply.apply(player);
                case "give":
                    return Give.give(player, args);
                case "help":
                    return Help.help(player);
                case "list":
                    return List.list(player);
                default:
                    sender.sendMessage(ChatColor.RED + "Non riconosco l'argomento \"" + args[0] + "\".");
                    return false;
            }
        }
        return Buono.buono(player);
    }
}
