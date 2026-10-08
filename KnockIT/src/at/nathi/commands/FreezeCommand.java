package at.nathi.commands;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import at.nathi.main.Main;
import config.messages;

public class FreezeCommand implements CommandExecutor, Listener{
	

	


	private ArrayList<String> freezedPlayers = new ArrayList<>();
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(freezedPlayers.contains(p.getName())) {
		
		e.setCancelled(true);

		} 
		
			
	}

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;{
				if(p.isOp() || p.hasPermission("knockffa.admin") || p.hasPermission("knockffa.moderator")) {
					if(args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
							if(!freezedPlayers.contains(target.getName())) {
								freezedPlayers.add(target.getName());
								String addfreeze = messages.messageConfig.getString("MSGConfig.ADD_FREEZE");
								addfreeze = addfreeze.replace("%target_player%", target.getName());
								p.sendMessage(Main.prefix + addfreeze);
							} else {
								freezedPlayers.remove(target.getName());
								String removefreeze = messages.messageConfig.getString("MSGConfig.REMOVE_FREEZE");
								removefreeze = removefreeze.replace("%target_player%", target.getName());
								p.sendMessage(Main.prefix + removefreeze);
							}
							
						
						
						} else
							p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SETSTATS.PlayerNotOnline"));
					} else
						p.sendMessage(Main.prefix + "§7Bitte benutze §e/freeze <SPIELER>");
				
					}else 
						p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.KNOCKFFA_NoPermission"));
			}
		}
				
					
				

		
			
			
			
			
			
			
			
		
		
		

	return false;	
	}

}
