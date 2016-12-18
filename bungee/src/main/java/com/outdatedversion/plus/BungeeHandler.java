package com.outdatedversion.plus;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * OutdatedVersion
 * Dec/17/2016 (5:18 PM)
 */

public class BungeeHandler extends Plugin implements Listener
{

    @Override
    public void onEnable()
    {
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void handlePing(ProxyPingEvent event)
    {
        // wouldn't it be nice if these methods just returned a modified ServerPing?
        // would keep this from looking so messy

        final ServerPing _response = event.getResponse();
        _response.getPlayers().setMax(getProxy().getOnlineCount() + 1);

        event.setResponse(_response);
    }

}
