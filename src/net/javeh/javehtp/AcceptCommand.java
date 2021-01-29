package net.javeh.javehtp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AcceptCommand implements CommandExecutor {

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
		if(JavehTP.getRequesteeMap().containsKey(sender)) {
			Action action = JavehTP.getRequesteeMap().get(sender);
			
			String message = ChatColor.GREEN + "Accepting your request from " + ChatColor.GOLD + action.getRequestor().getDisplayName();
			sender.sendMessage(message);
			message = ChatColor.GREEN + "Your request was accepted by " + ChatColor.GOLD + action.getRequestee().getDisplayName();
			action.getRequestor().sendMessage(message);
			
			if(action.getActionType() == ActionType.TOYOU) {
				action.getRequestor().teleport(action.getRequestee());
			}
			else {
				action.getRequestee().teleport(action.getRequestor());
			}
			
			JavehTP.getRequestorMap().remove(action.getRequestor());
			JavehTP.getRequesteeMap().remove(action.getRequestee());
			return true;
		}
		else {
			sender.sendMessage(ChatColor.RED + "You have no requests.");
			return true;
		}
		
	}
}
