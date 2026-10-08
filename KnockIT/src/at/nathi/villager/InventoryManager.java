package at.nathi.villager;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
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

import at.nathi.main.Main;
import config.messages;

public class InventoryManager implements Listener {
	
	public static String InventarCustom = messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix");
	public static HashMap<String, ItemStack[]> inventory = new HashMap<>();
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {

		if(!(e.getRightClicked() instanceof Villager)) return;
		
		Villager shop = (Villager) e.getRightClicked();
		
			
		
		if(shop.getCustomName().equalsIgnoreCase(InventarCustom)) {
			e.setCancelled(true);
			Player p = e.getPlayer();
			ArrayList<String> kitslore = new ArrayList<>();
			Inventory inv = Bukkit.createInventory(null, 9*3, InventarCustom);
			ItemStack rüstungen = new ItemStack( Material.CRIMSON_NYLIUM);
			ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
			ItemMeta iMeta = rüstungen.getItemMeta();
			ItemMeta nopmeta = nop.getItemMeta();
			nopmeta.setDisplayName(" ");
			kitslore.add("§7Klicke für die Inventarsortierung");
			iMeta.setDisplayName( messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix"));
			iMeta.setLore(kitslore);
			rüstungen.setItemMeta(iMeta);
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
			inv.setItem(10, nop);
			inv.setItem(11, nop);
			inv.setItem(12, nop);
			inv.setItem(13, rüstungen);
			inv.setItem(14, nop);
			inv.setItem(15, nop);
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
			inv.setItem(26, nop);
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
		
		if(e.getView().getTitle() ==  messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix")) {
			e.setCancelled(true);
			Inventory inv = Bukkit.createInventory(null, 9*1,  messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix"));
			ItemStack speichern = new ItemStack( Material.GREEN_WOOL);
			ItemStack abbrechen = new ItemStack( Material.RED_WOOL);
			ItemMeta iMeta = speichern.getItemMeta();
			ItemMeta iMeta2 = abbrechen.getItemMeta();
			iMeta.setDisplayName("§a§lSpeichern");
			iMeta2.setDisplayName("§c§lAbbrechen");
			speichern.setItemMeta(iMeta);
			abbrechen.setItemMeta(iMeta2);
	
			
			inv.setItem(0, abbrechen);
			inv.setItem(8, speichern);
		if(e.getSlot() == 13) {
			p.openInventory(inv);

		}
		}
		if(e.getView().getTitle() == messages.messageConfig.getString("MSGConfig.InventarSoriteurng_Prefix") )
			if(e.getCurrentItem().getType() == Material.RED_WOOL) {
				p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 3, 1);
				p.closeInventory();
			} 
			if(e.getCurrentItem().getType() == Material.GREEN_WOOL) {
				inventory.put(p.getName(), p.getInventory().getContents());
				p.closeInventory();
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 1);
				p.setLevel(2021);
				p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.INVENTAR_SAVE"));
			}

		
	
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Villager)) return;
	
		Villager inventar = (Villager) e.getEntity();
		if(!inventar.getCustomName().equalsIgnoreCase(InventarCustom)) return;


			e.setCancelled(true);
			if(!(e.getDamager() instanceof Player))	return;
			Player p = (Player) e.getDamager();
			if(p.isOp()) {

				if(p.getItemInHand().getType() == Material.LAVA_BUCKET) {
					inventar.setHealth(0);
					p.sendMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.INVENTAR_DELETE"));
				
				
			
			}
		}
		
	}
	
	

	

}
