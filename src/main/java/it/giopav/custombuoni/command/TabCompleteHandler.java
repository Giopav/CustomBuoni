package it.giopav.custombuoni.command;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TabCompleteHandler implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("apply");
            completions.add("cancel");
            completions.add("give");
            completions.add("help");
            completions.add("list");
        } else if (args.length == 2
                && args[0].equalsIgnoreCase("give")
                && sender.hasPermission("custombuoni.command.give")) {
            for (Buono buono : CustomBuoni.getBuoniHashMap().values()) {
                completions.add(buono.getNormalizedString());
            }
        }
        return StringUtil.copyPartialMatches(args[args.length-1], completions, new ArrayList<>());
    }
}