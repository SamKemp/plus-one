package com.outdatedversion.plus;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Ben (OutdatedVersion)
 * @since Dec/17/2016 (4:53 PM)
 */
public class BukkitHandler extends JavaPlugin implements Listener
{

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void handlePing(final ServerListPingEvent event)
    {
        event.setMaxPlayers(Bukkit.getOnlinePlayers().size() + 1);
    }

}
