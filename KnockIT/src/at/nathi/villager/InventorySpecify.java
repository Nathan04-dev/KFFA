package at.nathi.villager;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;



public class InventorySpecify {
		
		
		
		
		public InventorySpecify(Location loc, Player p) {
			Villager tank = (Villager) p.getWorld().spawn(p.getLocation(), Villager.class);
			tank.setCustomName(InventoryManager.InventarCustom);
			tank.setCustomNameVisible(false);
			tank.setInvulnerable(true);
			tank.setAI(false);
	
		}
		


}
