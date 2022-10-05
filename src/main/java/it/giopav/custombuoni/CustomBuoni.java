package it.giopav.custombuoni;

import it.giopav.custombuoni.command.CommandHandler;
import it.giopav.custombuoni.command.TabCompleteHandler;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomBuoni extends JavaPlugin {

    private static CustomBuoni instance;
    private final NamespacedKey key = new NamespacedKey(this, "custombuoni-buono");

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("buono")).setTabCompleter(new TabCompleteHandler());
        Objects.requireNonNull(this.getCommand("buono")).setExecutor(new CommandHandler());
        instance = this;
    }

    public static CustomBuoni getInstance() {
        return instance;
    }
    public NamespacedKey getKey() {
        return key;
    }
}
