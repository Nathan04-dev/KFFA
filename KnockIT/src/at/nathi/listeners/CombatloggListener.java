package at.nathi.listeners;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import at.nathi.main.Main;

public class CombatloggListener implements Listener{
	
	public CombatloggListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	public static int combatlogseconds = 5;
	
	
	@EventHandler
	public void onCombatlog(PlayerDeathEvent e) {
		

		Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				combatlogseconds--;
				switch(combatlogseconds) {
				
				case 4: case 3: case 2: case 1: 

					break;
				case 0:
					
				break;
				default:
				break;
				
			}
				
			}
		}, 0, 20);
	}
	
	}


