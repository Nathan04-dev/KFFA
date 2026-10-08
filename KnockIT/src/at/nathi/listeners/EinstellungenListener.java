package at.nathi.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffectType;

import at.nathi.main.Main;
import config.GUI;
import config.locations;


public class EinstellungenListener implements Listener {
	

	
	public EinstellungenListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}


	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
	
		if(e.getCurrentItem() == null) {
			return ;
		}
		
		if(!(e.getWhoClicked() instanceof Player)) return;
		

		if(e.getView().getTitle() == GUI.GUIConfig.getString("EffectsGUI.Name")) {
			e.setCancelled(true);
			if(e.getSlot() == 0) {
				p.sendMessage(Main.prefix + GUI.GUIConfig.getString("EffectsGUI.AktiviertMessage"));
				RandomEffects.startEffects();
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);	
				p.closeInventory();			
	
				
			} else if(e.getSlot() == 8) {
				for(Player all : Bukkit.getOnlinePlayers()) {
					all.removePotionEffect(PotionEffectType.HEAL);
					all.removePotionEffect(PotionEffectType.BLINDNESS);
					all.removePotionEffect(PotionEffectType.ABSORPTION);
				}
				Bukkit.getScheduler().cancelTask(RandomEffects.taskID1);
				p.sendMessage(Main.prefix + GUI.GUIConfig.getString("EffectsGUI.DeaktiviertMessage"));
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 3, 1);
				p.closeInventory();
			}
		}
		
		if(e.getView().getTitle() == GUI.GUIConfig.getString("MapsGUI.Name")) {
			e.setCancelled(true);
			if(e.getSlot() == 0) {
				
				double x = (double) locations.LocationConfig.getDouble("Map1.X");
				double y = (double) locations.LocationConfig.getDouble("Map1.Y");
				double z = (double) locations.LocationConfig.getDouble("Map1.Z");
				String w = (String) locations.LocationConfig.getString("Map1.World");
				float yaw = (float) locations.LocationConfig.getDouble("Map1.Yaw");
				float pitch = (float) locations.LocationConfig.getDouble("Map1.Pitch");
				World world = Bukkit.getWorld(w);
				
				Location loc = new Location(world, x, y, z, yaw, pitch);
				
				String map1 = GUI.GUIConfig.getString("MapsGUI.Map1_Select");
				map1 = map1.replace("%Map1_Name%", locations.LocationConfig.getString("Map1.Name"));
				
				p.closeInventory();
				p.sendMessage(Main.prefix + map1);
				p.sendTitle(Main.prefix, null, 20, 20, 20);
				p.teleport(loc);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
				
			} 
		
			if(e.getSlot() == 4) {
				
				double x = (double) locations.LocationConfig.getDouble("Map2.X");
				double y = (double) locations.LocationConfig.getDouble("Map2.Y");
				double z = (double) locations.LocationConfig.getDouble("Map2.Z");
				String w = (String) locations.LocationConfig.getString("Map2.World");
				float yaw = (float) locations.LocationConfig.getDouble("Map2.Yaw");
				float pitch = (float) locations.LocationConfig.getDouble("Map2.Pitch");
				World world = Bukkit.getWorld(w);
				
				Location loc = new Location(world, x, y, z, yaw, pitch);
				String map2 = GUI.GUIConfig.getString("MapsGUI.Map2_Select");
				map2 = map2.replace("%Map2_Name%", locations.LocationConfig.getString("Map2.Name"));
				
				p.closeInventory();
				p.sendMessage(Main.prefix + map2);
				p.sendTitle(Main.prefix, null, 20, 20, 20);
				p.teleport(loc);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);

			 
			 }
			 if(e.getSlot() == 8) {
				double x = (double) locations.LocationConfig.getDouble("Map3.X");
				double y = (double) locations.LocationConfig.getDouble("Map3.Y");
				double z = (double) locations.LocationConfig.getDouble("Map3.Z");
				String w = (String) locations.LocationConfig.getString("Map3.World");
				float yaw = (float) locations.LocationConfig.getDouble("Map3.Yaw");
				float pitch = (float) locations.LocationConfig.getDouble("Map3.Pitch");
				World world = Bukkit.getWorld(w);
				
				Location loc = new Location(world, x, y, z, yaw, pitch);
				
				String map3 = GUI.GUIConfig.getString("MapsGUI.Map3_Select");
				map3 = map3.replace("%Map3_Name%", locations.LocationConfig.getString("Map3.Name"));
				p.closeInventory();
				p.sendMessage(Main.prefix + map3);
				p.sendTitle(Main.prefix, null, 20, 20, 20);
				p.teleport(loc);
				p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
				
			}
		}
		
	}

}
