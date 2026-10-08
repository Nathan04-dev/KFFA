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
import config.kit;
import config.locations;
import config.shop;

public class BlockPlaceListener implements Listener{
	public static int taskID;
	public static int taskID2;
	
	public BlockPlaceListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public static void onBlock(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		Block s = e.getBlock();
		

		if(p.getLocation().getBlockY() <= locations.LocationConfig.getInt("Spawnheight.Y")) {
		ItemStack sand = new ItemStack(Material.SANDSTONE);
		ItemStack blätter = new ItemStack(Material.BIRCH_LEAVES);
		ItemStack cobweb = new ItemStack(Material.COBWEB);
		ItemStack selbstmordkit = new ItemStack(Material.STONE_PRESSURE_PLATE);
		ItemStack blauesglas = new ItemStack(Material.BLUE_STAINED_GLASS);
		ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
		
		
		
		ItemMeta blauemeta = blauesglas.getItemMeta();
		ItemMeta sandmeta = sand.getItemMeta();
		ItemMeta webmeta = cobweb.getItemMeta();
		ItemMeta selbstmordmeta = selbstmordkit.getItemMeta();
		ItemMeta blättermeta = blätter.getItemMeta();
		ItemMeta goldblockmeta = goldblock.getItemMeta();
		

		blättermeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block1.Name"));
		blauemeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block2.Name"));
		goldblockmeta.setDisplayName( shop.ShopConfig.getString("Shop.Blöcke.Block3.Name"));
		
		sandmeta.setDisplayName(kit.KitConfig.getString("KIT.BLÖCKE"));
		webmeta.setDisplayName(kit.KitConfig.getString("KIT.COBWEB"));
		
		selbstmordmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit2.Name"));
		sand.setItemMeta(sandmeta);
		cobweb.setItemMeta(webmeta);
		selbstmordkit.setItemMeta(selbstmordmeta);
		blätter.setItemMeta(blättermeta);
		blauesglas.setItemMeta(blauemeta);
		goldblock.setItemMeta(goldblockmeta);
		
		if(e.getBlockPlaced().getType() == Material.SANDSTONE) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.SANDSTONE_AnimationSeconds");
			
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 9:
					
					p.getInventory().addItem(sand); 
				
		
					break;
				case 4:
							
							s.setType(Material.LEGACY_HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(sand);

					break;

					
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}
		
		if(e.getBlockPlaced().getType() == Material.BIRCH_LEAVES) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.Block1.AnimationSeconds");
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 9:
					
					p.getInventory().addItem(blätter); 
				
		
					break;
				case 4:
							s.setType(Material.LEGACY_HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(blätter);

					break;
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}
		if(e.getBlockPlaced().getType() == Material.BLUE_STAINED_GLASS) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.Block2.AnimationSeconds");
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 9:
					
					p.getInventory().addItem(blauesglas); 
				
		
					break;
				case 4:
							s.setType(Material.LEGACY_HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(blauesglas);

					break;
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}
		if(e.getBlockPlaced().getType() == Material.GOLD_BLOCK) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.Block3.AnimationSeconds");
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 9:
					
					p.getInventory().addItem(goldblock); 
				
		
					break;
				case 4:
							s.setType(Material.LEGACY_HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(goldblock);

					break;
				default:
					break;
				}
						
				
			}
		}, 0, 20);
		}
		if(e.getBlockPlaced().getType() == Material.COBWEB) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.COBWEB_AnimationSeconds");
			
			@Override
			public void run() {
				Player p = e.getPlayer();
				blockdestroy--;
				
				switch(blockdestroy) {
				case 4:
							s.setType(Material.LEGACY_HARD_CLAY);
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
		if(e.getBlockPlaced().getType() == Material.STONE_PRESSURE_PLATE) {
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
		public int blockdestroy = shop.ShopConfig.getInt("Shop.Blöcke.PRESSUREPLATE_AnimationSeconds");
			
			@Override
			public void run() {

				blockdestroy--;
				
				switch(blockdestroy) {
				case 4:
							s.setType(Material.LEGACY_HARD_CLAY);
				break;
				case 1:
					
					e.getBlockPlaced().breakNaturally(selbstmordkit);

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
