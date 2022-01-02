package me.memestealer.com.blockvillagertrade.Listeners;

import me.memestealer.com.blockvillagertrade.BlockVillagerTrade;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VillagerTradeEvent implements Listener {

    BlockVillagerTrade main;

    public VillagerTradeEvent(BlockVillagerTrade main) {
        this.main = main;
    }

    @EventHandler
    public void onVillagerTrade(PlayerInteractEntityEvent e) {

        if (e.getRightClicked().getType().equals(EntityType.VILLAGER)) {

            Villager v = (Villager) e.getRightClicked();

            if (main.getConfig().getBoolean("Enabled")) {

                if (e.getPlayer().hasPermission("blockvillagertrade.bypass")) {
                    e.setCancelled(false);
                } else if (main.getConfig().getBoolean("Profession-Blocker.Enabled")) {
                    main.getProfession(v, e);
                } else if (v.getProfession().equals(Villager.Profession.NONE)) {
                    e.setCancelled(false);
                } else {
                    e.setCancelled(true);
                    main.noticePlayer(e);
                }

            } else {
                e.setCancelled(false);
            }
        }
    }
}
