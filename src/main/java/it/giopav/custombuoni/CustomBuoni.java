package it.giopav.custombuoni;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CustomBuoni extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("buono")).setExecutor(new CommandHandler());
    }
}
