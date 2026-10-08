package at.nathi.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitTask;

import at.nathi.main.Main;
import config.locations;
import config.messages;
import config.shop;

public class ExplosionListener implements Listener {
	
	public static List<BlockState> states = new ArrayList<BlockState>();
	public static ArrayList<String> used = new ArrayList<String>();
	public static BukkitTask timer = null;
	public static int taskID;
	public static int taskID2;
	
	public ExplosionListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	
	


	@SuppressWarnings("deprecation")
	@EventHandler 
	public static void onPlayerInteract2(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if(p.getLocation().getBlockY() <= locations.LocationConfig.getInt("Spawnheight.Y")) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			ItemStack pfeil = new ItemStack(Material.ARROW);
			ItemMeta pfeilmeta = pfeil.getItemMeta();
			pfeilmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit1.Name"));
			pfeil.setItemMeta(pfeilmeta);
            if(p.getItemInHand().isSimilar(pfeil)) {
            	if(!used.contains(p.getName())) {
            	p.launchProjectile(WitherSkull.class);
            	used.add(p.getName());
			  	String cooldown = messages.messageConfig.getString("MSGConfig.Arrow_COOLDOWN");
			  	cooldown = cooldown.replace("%cooldown%", String.valueOf(shop.ShopConfig.getInt("Shop.Kits.Kit1.Cooldown")));
            	p.sendMessage(Main.prefix + cooldown);
            	taskID2 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
				
				@Override
				public void run() {
					
					used.remove(p.getName());
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Arrow_FINISHED"));
				}
			}, 20*shop.ShopConfig.getInt("Shop.Kits.Kit1.Cooldown"));

            }
           
        } else {
        	return;
        }
       
            
		}
		}
	}
	
	@EventHandler
	public void onBlockExplode(EntityExplodeEvent e) {
		states.clear();
		for (Block b : e.blockList()) {
			states.add(b.getState());
			b.getState().update(true);
			
		}
		e.setYield(0);
		Random rnd = new Random();
		
		timer = Bukkit.getServer().getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				if (states.isEmpty()) 
				Bukkit.getServer().getScheduler().cancelTask(timer.getTaskId());
				else {
					BlockState pick = states.get(rnd.nextInt(states.size()));
				
					pick.update(true);
					pick.getWorld().playSound(pick.getLocation(), Sound.BLOCK_LADDER_STEP, 15, 15);
					
					states.remove(pick);
					
				}
			}
		}, 0, 0);
	}
	@EventHandler()
	public void onRun(PlayerMoveEvent e) {
		Player p = (Player) e.getPlayer();

			Block b = (Block) p.getLocation().subtract(0, 0, 0).getBlock();
				if(b.getType() == Material.STONE_PRESSURE_PLATE) {
					Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
						
						@Override
						public void run() {
						
							b.getWorld().createExplosion(b.getLocation().getX(), b.getLocation().getY(), b.getLocation().getZ(), 3, false, false);
						}
						
					}, 4);
					
				}
			
			
		
	}
	
	


}
