package net.javeh.javehtp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UnniLoginEvent implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		if(event.getPlayer().getDisplayName().equalsIgnoreCase("jvjv88")) {
			event.getPlayer().setDisplayName("Unni");
		}
	}
}
