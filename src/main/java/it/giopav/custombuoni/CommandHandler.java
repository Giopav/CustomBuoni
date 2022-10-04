package it.giopav.custombuoni;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandHandler implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Il comando può essere eseguito solo dal gioco!");
            return false;
        }
        Player player = (Player) sender;
        if (Objects.requireNonNull(((Player) sender).getPlayer()).getEquipment().getItemInMainHand().getType() != Material.PAPER) { //TODO implement a valid check for buoni in the main hand.
            player.sendMessage(ChatColor.RED + "Non hai un buono in mano.");
            return false;
        }
        player.sendMessage(ChatColor.GREEN + "Buono rilevato!");

        //TODO continue the command with the options
        return true;
    }
}
