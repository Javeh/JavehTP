package net.javeh.javehtp;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Action {

	
	Player playerRequesting;
	Player playerRequested;
	ActionType actionType;
	boolean consentRequired;
	
	
	Action(Player p1, Player p2, ActionType type){
		playerRequesting  = p1;
		playerRequested = p2;
		actionType = type;
		
		if(type == ActionType.TOMEMANDATORY || type == ActionType.TOYOUMANDATORY) {
			consentRequired = false;
		}
		else {
			consentRequired = true;
		}
		JavehTP.getRequestorMap().put(playerRequesting, this);
		JavehTP.getRequesteeMap().put(playerRequested, this);
		
		String requestType;
		if(type == ActionType.TOYOU) {
			requestType = ChatColor.GOLD + p1.getDisplayName() + ChatColor.GREEN + " is requesting to teleport to you." + ChatColor.GREEN + " Type " +
		ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "/accept " + ChatColor.RESET + ChatColor.GREEN + "to accept.";
		}
		else if (type == ActionType.TOTHEM) {
			requestType = ChatColor.GREEN + p1.getDisplayName() + ChatColor.LIGHT_PURPLE + " is requesting to teleport you to them."; 
		}
		else {
			requestType = "";
		}
		
		p2.sendMessage(requestType);
	}


	public Player getRequestor() {
		return playerRequesting;
	}
	
	public Player getRequestee() {
		return playerRequested;
	}
	
	public ActionType getActionType() {
		return actionType;
	}
	}
