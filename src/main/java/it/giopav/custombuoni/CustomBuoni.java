package it.giopav.custombuoni;

import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import it.giopav.custombuoni.buoni.categories.*;
import it.giopav.custombuoni.command.CommandHandler;
import it.giopav.custombuoni.command.TabCompleteHandler;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CustomBuoni extends JavaPlugin {
    private static CustomBuoni instance;
    private final NamespacedKey key = new NamespacedKey(this, "custombuoni-buono");

    private static final HashMap<BuonoType, Buono> BUONI_HASH_MAP = new HashMap<>();
    private static final HashMap<String, BuonoType> BUONI_TYPE_HASH_MAP = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        initializeCommand();
        Bukkit.getServer().getLogger().info("Main command initialized.");

        initializeBuoniHashMap();
        initializeBuoniTypeHashMap();
        Bukkit.getServer().getLogger().info("HashMaps initialized.");
    }

    private void initializeCommand() {
        Objects.requireNonNull(this.getCommand("buono")).setTabCompleter(new TabCompleteHandler());
        Objects.requireNonNull(this.getCommand("buono")).setExecutor(new CommandHandler());
    }

    private void initializeBuoniHashMap() {
        BUONI_HASH_MAP.put(BuonoType.NOME, new BuonoNome());
        BUONI_HASH_MAP.put(BuonoType.DESCRIZIONE, new BuonoDescrizione());
        BUONI_HASH_MAP.put(BuonoType.STATTRAK, new BuonoStattrak());
        BUONI_HASH_MAP.put(BuonoType.MOBTRAK, new BuonoMobtrak());
        BUONI_HASH_MAP.put(BuonoType.RIVELATORE, new BuonoRivelatore());
    }

    private void initializeBuoniTypeHashMap() {
        BUONI_TYPE_HASH_MAP.put("NOME", BuonoType.NOME);
        BUONI_TYPE_HASH_MAP.put("DESCRIZIONE", BuonoType.DESCRIZIONE);
        BUONI_TYPE_HASH_MAP.put("STATTRAK", BuonoType.STATTRAK);
        BUONI_TYPE_HASH_MAP.put("MOBTRAK", BuonoType.MOBTRAK);
        BUONI_TYPE_HASH_MAP.put("RIVELATORE", BuonoType.RIVELATORE);
    }

    public static Map<BuonoType, Buono> getBuoniHashMap() {
        return BUONI_HASH_MAP;
    }

    public static Map<String, BuonoType> getBuoniTypeHashMap() {
        return BUONI_TYPE_HASH_MAP;
    }

    public NamespacedKey getKey() {
        return key;
    }

    public static CustomBuoni getInstance() {
        return instance;
    }
}