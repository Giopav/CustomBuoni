package it.giopav.custombuoni.command;

import it.giopav.custombuoni.buono.Tipo;
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
            completions.add("give");
            completions.add("help");
            completions.add("list");
            return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
        } else if (args.length == 2) {
            if ("give".equals(args[0])) {
                for (Tipo tipo : Tipo.values()) {
                    completions.add(tipo.getNormalizedString());
                }
            }
            return StringUtil.copyPartialMatches(args[1], completions, new ArrayList<>());
        }
        return null;
    }
}
