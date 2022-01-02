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

        if (prof.equalsIgnoreCase("Armorer")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Armorer"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Armorer");
        }

        if (prof.equalsIgnoreCase("Butcher")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Butcher"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Butcher");
        }

        if (prof.equalsIgnoreCase("Cartographer")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Cartographer"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Cartographer");
        }

        if (prof.equalsIgnoreCase("Cleric")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Cleric"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Cleric");
        }

        if (prof.equalsIgnoreCase("Farmer")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Farmer"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Farmer");
        }

        if (prof.equalsIgnoreCase("Fisherman")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Fisherman"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Fisherman");
        }

        if (prof.equalsIgnoreCase("Fletcher")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Fletcher"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Fletcher");
        }

        if (prof.equalsIgnoreCase("Leatherworker")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Leatherworker"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Leatherworker");
        }

        if (prof.equalsIgnoreCase("Librarian")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Librarian"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Librarian");
        }

        if (prof.equalsIgnoreCase("Nitwit")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Nitwit"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Nitwit");
        }

        if (prof.equalsIgnoreCase("Shepherd")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Shepherd"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Shepherd");
        }

        if (prof.equalsIgnoreCase("Toolsmith")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Toolsmith"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Toolsmith");
        }

        if (prof.equalsIgnoreCase("Weaponsmith")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Weaponsmith"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Weaponsmith");
        }

        if (prof.equalsIgnoreCase("Mason")) {
            e.setCancelled(getConfig().getBoolean("Profession-Blocker.Profession.Mason"));
            bool = getConfig().getBoolean("Profession-Blocker.Profession.Mason");
        }

        if (bool) {
            noticePlayer(e);
        }
    }
}
