package at.nathi.listeners;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import at.nathi.main.Main;
import config.locations;
import config.messages;
import config.shop;

public class RettungsPlattformListener implements Listener{
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static int taskID;
	
	public RettungsPlattformListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	} 
	
	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().getBlockY() <= locations.LocationConfig.getInt("Spawnheight.Y")) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			try {
				if(e.getItem().getType().equals(Material.BLAZE_ROD))  {
				  	if(!used.contains(p.getName())) {

					Location pLoc = p.getLocation();
					
					 Location frontBlock = new Location(pLoc.getWorld(), pLoc.getX() +1, pLoc.getY() -6, pLoc.getZ());
					 Location backBlock = new Location(pLoc.getWorld(), pLoc.getX() -1, pLoc.getY() -6, pLoc.getZ());
					 Location middleBlock = new Location(pLoc.getWorld(), pLoc.getX(), pLoc.getY() -6, pLoc.getZ());
					 Location rightBlock = new Location(pLoc.getWorld(), pLoc.getX(), pLoc.getY() -6, pLoc.getZ() -1);
					 Location leftBlock = new Location(pLoc.getWorld(), pLoc.getX(), pLoc.getY() -6, pLoc.getZ() +1);
					
					if(frontBlock.getBlock().getType().equals(Material.AIR)) 
						frontBlock.getBlock().setType(Material.SLIME_BLOCK);
					
					if(backBlock.getBlock().getType().equals(Material.AIR)) 
						backBlock.getBlock().setType(Material.SLIME_BLOCK);
					
					if(middleBlock.getBlock().getType().equals(Material.AIR)) 
						middleBlock.getBlock().setType(Material.SLIME_BLOCK);
					
					if(rightBlock.getBlock().getType().equals(Material.AIR)) 
						rightBlock.getBlock().setType(Material.SLIME_BLOCK);
					
					if(leftBlock.getBlock().getType().equals(Material.AIR)) 
						leftBlock.getBlock().setType(Material.SLIME_BLOCK);
					
				  	used.add(p.getName());
				  	String cooldown = messages.messageConfig.getString("MSGConfig.Rettungsplattform_COOLDOWN");
				  	cooldown = cooldown.replace("%cooldown%", String.valueOf(shop.ShopConfig.getInt("Shop.Kits.Kit3.Cooldown")));
	            	p.sendMessage(Main.prefix + cooldown);
				  	String cooldown1 = messages.messageConfig.getString("MSGConfig.Rettungsplattform_READY");
				  	cooldown1 = cooldown1.replace("%cooldown%", String.valueOf(shop.ShopConfig.getInt("Shop.Kits.Kit3.Cooldown")));
	            	p.sendMessage(Main.prefix + cooldown1);
					
					new BukkitRunnable() {
						
						@Override
						public void run() {
						
							if(frontBlock.getBlock().getType().equals(Material.SLIME_BLOCK))
							   frontBlock.getBlock().setType(Material.AIR);
							
							if(backBlock.getBlock().getType().equals(Material.SLIME_BLOCK))
							backBlock.getBlock().setType(Material.AIR);
							
							if(middleBlock.getBlock().getType().equals(Material.SLIME_BLOCK))
							middleBlock.getBlock().setType(Material.AIR);
							
							if(rightBlock.getBlock().getType().equals(Material.SLIME_BLOCK))
							rightBlock.getBlock().setType(Material.AIR);
							
							if(leftBlock.getBlock().getType().equals(Material.SLIME_BLOCK))
							leftBlock.getBlock().setType(Material.AIR);
							p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Rettungsplattform_FINISHED"));
						}
					}.runTaskLater(Main.getInstance(), 20*5);
					
	            	taskID = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	    				
	    				@Override
	    				public void run() {
	    					
	    					used.remove(p.getName());
	    					
	    				}
	    			}, 20*shop.ShopConfig.getInt("Shop.Kits.Kit3.Cooldown"));
				  	}
				}
				
			} catch (Exception exception) {}
		}
	}
	}
}

