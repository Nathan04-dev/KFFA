package at.nathi.rüstungen;



import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import config.shop;

public class Pink {
	
	public static void onPink(Player p) {
		ItemStack lederhelm = new ItemStack(Material.LEATHER_CHESTPLATE);

		LeatherArmorMeta lhmeta = (LeatherArmorMeta) lederhelm.getItemMeta();

		
		lhmeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false);
		lhmeta.setUnbreakable(true);
		Color c = Color.fromRGB(198, 79, 189);

		lhmeta.setDisplayName(shop.ShopConfig.getString("Shop.Rüstungen.Farbe.Lila.Name"));
		lhmeta.setColor(c);
		lederhelm.setItemMeta(lhmeta);

		
		p.getInventory().remove(Material.LEATHER_CHESTPLATE);

		
		p.getInventory().setChestplate(lederhelm);


	}
	


}
