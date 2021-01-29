package net.javeh.javehtp;

import java.io.File;

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

public class HomeCommand implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
	    if(!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
	    	return true;
	    }
	    
	    Player player = (Player) sender;
		
		File file = new File(JavehTP.getPlugin(JavehTP.class).getDataFolder()+File.separator+"homes.yml");
		
		FileConfiguration save = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists() || !save.contains(player.getUniqueId().toString())) {
			player.sendMessage(ChatColor.RED + "You need to use " + ChatColor.LIGHT_PURPLE + "/sethome" + ChatColor.RED + "to set a home first");
			return true;
		}
		
		String coords = save.getString((player.getUniqueId().toString()));
		
		if(args.length > 0 && player.isOp()) {
			coords = save.getString(Bukkit.getOfflinePlayer(args[0]).getUniqueId().toString());
		}
		
		String[] loc = coords.split(",");
		
		World w = Bukkit.getWorld(loc[0]);
		double x = Double.parseDouble(loc[1]);
	    double y = Double.parseDouble(loc[2]);
	    double z = Double.parseDouble(loc[3]);
	    Location location = new Location(w, x, y, z);
		player.teleport(location);
		
		return true;
	    
	

	}
}
