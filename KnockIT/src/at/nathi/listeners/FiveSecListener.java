package at.nathi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import at.nathi.main.Main;
import config.locations;


public class FiveSecListener implements Listener{
	
	public FiveSecListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	public static int taskID;
	
	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getEntity();
		Player k = (Player) e.getDamager();
		if(p.getLocation().getBlockY() <= locations.LocationConfig.getInt("Deathheight.Y")) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
		
			public int fiveseconds = 5;
			
		@Override
		public void run() {
			fiveseconds--;
			
			switch(fiveseconds) {
			case 5:
				if(e.getDamager() == k) {
					
					for(Player all: Bukkit.getOnlinePlayers()) {
						all.sendMessage("§e§l"+ p.getName() + " §7wurde von §e§l" + k.getName() + " §7getötet (test0)" );
					}
				}
				break;
			case 4:
				break;
			case 3:
				break;
			case 2:
				break;
			case 1:
				break;
			case 0:
				
				for(Player all: Bukkit.getOnlinePlayers()) {
					all.sendMessage("§e§l"+ p.getName() + " §7ist gestorben");
				}


				break;
				default:
					break;
			}
			
		}
	}, 0, 20);
		}
		

	}

}
