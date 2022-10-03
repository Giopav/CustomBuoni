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
            sender.sendMessage(ChatColor.RED + "The command can only be executed by a player!");
            return false;
        }
        Player player = (Player) sender;
        if (Objects.requireNonNull(((Player) sender).getPlayer()).getEquipment().getItemInMainHand().getType() != Material.PAPER) {
            player.sendMessage(ChatColor.RED + "Your main hand does not have paper equipped!");
            return false;
        }
        player.sendMessage(ChatColor.RED + "Paper detected!");
        return true;
    }
}
