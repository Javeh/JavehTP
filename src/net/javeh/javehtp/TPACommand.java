package net.javeh.javehtp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPACommand implements CommandExecutor {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(args.length == 0) {
			sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.LIGHT_PURPLE + "You must specify a target player");
			return true;
		}
		Player target = Bukkit.getServer().getPlayer(args[0]);
		if(!(sender instanceof Player)) {
			return false;
		}
		if(target == null) {
			sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "ERROR! " + ChatColor.LIGHT_PURPLE + "Could not find target player");
			return true;
		}
		
		Player playerSender = (Player) sender;
		playerSender.sendMessage(ChatColor.GREEN + "Sending request to " +ChatColor.GOLD + target.getDisplayName());
		new Action(playerSender, target, ActionType.TOYOU);
		return true;
	}
}
