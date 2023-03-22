package me.memestealer.com.blockvillagertrade.Commands;

import me.memestealer.com.blockvillagertrade.BlockVillagerTrade;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReloadConfigCommand implements CommandExecutor {

    BlockVillagerTrade main;

    public ReloadConfigCommand(BlockVillagerTrade main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("blockvillagertrade.reload")) {
                reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Other-Messages.Reload")));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Other-Messages.No-Permission")));
            }
        } else {
            reloadConfig();
            System.out.println(ChatColor.translateAlternateColorCodes('&', main.getConfig().getString("Other-Messages.Reload")));
        }

        return true;
    }

    public void reloadConfig() {
        main.reloadConfig();
        main.saveDefaultConfig();
        main.getConfig().options().copyDefaults(true);
        main.saveConfig();
    }
}
