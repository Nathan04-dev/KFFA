package at.nathi.listeners;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import at.nathi.main.Main;

public class BlockPlaceListener implements Listener{
	public static int taskID;
	public static int taskID2;
	
	public BlockPlaceListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}

	
	@EventHandler
	public static void onBlock(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block s = e.getBlock();

		if(p.getLocation().getBlockY() <= Main.getInstance().getConfig().getDouble("builduhc.spawns.spawnheight.Y")) {
		ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
		ItemStack cobweb = new ItemStack(Material.WEB);
		ItemMeta cobblestonemeta = cobblestone.getItemMeta();
		ItemMeta webmeta = cobweb.getItemMeta();
		cobblestonemeta.setDisplayName("§7§lCobblestone");
		webmeta.setDisplayName("§6§lSpinnennetz");
		cobblestone.setItemMeta(cobblestonemeta);
		cobweb.setItemMeta(webmeta);

		if(e.getBlockPlaced().getType() == Material.COBBLESTONE) {
	
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = 10;
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 9:
					
					p.getInventory().addItem(cobblestone); 
				
		
					break;
				case 4:
							s.setType(Material.HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(cobblestone);

					break;

					
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}

		if(e.getBlockPlaced().getType() == Material.WEB) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = 10;
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 4:
							s.setType(Material.HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(cobweb);
					p.getInventory().addItem(cobweb); 
					break;

					
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}


		}
		
	}
}
