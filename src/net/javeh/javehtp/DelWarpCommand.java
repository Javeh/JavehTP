package net.javeh.javehtp;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class DelWarpCommand implements CommandExecutor{
	

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
			return true;
		}
		Player player = (Player) sender;
		if (!player.isOp()) {
			player.sendMessage(ChatColor.RED + "You do not have permission to run this command.");
			return true;
		}
		if(args.length == 0) {
			player.sendMessage(ChatColor.RED + "Please set a name for the warp");
		}
		
		
		File file = new File(JavehTP.getPlugin(JavehTP.class).getDataFolder()+File.separator+"warps.yml");
		
		FileConfiguration save = YamlConfiguration.loadConfiguration(file);
		
		
		
		
		if (!file.exists()) {
		    try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		save.set(args[0], null);
		
		try {
			save.save(file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		player.sendMessage(ChatColor.YELLOW+"Warp successfully deleted.");
    	return true;
	}
	

}
