package it.giopav.custombuoni.command;

import it.giopav.custombuoni.command.buono.Apply;
import it.giopav.custombuoni.command.buono.Modify;
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
                case "cancel":
                    return Cancel.cancel(player);
                case "give":
                    return Give.give(player, args);
                case "help":
                    return Help.help(player);
                case "list":
                    return List.list(player);
                default:
                    StringBuilder argCluster = new StringBuilder();
                    for (int i = 1; i< args.length; i++) {
                        argCluster.append(args[i]);
                    }
                    return Modify.buono(player, argCluster.toString());
            }
        }
        return Modify.buono(player, null);
    }
}
