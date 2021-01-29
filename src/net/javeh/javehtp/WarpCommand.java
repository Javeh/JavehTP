package net.javeh.javehtp;

import java.io.File;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class WarpCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
	    if(!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
	    	return true;
	    }
	    
	    if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "You need to specify a destination");
	    	return true;
	    }
	    
	    Player player = (Player) sender;
		
		File file = new File(JavehTP.getPlugin(JavehTP.class).getDataFolder()+File.separator+"warps.yml");
		
		FileConfiguration save = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists()) {
			player.sendMessage(ChatColor.RED + "No warps set yet!");
			return true;
		}

		String coords = "";
		
		
		//check for a number
		try {
			int warpNum = Integer.parseInt(args[0]);
			Set<String> keys = save.getKeys(true);
			for(int i = 1; i <= warpNum; i++) {
				if(i == warpNum) {
					coords = save.getString(keys.toArray()[i-1].toString());
				}
			}
		}
		catch (NumberFormatException e){
			//if the argument was not a number, check if it was a warp name
			if(save.contains(args[0])) {
				coords = save.getString(args[0]);
			}
			else {
				//we've exhausted our options. There is no warp resembling the command.
				player.sendMessage(ChatColor.RED + "Could not locate warp!");
				return true;
			}
		}
		
		
		
		String[] loc = coords.split(",");
		
		
		World w = Bukkit.getWorld(loc[0]);
		double x = Double.parseDouble(loc[1]);
	    double y = Double.parseDouble(loc[2]);
	    double z = Double.parseDouble(loc[3]);
	    float pitch = Float.parseFloat(loc[4]);
	    float yaw = Float.parseFloat(loc[5]);
	    
	    Location location = new Location(w, x, y, z, pitch, yaw);
	    location.setPitch(pitch);
		player.teleport(location);
		
		return true;
	    
	

	}
}
