package at.nathi.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;

public class DeathStatsListener implements Listener{
	
	public DeathStatsListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	

	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		if(p.getKiller() instanceof Player) {
			SQLStats.addTode(p.getUniqueId().toString(), 1);
			SQLStats.addKills(p.getKiller().getUniqueId().toString(), 1);

			
			e.setDeathMessage("§b§l"+ p.getName() + " §7wurde von §b§l" + e.getEntity().getKiller().getName() + " §7getötet" );
			p.getKiller().playSound(p.getKiller().getLocation(), Sound.LEVEL_UP, 3, 1);
			
			p.getPlayer().playSound(p.getLocation(), Sound.ANVIL_LAND, 3, 1);
			new BukkitRunnable() {
				
				@Override
				public void run() {
					for(Player all : Bukkit.getOnlinePlayers()) {
					JoinAndQuitListener.setScoreboard(all);
					}
					
				}
			}.runTaskLater(Main.getInstance(), 1);
		} else {
			SQLStats.addTode(p.getUniqueId().toString(), 1);;
		}
	}
}
