package at.nathi.kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class kits {
	
	
	public static void uhckit(Player p) {
		ItemStack DH = new ItemStack(Material.DIAMOND_HELMET);
		ItemStack DC = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemStack DL = new ItemStack(Material.DIAMOND_LEGGINGS);
		ItemStack DB = new ItemStack(Material.DIAMOND_BOOTS);
		ItemStack DS = new ItemStack(Material.DIAMOND_SWORD);
		ItemStack angel = new ItemStack(Material.FISHING_ROD);
		ItemStack wassereimer = new ItemStack(Material.WATER_BUCKET);
		ItemStack gap = new ItemStack(Material.GOLDEN_APPLE);
		ItemStack cobblestone = new ItemStack(Material.COBBLESTONE);
		ItemStack bogen = new ItemStack(Material.BOW);
		ItemStack pfeil = new ItemStack(Material.ARROW);
		ItemStack feuerzeug = new ItemStack(Material.FLINT_AND_STEEL);
		
		ItemMeta DHmeta = DH.getItemMeta();
		ItemMeta DCmeta = DC.getItemMeta();
		ItemMeta DLmeta = DL.getItemMeta();
		ItemMeta DBmeta = DB.getItemMeta();
		ItemMeta DSmeta = DS.getItemMeta();
		ItemMeta angelmeta = angel.getItemMeta();
		ItemMeta wassereimermeta = wassereimer.getItemMeta();
		ItemMeta gapmeta = gap.getItemMeta();
		ItemMeta cobblemeta = cobblestone.getItemMeta();
		ItemMeta bogenmeta = bogen.getItemMeta();
		ItemMeta pfeilmeta = pfeil.getItemMeta();
		ItemMeta feuerzeugmeta = feuerzeug.getItemMeta();
		
		angelmeta.spigot().setUnbreakable(true);
		DSmeta.spigot().setUnbreakable(true);
		
	
		DHmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
		DCmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
		DLmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
		DBmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false);
		DSmeta.addEnchant(Enchantment.DAMAGE_ALL, 3, false);
		bogenmeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, false);
		
		gap.setAmount(10);
		cobblestone.setAmount(64);
		pfeil.setAmount(10);
		feuerzeug.setDurability((short) 60);
		
		DHmeta.setDisplayName("§3§lDiamant Helm");
		DCmeta.setDisplayName("§3§lDiamant Brust");
		DLmeta.setDisplayName("§3§lDiamant Hose");
		DBmeta.setDisplayName("§3§lDiamant Schuhe");
		DSmeta.setDisplayName("§3§lDiamant Schwert");
		angelmeta.setDisplayName("§3§lAngel");
		wassereimermeta.setDisplayName("§3§lWassereimer");
		gapmeta.setDisplayName("§e§lGoldener Apfel");
		cobblemeta.setDisplayName("§7§lCobblestone");
		bogenmeta.setDisplayName("§3§lBogen");
		pfeilmeta.setDisplayName("§3§lPfeil");
		feuerzeugmeta.setDisplayName("§4§lFeuerzeug");
		
		

		DH.setItemMeta(DHmeta);
		DC.setItemMeta(DCmeta);
		DL.setItemMeta(DLmeta);
		DB.setItemMeta(DBmeta);
		DS.setItemMeta(DSmeta);
		angel.setItemMeta(angelmeta);
		wassereimer.setItemMeta(wassereimermeta);
		gap.setItemMeta(gapmeta);
		cobblestone.setItemMeta(cobblemeta);
		bogen.setItemMeta(bogenmeta);
		pfeil.setItemMeta(pfeilmeta);
		feuerzeug.setItemMeta(feuerzeugmeta);
		
		
		p.getInventory().setHelmet(DH);
		p.getInventory().setChestplate(DC);
		p.getInventory().setLeggings(DL);
		p.getInventory().setBoots(DB);
		p.getInventory().setItem(0, DS);
		p.getInventory().setItem(1, angel);
		p.getInventory().setItem(2, wassereimer);
		p.getInventory().setItem(3, cobblestone);
		p.getInventory().setItem(4, gap);
		p.getInventory().setItem(6, feuerzeug);
		p.getInventory().setItem(7, pfeil);
		p.getInventory().setItem(8, bogen);
	

		
	}

}
