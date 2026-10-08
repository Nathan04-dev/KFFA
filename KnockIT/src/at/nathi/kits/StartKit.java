package at.nathi.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import config.kit;


public class StartKit {
	
	public static void onRusherMethod(Player p) {
		

		ItemStack lederbrust = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack goldschwert = new ItemStack(Material.WOODEN_SWORD);
		ItemStack bogen = new ItemStack(Material.BOW);
		ItemStack blöcke = new ItemStack(Material.SANDSTONE);
		ItemStack web = new ItemStack(Material.COBWEB);
		ItemStack pfeil = new ItemStack(Material.ARROW);
		ItemStack stick = new ItemStack(Material.STICK);
		ItemStack enderperle = new ItemStack(Material.ENDER_PEARL);
		
		ItemMeta goldschwertmeta = goldschwert.getItemMeta();
		ItemMeta bogenmeta = bogen.getItemMeta();
		ItemMeta blöckemeta = blöcke.getItemMeta();
		ItemMeta webmeta = web.getItemMeta();
		ItemMeta lederbrustmeta = lederbrust.getItemMeta();
		ItemMeta arrowmeta = pfeil.getItemMeta();
		ItemMeta stickmeta = stick.getItemMeta();
		ItemMeta epmeta = enderperle.getItemMeta();
		bogenmeta.setUnbreakable(true);
		goldschwertmeta.setUnbreakable(true);
		lederbrustmeta.setUnbreakable(true);
		bogenmeta.setUnbreakable(true);
		
		goldschwertmeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
		lederbrustmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
		lederbrustmeta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, false);
		stickmeta.addEnchant(Enchantment.KNOCKBACK, 1, false);
		bogenmeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false);
		
		goldschwertmeta.setDisplayName(kit.KitConfig.getString("KIT.SWORD"));
		bogenmeta.setDisplayName(kit.KitConfig.getString("KIT.BOW"));
		webmeta.setDisplayName(kit.KitConfig.getString("KIT.COBWEB"));
		blöckemeta.setDisplayName(kit.KitConfig.getString("KIT.BLÖCKE"));
		lederbrustmeta.setDisplayName(kit.KitConfig.getString("KIT.CHESTPLATE"));
		arrowmeta.setDisplayName(kit.KitConfig.getString("KIT.ARROW"));
		epmeta.setDisplayName(kit.KitConfig.getString("KIT.ENDERPEARL"));
		stickmeta.setDisplayName(kit.KitConfig.getString("KIT.KNOCKSTICK"));
		lederbrust.setItemMeta(lederbrustmeta);
		goldschwert.setItemMeta(goldschwertmeta);
		bogen.setItemMeta(bogenmeta);
		blöcke.setItemMeta(blöckemeta);
		web.setItemMeta(webmeta);
		pfeil.setItemMeta(arrowmeta);
		enderperle.setItemMeta(epmeta);
		stick.setItemMeta(stickmeta);
		
		blöcke.setAmount(32);
		web.setAmount(2);
		pfeil.setAmount(1);
		enderperle.setAmount(1);
	
		p.setHealth(20);
		p.setFoodLevel(21); 
		p.getInventory().setChestplate(lederbrust);
		p.getInventory().setItem(0, stick);
		p.getInventory().setItem(1, goldschwert);
		p.getInventory().setItem(2, bogen);
		p.getInventory().setItem(3, blöcke);
		p.getInventory().setItem(8, web);
		p.getInventory().setItem(4, pfeil);
		p.getInventory().setItem(7, enderperle);
		
	
	}

}
