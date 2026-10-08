package at.nathi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import at.nathi.main.Main;

public class AutoRespawnListener implements Listener {
	

	
	public static final int RESPAWN_TIME = 0;
	
	public AutoRespawnListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player player = e.getEntity();
		

		
		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if(player != null) {
				if(player.isDead()) {
					player.spigot().respawn();;
					player.playSound(player.getLocation(), Sound.NOTE_PLING, 15, 15);

				}
				}
			}
		}, 20 * RESPAWN_TIME);
	}

}
