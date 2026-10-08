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
				if(p.isOp()) {
					if(args.length == 1) {
						
						Player target = Bukkit.getPlayer(args[0]);
						if(target != null) {
							
							if(!freezedPlayers.contains(target.getName())) {
								freezedPlayers.add(target.getName());
								p.sendMessage("§7Der Spieler §b§l" + target.getName() + " §7wurde gefreezed!");
								target.sendMessage("§7Du wurdest von §b§l" + p.getName() + " §7gefreezed!");
							} else {
								freezedPlayers.remove(target.getName());
								p.sendMessage("§7Der Spieler §b§l" + target.getName() + " §7wurde entfreezed!");
								target.sendMessage("§7Du wurdest von §b§l" + p.getName() + " §7gefreezed!");
							}
							
						
						
						} else
							p.sendMessage("§7Der Spieler §b§l" + args[0] + " §7ist nicht auf den Server");
					} else
						p.sendMessage("§7Bitte benutze §b§l/freeze <SPIELER>");
				
					}else 
						p.sendMessage(Main.prefix + "§7Du hast keine §3Rechte §7für das §b§lCommand§7!");
			}
		}
				
					
				

		
			
			
			
			
			
			
			
		
		
		

	return false;	
	}

}
