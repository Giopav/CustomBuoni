package it.giopav.custombuoni;

import it.giopav.custombuoni.command.CommandHandler;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomBuoni extends JavaPlugin {

    private static CustomBuoni istance;
    private final NamespacedKey key = new NamespacedKey(this, "custombuoni-buono");

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("buono")).setExecutor(new CommandHandler());
        istance = this;
    }

    public static CustomBuoni getIstance() {
        return istance;
    }
    public NamespacedKey getKey() {
        return key;
    }
}
