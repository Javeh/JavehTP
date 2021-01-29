package net.javeh.javehtp;

import java.io.File;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.md_5.bungee.api.ChatColor;

public class WarpsCommand implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		File file = new File(JavehTP.getPlugin(JavehTP.class).getDataFolder()+File.separator+"warps.yml");
		
		FileConfiguration save = YamlConfiguration.loadConfiguration(file);
		
		Set<String> keys = save.getKeys(true);
		String message = ChatColor.YELLOW + "Warps: \n";
		int i = 1;
		for(String current:keys) {
			message+= ChatColor.YELLOW +""+ i + ". " + current +"\n";
			i++;
		}
		sender.sendMessage(message);
		return true;
		
	}
	
	
}
