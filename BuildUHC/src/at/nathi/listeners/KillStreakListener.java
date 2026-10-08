package at.nathi.listeners;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.nathi.main.Main;
import at.nathi.title.TitleAPI;

public class KillStreakListener implements Listener {
	
	public KillStreakListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	public static HashMap<String, Integer> killStreak = new HashMap<>();
	public static int[] toBroadcast = new int[] {3, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50}; 

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		if(e.getEntity().getKiller()!= null && e.getEntity().getKiller() != e.getEntity()) {
		 Player p = (Player) e.getEntity();
		 Player k = (Player) e.getEntity().getKiller();
	
			if(killStreak.containsKey(k.getName())) 
				killStreak.put(k.getName(), killStreak.get(k.getName()) + 1);
			 else 
				killStreak.put(k.getName(), 1);
			
			
			int kills = killStreak.get(k.getName());
			for (int index : toBroadcast) {
				if(kills == index) {
					ItemStack gap = new ItemStack(Material.GOLDEN_APPLE);
					ItemMeta gapmeta = gap.getItemMeta();
					gapmeta.setDisplayName("§6§lGoldener Apfel");
					gap.setItemMeta(gapmeta);
					Bukkit.getOnlinePlayers().forEach(current -> {
					current.playSound(current.getLocation(), Sound.LEVEL_UP, 3, 1);
					current.sendMessage(Main.prefix + "§7Der Spieler §b§l" + k.getName() + " §7hat eine Killstreak von §b§l" + index);
					TitleAPI.sendTitle(p.getKiller(), 20, 20, 20, "§7Killstreak: §b§l" + index, "");
					if(index == 3) {
						p.getKiller().getInventory().addItem(gap);
					}
					});
					break;
				}
			}
			assert killStreak.containsKey(p.getName());
			killStreak.remove(p.getName());
		}
	}

}
