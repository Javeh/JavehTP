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

public class SetHomeCommand implements CommandExecutor{
	

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("This command can only be run by a player.");
			return true;
		}
		
		Player player = (Player) sender;
		
		File file = new File(JavehTP.getPlugin(JavehTP.class).getDataFolder()+File.separator+"homes.yml");
		
		FileConfiguration save = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists()) {
		    try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		Location location = player.getLocation();
		save.set(player.getUniqueId().toString(), location.getWorld().getName()+","+location.getX()+","+location.getY()+","+location.getZ() );
		try {
			save.save(file);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		player.sendMessage(ChatColor.YELLOW+"Home successfully set.");
    	return true;
	}
	

}
