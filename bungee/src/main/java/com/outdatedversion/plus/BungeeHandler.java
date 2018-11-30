package com.outdatedversion.plus;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

/**
 * @author Ben (OutdatedVersion)
 * @since Dec/17/2016 (5:18 PM)
 */
public class BungeeHandler extends Plugin implements Listener
{

    @Override
    public void onEnable()
    {
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void handlePing(final ProxyPingEvent event)
    {
        // wouldn't it be nice if these methods just returned a modified ServerPing?
        // would keep this from looking so messy

        final ServerPing _response = event.getResponse();
        if(getProxy().getOnlineCount() > 100)
        {
            _response.getPlayers().setMax(getProxy().getOnlineCount() + 1);
        }
        else
        {
            _response.getPlayers().setMax(100);
        }

        event.setResponse(_response);
    }

}
