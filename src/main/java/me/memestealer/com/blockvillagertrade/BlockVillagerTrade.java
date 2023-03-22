package me.memestealer.com.blockvillagertrade;

import me.memestealer.com.blockvillagertrade.Commands.ReloadConfigCommand;
import me.memestealer.com.blockvillagertrade.Listeners.VillagerTradeEvent;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockVillagerTrade extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new VillagerTradeEvent(this), this);
        getCommand("bvtreload").setExecutor(new ReloadConfigCommand(this));
    }

    public void noticePlayer(PlayerInteractEntityEvent e) {
        if (getConfig().getBoolean("Action-Bar")) {
            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Action-Bar-Message"));
            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg));
        }

        if (getConfig().getBoolean("Message-Enabled")) {
            String msg = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Message"));
            e.getPlayer().sendMessage(msg);
        }

        if (getConfig().getBoolean("Title")) {
            String title = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title-Message"));
            String subtitle = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Title-Subtitle"));
            e.getPlayer().sendTitle(title, subtitle);
        }
    }

    public void getProfession(Villager v, PlayerInteractEntityEvent e) {

        String prof = v.getProfession().toString();
        boolean bool = false;

        String[] professions = {"Armorer", "Butcher", "Cartographer", "Cleric", "Farmer", "Fisherman", "Fletcher", "Leatherworker", "Librarian", "Nitwit", "Shepherd", "Toolsmith", "Weaponsmith", "Mason"};

        for (String profession : professions) {
            if (prof.equalsIgnoreCase(profession)) {
                e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession." + profession));
                bool = getConfig().getBoolean("Profession-Blocker.Profession." + profession);
                break;
            }
        }

        if (bool) {
            noticePlayer(e);
        }
    }
}
