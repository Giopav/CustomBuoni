package it.giopav.custombuoni;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CommandHandler implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (Objects.requireNonNull(((Player) sender).getPlayer()).getEquipment().getItemInMainHand().getType() != Material.PAPER) {
            return false;
        }
        player.getInventory().addItem(new ItemStack(Material.DIAMOND));
        return true;
    }
}
