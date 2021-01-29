package net.javeh.javehtp;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class JavehTP extends JavaPlugin {

	
	@Override
	public void onEnable() {
		//commands
		this.getCommand("TPA").setExecutor(new TPACommand());
		this.getCommand("tpahere").setExecutor(new TPAHereCommand());
		this.getCommand("Accept").setExecutor(new AcceptCommand());
		this.getCommand("Home").setExecutor(new HomeCommand());
		this.getCommand("Spawn").setExecutor(new SpawnCommand());
		this.getCommand("sethome").setExecutor(new SetHomeCommand());
		this.getCommand("setwarp").setExecutor(new SetWarpCommand());
		this.getCommand("warp").setExecutor(new WarpCommand());
		this.getCommand("delwarp").setExecutor(new DelWarpCommand());
		this.getCommand("warps").setExecutor(new WarpsCommand());
		
		
		//events
	    getServer().getPluginManager().registerEvents(new UnniLoginEvent(), this);

	}
	
	@Override
	public void onDisable() {
		
	}
	
	static HashMap<Player, Action> requestorMap = new HashMap<Player, Action>();
	static HashMap<Player, Action> requesteeMap = new HashMap<Player, Action>();
	
	public static HashMap<Player,Action> getRequestorMap(){
		return requestorMap;
	}
	public static HashMap<Player,Action> getRequesteeMap(){
		return requesteeMap;
	}
	
}
