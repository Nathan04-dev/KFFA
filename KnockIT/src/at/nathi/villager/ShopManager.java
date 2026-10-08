 package at.nathi.villager;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import at.nathi.casevillager.Explosionbuy;
import at.nathi.casevillager.Rettungsplattformbuy;
import at.nathi.casevillager.Selbstmordbuy;
import at.nathi.main.Main;
import at.nathi.mysql.SQLStats;
import at.nathi.rüstungen.Blue;
import at.nathi.rüstungen.Pink;
import at.nathi.rüstungen.Red;
import at.nathi.rüstungen.White;
import config.messages;
import config.shop;



public class ShopManager implements Listener {

	public static String grünarmor = "§a§lGrüne Rüstung";
	public static String gelbarmor = "§e§lGelbe Rüstung";
	public static String aquaarmor = "§b§lAqua Rüstung";
	public static String rainbowarmor = "§a§lR§e§la§b§li§e§ln§a§lb§e§lo§b§lw §a§lR§e§lü§b§ls§e§lt§a§lu§e§ln§b§lg";
	public static String kitm = shop.ShopConfig.getString("Shop.VillagerName");
	public static int taskID;
	public static int seconds = 10;

	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {

		if(!(e.getRightClicked() instanceof Villager)) return;
		
		Villager shop1 = (Villager) e.getRightClicked();
		
			
		if(shop1.getCustomName().equalsIgnoreCase(kitm)) {
			e.setCancelled(true);
			Player p = e.getPlayer();
			ArrayList<String> kitslore = new ArrayList<>();
			ArrayList<String> itemshoplore = new ArrayList<>();
			Inventory inv = Bukkit.createInventory(null, 9*3, kitm);
			ItemStack rüstungen = new ItemStack(Material.DIAMOND_CHESTPLATE);
			ItemStack itemshop = new ItemStack(Material.POTION);
			ItemStack blöckeshop = new ItemStack(Material.REDSTONE_BLOCK);
			ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
			ItemStack invsort = new ItemStack( Material.CRIMSON_NYLIUM);
			ItemMeta iMeta = rüstungen.getItemMeta();
			ItemMeta iMeta2 = itemshop.getItemMeta();
			ItemMeta iMeta3 = blöckeshop.getItemMeta();
			ItemMeta nopmeta = nop.getItemMeta();
			ItemMeta invmeta = invsort.getItemMeta();
			
			nopmeta.setDisplayName(" ");
			kitslore.add("§7Hier findest du alle Rüstungen");
			itemshoplore.add("Hier findest du Special Items");
			iMeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Name"));
			iMeta2.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Name"));
			iMeta3.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Name"));
			invmeta.setDisplayName(messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix"));
			iMeta.setLore(kitslore);
			iMeta2.setLore(itemshoplore);
			rüstungen.setItemMeta(iMeta);
			itemshop.setItemMeta(iMeta2);
			blöckeshop.setItemMeta(iMeta3);
			nop.setItemMeta(nopmeta);
			invsort.setItemMeta(invmeta);
			inv.setItem(0, nop);
			inv.setItem(1, nop);
			inv.setItem(2, nop);
			inv.setItem(3, nop);
			inv.setItem(4, nop);
			inv.setItem(5, nop);
			inv.setItem(6, nop);
			inv.setItem(7, nop);
			inv.setItem(8, invsort);
			inv.setItem(9, nop);
			inv.setItem(10, nop);
			inv.setItem(11, rüstungen);
			inv.setItem(12, nop);
			inv.setItem(13, nop);
			inv.setItem(14, nop);
			inv.setItem(15, itemshop);
			inv.setItem(16, nop);
			inv.setItem(17, nop);
			inv.setItem(18, nop);
			inv.setItem(19, nop);
			inv.setItem(20, nop);
			inv.setItem(21, nop);
			inv.setItem(22, nop);
			inv.setItem(23, nop);
			inv.setItem(24, nop);
			inv.setItem(25, nop);
			inv.setItem(26, blöckeshop);
			p.openInventory(inv);
		}
		
	}

	@EventHandler
	public static void handleNavigatorGUIClick2(InventoryClickEvent e) {
	
		if(e.getCurrentItem() == null) {
			return ;
		}
		
		if(!(e.getWhoClicked() instanceof Player)) return;
	  
		Player p = (Player) e.getWhoClicked();
	
		if(e.getCurrentItem().getType() == Material.POTION) {
				e.setCancelled(true);
				Inventory inv = Bukkit.createInventory(null, 9*3, shop.ShopConfig.getString("Shop.Kits.Name"));
				
				p.openInventory(inv);
				ArrayList<String> explosionlore = new ArrayList<>();
				ArrayList<String> selbstmordlore = new ArrayList<>();
				ArrayList<String> rplore = new ArrayList<>();
				ItemStack Überraschungsei = new ItemStack(Material.ARROW);
				ItemStack selbstmord = new ItemStack(Material.STONE_PRESSURE_PLATE);
				ItemStack rettungsplattform = new ItemStack(Material.BLAZE_ROD);
				ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
				ItemMeta nopmeta = nop.getItemMeta();
				ItemMeta explosionmeta = Überraschungsei.getItemMeta();
				ItemMeta selbstmordmeta = selbstmord.getItemMeta();
				ItemMeta rpmeta = rettungsplattform.getItemMeta();
				
				nopmeta.setDisplayName(" ");
				nop.setItemMeta(nopmeta);
				explosionlore.add(shop.ShopConfig.getString("Shop.Kits.Kit1.Coins")); 
				selbstmordlore.add(shop.ShopConfig.getString("Shop.Kits.Kit2.Coins"));
				rplore.add(shop.ShopConfig.getString("Shop.Kits.Kit3.Coins")); 
				explosionmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit1.Name"));
				selbstmordmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit2.Name"));
				rpmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit3.Name"));
				
				explosionmeta.setLore(explosionlore);
				selbstmordmeta.setLore(selbstmordlore);
				rpmeta.setLore(rplore);
				
				Überraschungsei.setItemMeta(explosionmeta);
				rettungsplattform.setItemMeta(rpmeta);
				selbstmord.setItemMeta(selbstmordmeta);
				inv.setItem(0, nop);
				inv.setItem(1, nop);
				inv.setItem(2, nop);
				inv.setItem(3, nop);
				inv.setItem(4, nop);
				inv.setItem(5, nop);
				inv.setItem(6, nop);
				inv.setItem(7, nop);
				inv.setItem(8, nop);
				inv.setItem(9, nop);
				inv.setItem(10, Überraschungsei);
				inv.setItem(11, nop);
				inv.setItem(12, nop);
				inv.setItem(13, selbstmord);
				inv.setItem(14, nop);
				inv.setItem(15, nop);
				inv.setItem(16, rettungsplattform);
				inv.setItem(17, nop);
				inv.setItem(18, nop);
				inv.setItem(19, nop);
				inv.setItem(20, nop);
				inv.setItem(21, nop);
				inv.setItem(22, nop);
				inv.setItem(23, nop);
				inv.setItem(24, nop);
				inv.setItem(25, nop);
				inv.setItem(26, nop);
		}
		if(e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
			e.setCancelled(true);
			Inventory inv = Bukkit.createInventory(null, 9*3, shop.ShopConfig.getString("Shop.Blöcke.Name"));
			p.openInventory(inv);
			ArrayList<String> blätterlore = new ArrayList<>();
			ArrayList<String> blaueglaslore = new ArrayList<>();
			ArrayList<String> goldblocklore = new ArrayList<>();
			
			ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
			ItemStack blätter = new ItemStack(Material.BIRCH_LEAVES);
			ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
			ItemStack blauesglas = new ItemStack(Material.BLUE_STAINED_GLASS);
		
			ItemMeta blättermeta = blätter.getItemMeta();
			ItemMeta nopmeta = nop.getItemMeta();
			ItemMeta goldblockmeta = goldblock.getItemMeta();
			ItemMeta blauemeta = blauesglas.getItemMeta();

			blättermeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block1.Name")); 
			blauemeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block2.Name"));
			goldblockmeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block3.Name"));
			
			blätterlore.add(shop.ShopConfig.getString("Shop.Blöcke.Block1.Coins"));
			blaueglaslore.add(shop.ShopConfig.getString("Shop.Blöcke.Block2.Coins"));
			goldblocklore.add(shop.ShopConfig.getString("Shop.Blöcke.Block3.Coins"));
			
			blättermeta.setLore(blätterlore);
			blauemeta.setLore(blaueglaslore);
			goldblockmeta.setLore(goldblocklore);
			
			blätter.setItemMeta(blättermeta);
			goldblock.setItemMeta(goldblockmeta);
			blauesglas.setItemMeta(blauemeta);
			
			nopmeta.setDisplayName(" ");
			nop.setItemMeta(nopmeta);
			inv.setItem(0, nop);
			inv.setItem(1, nop);
			inv.setItem(2, nop);
			inv.setItem(3, nop);
			inv.setItem(4, nop);
			inv.setItem(5, nop);
			inv.setItem(6, nop);
			inv.setItem(7, nop);
			inv.setItem(8, nop);
			inv.setItem(9, nop);
			inv.setItem(10, blätter);
			inv.setItem(11, nop);
			inv.setItem(12, nop);
			inv.setItem(13, blauesglas);
			inv.setItem(14, nop);
			inv.setItem(15, nop);
			inv.setItem(16, goldblock);
			inv.setItem(17, nop);
			inv.setItem(18, nop);
			inv.setItem(19, nop);
			inv.setItem(20, nop);
			inv.setItem(21, nop);
			inv.setItem(22, nop);
			inv.setItem(23, nop);
			inv.setItem(24, nop);
			inv.setItem(25, nop);
			inv.setItem(26, nop);
	}
		if(e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
			e.setCancelled(true);
			Inventory inv = Bukkit.createInventory(null, 9*3, shop.ShopConfig.getString("Shop.Rüstungen.Name"));
			p.openInventory(inv);
			ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
			ItemMeta nopmeta = nop.getItemMeta();
			nopmeta.setDisplayName(" ");
			nop.setItemMeta(nopmeta);
			//LILA
			ItemStack plederchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta plederarmormeta = (LeatherArmorMeta) plederchest.getItemMeta();
			ArrayList<String> plc = new ArrayList<>();
			Color pc = Color.fromRGB(198, 79, 189);
			plc.add("§a  ");
			plederarmormeta.setColor(pc);
			plederarmormeta.setLore(plc);
			plederarmormeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Lila.Name"));
			plederchest.setItemMeta(plederarmormeta);
			//WEIß
			ItemStack wlederchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta wlederarmormeta = (LeatherArmorMeta) wlederchest.getItemMeta();
			ArrayList<String> wlc = new ArrayList<>();
			Color w = Color.fromRGB(255, 255, 255);
			wlc.add("§b  ");
			wlederarmormeta.setColor(w);
			wlederarmormeta.setLore(wlc);
			wlederarmormeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Weiß.Name"));
			wlederchest.setItemMeta(wlederarmormeta);
			//BLAU
			ItemStack blederchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta blederarmormeta = (LeatherArmorMeta) blederchest.getItemMeta();
			ArrayList<String> blc = new ArrayList<>();
			Color b = Color.fromRGB(102, 178, 255);
			blc.add("§c  ");
			blederarmormeta.setColor(b);
			blederarmormeta.setLore(blc);
			blederarmormeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Blau.Name"));
			blederchest.setItemMeta(blederarmormeta);
			//ROT
			ItemStack rlederchest = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta rlederarmormeta = (LeatherArmorMeta) rlederchest.getItemMeta();
			ArrayList<String> rlc = new ArrayList<>();
			Color r = Color.fromRGB(255, 0, 0);
			rlc.add("§e  ");
			rlederarmormeta.setColor(r);
			rlederarmormeta.setLore(rlc);
			rlederarmormeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Rot.Name"));
			rlederchest.setItemMeta(rlederarmormeta);
			
			p.openInventory(inv);
			inv.setItem(0, nop);
			inv.setItem(1, nop);
			inv.setItem(2, nop);
			inv.setItem(3, nop);
			inv.setItem(4, nop);
			inv.setItem(5, nop);
			inv.setItem(6, nop);
			inv.setItem(7, nop);
			inv.setItem(8, nop);
			inv.setItem(9, nop);
			inv.setItem(10, plederchest);
			inv.setItem(11, nop);
			inv.setItem(12, wlederchest);
			inv.setItem(13, nop);
			inv.setItem(14, blederchest);
			inv.setItem(15, nop);
			inv.setItem(16, rlederchest);
			inv.setItem(17, nop);
			inv.setItem(18, nop);
			inv.setItem(19, nop);
			inv.setItem(20, nop);
			inv.setItem(21, nop);
			inv.setItem(22, nop);
			inv.setItem(23, nop);
			inv.setItem(24, nop);
			inv.setItem(25, nop);
			inv.setItem(26, nop);
		}
	
 	}


	
	@EventHandler
	public void kitArrow(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		Player p = (Player) e.getWhoClicked();
		if(e.getCurrentItem() == null) {
			return;
		}
		
		if(e.getView().getTitle() == shop.ShopConfig.getString("Shop.Kits.Name")) {
			
//EXPLOSIONARROW KIT1
			
				ItemStack pfeil = new ItemStack(Material.ARROW);
				ItemMeta pfeilmeta = pfeil.getItemMeta();
				pfeilmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit1.Name"));
				pfeil.setItemMeta(pfeilmeta);
				if(e.getSlot() == 10 && p.getInventory().contains(pfeil)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Kits.ALREADY_TAKEN"));

				} else if(e.getSlot() == 10 && !p.getInventory().contains(pfeil)) {
						Explosionbuy.ExplosionMethode(p);
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
			}
//MINEN KIT2
				ItemStack mine = new ItemStack(Material.STONE_PRESSURE_PLATE);
				ItemMeta minenmeta = mine.getItemMeta();
				minenmeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit2.Name"));
				mine.setItemMeta(minenmeta);
			if(e.getSlot() == 13 && p.getInventory().contains(mine)) {
				p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Kits.ALREADY_TAKEN"));
					
			} else if(e.getSlot() == 13 && !p.getInventory().contains(mine)) {
				Selbstmordbuy.SelbstmordMethode(p);
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
			}
		
//Rettungsplattform KIT3
				ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
				ItemMeta blazemeta = blaze.getItemMeta();
				blazemeta.setDisplayName(shop.ShopConfig.getString("Shop.Kits.Kit3.Name"));
				blaze.setItemMeta(blazemeta);
				if(e.getSlot() == 16 && p.getInventory().contains(blaze)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Kits.ALREADY_TAKEN"));
						
				} else if(e.getSlot() == 16 && !p.getInventory().contains(blaze)) {
					Rettungsplattformbuy.RettungsplattformMethode(p);
	
				}
					
			}
		if(e.getView().getTitle() == shop.ShopConfig.getString("Shop.Blöcke.Name")) {
			ItemStack blätter = new ItemStack(Material.BIRCH_LEAVES);
			ItemMeta blättermeta = blätter.getItemMeta();
			blätter.setAmount(32);
			blättermeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block1.Name"));
			blätter.setItemMeta(blättermeta);
		
			ItemStack blauesglas = new ItemStack(Material.BLUE_STAINED_GLASS);
			ItemMeta blauemeta = blauesglas.getItemMeta();
			blauesglas.setAmount(32);
			blauemeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block2.Name"));
			blauesglas.setItemMeta(blauemeta);
			
			ItemStack goldblock = new ItemStack(Material.GOLD_BLOCK);
			ItemMeta goldblockmeta = goldblock.getItemMeta();
			goldblock.setAmount(32);
			goldblockmeta.setDisplayName(shop.ShopConfig.getString("Shop.Blöcke.Block3.Name"));
			goldblock.setItemMeta(goldblockmeta);

				if(e.getSlot() == 10 && p.getInventory().contains(blätter)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Blöcke.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
					
				}  else if(e.getSlot() == 10 &&!p.getInventory().contains(blätter)) {
					int pcoins = SQLStats.getCoins(p.getUniqueId().toString());
					int kcoins = shop.ShopConfig.getInt("Shop.Blöcke.Block1.Coins");
					int coinrest = pcoins - kcoins;
					if(SQLStats.getCoins(p.getUniqueId().toString()) >= shop.ShopConfig.getInt("Shop.Blöcke.Block1.Coins")) {
					SQLStats.removeCoins(p.getUniqueId().toString(), kcoins);
					String fertigkauf = shop.ShopConfig.getString("Shop.Money_Status");
					fertigkauf = fertigkauf.replace("%coins%", String.valueOf(coinrest));
					p.sendMessage(Main.prefix + fertigkauf);
					p.getInventory().remove(Material.SANDSTONE);
					p.getInventory().remove(Material.BLUE_STAINED_GLASS);
					p.getInventory().remove(Material.GOLD_BLOCK);
					p.getInventory().addItem(blätter);
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				} else {
					String abbruchkauf = shop.ShopConfig.getString("Shop.NotEnough_Money");
					abbruchkauf = abbruchkauf.replace("%coins%", String.valueOf(SQLStats.getCoins(p.getUniqueId().toString())));
					p.sendMessage(Main.prefix + abbruchkauf);
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				}
				}
				
				if(e.getSlot() == 13 && p.getInventory().contains(blauesglas)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Blöcke.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
					
				}  else if(e.getSlot() == 13 &&!p.getInventory().contains(blauesglas)) {
					int pcoins = SQLStats.getCoins(p.getUniqueId().toString());
					int kcoins = shop.ShopConfig.getInt("Shop.Blöcke.Block2.Coins");
					int coinrest = pcoins - kcoins;
					if(SQLStats.getCoins(p.getUniqueId().toString()) >= shop.ShopConfig.getInt("Shop.Blöcke.Block2.Coins")) {
					SQLStats.removeCoins(p.getUniqueId().toString(), kcoins);
					String fertigkauf = shop.ShopConfig.getString("Shop.Money_Status");
					fertigkauf = fertigkauf.replace("%coins%", String.valueOf(coinrest));
					p.sendMessage(Main.prefix + fertigkauf);
					p.getInventory().remove(Material.SANDSTONE);
					p.getInventory().remove(Material.BIRCH_LEAVES);
					p.getInventory().remove(Material.GOLD_BLOCK);
					p.getInventory().addItem(blauesglas);
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				} else {
					String abbruchkauf = shop.ShopConfig.getString("Shop.NotEnough_Money");
					abbruchkauf = abbruchkauf.replace("%coins%", String.valueOf(SQLStats.getCoins(p.getUniqueId().toString())));
					p.sendMessage(Main.prefix + abbruchkauf);
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				}
				}
				
				if(e.getSlot() == 16 && p.getInventory().contains(goldblock)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Blöcke.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
					
				}  else if(e.getSlot() == 16 &&!p.getInventory().contains(goldblock)) {
					int pcoins = SQLStats.getCoins(p.getUniqueId().toString());
					int kcoins = shop.ShopConfig.getInt("Shop.Blöcke.Block3.Coins");
					int coinrest = pcoins - kcoins;
					if(SQLStats.getCoins(p.getUniqueId().toString()) >= shop.ShopConfig.getInt("Shop.Blöcke.Block3.Coins")) {
					SQLStats.removeCoins(p.getUniqueId().toString(), kcoins);
					String fertigkauf = shop.ShopConfig.getString("Shop.Money_Status");
					fertigkauf = fertigkauf.replace("%coins%", String.valueOf(coinrest));
					p.sendMessage(Main.prefix + fertigkauf);
					p.getInventory().remove(Material.SANDSTONE);
					p.getInventory().remove(Material.BLUE_STAINED_GLASS);
					p.getInventory().remove(Material.BIRCH_LEAVES);
					p.getInventory().addItem(goldblock);
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				} else {
					String abbruchkauf = shop.ShopConfig.getString("Shop.NotEnough_Money");
					abbruchkauf = abbruchkauf.replace("%coins%", String.valueOf(SQLStats.getCoins(p.getUniqueId().toString())));
					p.sendMessage(Main.prefix + abbruchkauf);;
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				}
				}
			
		}
	}

		@EventHandler
		public void InventoryClick(InventoryClickEvent e) {
			


			if(!(e.getWhoClicked() instanceof Player)) return;
			Player p = (Player) e.getWhoClicked();
			if(e.getCurrentItem() == null) {
				return;
			}

			if(e.getView().getTitle() == shop.ShopConfig.getString("Shop.Rüstungen.Name")) {
				
//PINK
				ArrayList<String> lha = new ArrayList<>();
				ItemStack pinklederhelm = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta lhmeta = (LeatherArmorMeta) pinklederhelm.getItemMeta();
				lhmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				lha.add("§c  ");
				Color c = Color.fromRGB(198, 79, 189);
				lhmeta.setColor(c);
				lhmeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Lila.Name"));
				lhmeta.setUnbreakable(true);
				pinklederhelm.setItemMeta(lhmeta);
//WEIß
				ArrayList<String> wlha = new ArrayList<>();
				ItemStack weißlederhelm = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta wlhmeta = (LeatherArmorMeta) weißlederhelm.getItemMeta();
				wlhmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				wlha.add("§c  ");
				Color w = Color.fromRGB(255, 255, 255);
				wlhmeta.setColor(w);
				wlhmeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Weiß.Name"));
				wlhmeta.setUnbreakable(true);
				weißlederhelm.setItemMeta(wlhmeta);
//BLAU
				
				ItemStack blaulederhelm = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta blhmeta = (LeatherArmorMeta) blaulederhelm.getItemMeta();
				blhmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				Color b = Color.fromRGB(102, 178, 255);
				blhmeta.setColor(b);
				blhmeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Blau.Name"));
				blhmeta.setUnbreakable(true);
				blaulederhelm.setItemMeta(blhmeta);
//ROT
				ArrayList<String> rlha = new ArrayList<>();
				ItemStack rlaulederhelm = new ItemStack(Material.LEATHER_CHESTPLATE);
				LeatherArmorMeta rlhmeta = (LeatherArmorMeta) rlaulederhelm.getItemMeta();
				rlhmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
				rlha.add("§c  ");
				Color r = Color.fromRGB(255, 0, 0);
				rlhmeta.setColor(r);
				rlhmeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Rot.Name"));
				rlhmeta.setUnbreakable(true);
				rlaulederhelm.setItemMeta(rlhmeta);				
//PINKE RÜSTUNG	
		
				if(e.getSlot() == 10 && p.getInventory().getChestplate().isSimilar(pinklederhelm)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				} else if(e.getSlot() == 10 &&!p.getInventory().getChestplate().isSimilar(pinklederhelm)) {
					Pink.onPink(p);
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Lila.TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				} 
			
//WEIßE RÜSTUNG				
				if(e.getSlot() == 12 && p.getInventory().getChestplate().isSimilar(weißlederhelm)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				} else if(e.getSlot() == 12 &&!p.getInventory().getChestplate().isSimilar(weißlederhelm)) {
					White.onWhite(p);
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Weiß.TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				}
//BLAUE RÜSTUNG				
				if(e.getSlot() == 14 && p.getInventory().getChestplate().isSimilar(blaulederhelm)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				} else if(e.getSlot() == 14 &&!p.getInventory().getChestplate().isSimilar(blaulederhelm)) {
					Blue.onBlue(p);
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Blau.TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				}
//Rote RÜSTUNG				
				if(e.getSlot() == 16 && p.getInventory().getChestplate().isSimilar(rlaulederhelm)) {
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.ALREADY_TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 100);
				} else if(e.getSlot() == 16 &&!p.getInventory().getChestplate().isSimilar(rlaulederhelm)) {
					Red.onRed(p);
					p.sendMessage(Main.prefix + shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Rot.TAKEN"));
					p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, 15, 15);
					p.closeInventory();
				}
			}
		}
		
		
		
		
	@SuppressWarnings("deprecation")
	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Villager)) return;

		Villager shop = (Villager) e.getEntity();
		if(!shop.getCustomName().equalsIgnoreCase(kitm)) return;


			e.setCancelled(true);
			if(!(e.getDamager() instanceof Player))	return;
			Player p = (Player) e.getDamager();
			if(p.isOp()) {
				if(p.getItemInHand().getType() == Material.LAVA_BUCKET) {
					shop.setHealth(0);
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.SHOP_DELETE"));
				
				
			
			}
		}
		
	}

	}


