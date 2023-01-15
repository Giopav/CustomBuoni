package it.giopav.custombuoni.buoni.categories;

import it.giopav.custombuoni.CustomBuoni;
import it.giopav.custombuoni.buoni.Buono;
import it.giopav.custombuoni.buoni.BuonoType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class BuonoNome extends Buono {
    public BuonoNome() {
        super(BuonoType.NOME,
                ChatColor.WHITE + "Buono " + ChatColor.RED + "nome",
                ChatColor.GRAY + "» ",
                ChatColor.DARK_GRAY + "Cambia il nome di un item!");
    }

    public ItemStack value(@NotNull String value) {
        ItemStack itemStack = this.getItemStack();
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<Component> lore = itemMeta.lore();
        assert lore != null;
        lore.set(0, Component.text(ChatColor.GRAY + "» " + ChatColor.WHITE + value));
        itemMeta.lore(lore);
        return itemStack;
    }

    public ItemStack value() {
        return value("");
    }

    public String extractValue(ItemStack buono) {
        ItemMeta buonoMeta = buono.getItemMeta();
        PersistentDataContainer buonoData = buonoMeta.getPersistentDataContainer();
        if (!buonoData.has(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING)) {
            return null;
        }
        if (!Objects.equals(buonoData.get(CustomBuoni.getInstance().getKey(), PersistentDataType.STRING), this.getBuonoType().toString())) {
            return null;
        }
        List<Component> lore = buonoMeta.lore();
        assert lore != null;
        return PlainTextComponentSerializer.plainText().serialize(lore.get(0)).replaceFirst(ChatColor.GRAY + "» ", "");
    }
}