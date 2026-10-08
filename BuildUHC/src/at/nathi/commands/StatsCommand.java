package at.nathi.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import at.nathi.main.Main;



public class StatsCommand implements CommandExecutor, Listener{
	

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(args.length == 0) {
		int kills = Main.getInstance().getConfig().getInt(p.getName() +".Kills");
		double deaths = Main.getInstance().getConfig().getInt(p.getName() +".Deaths");
		double kda = (kills/deaths);
		kda = Math.round(kda * 100) /100.00;
		if(kda > 1000000000) {
			kda = kills;
		}
		Inventory inv = Bukkit.createInventory(null, 9*3, "§6§lStats");
		ItemStack schwert = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemStack skeleton = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemStack kd = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		ItemStack nop = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);


        
		SkullMeta schwertmeta = (SkullMeta) schwert.getItemMeta();
		SkullMeta skeletonMeta = (SkullMeta) skeleton.getItemMeta();
		SkullMeta kdmeta = (SkullMeta) kd.getItemMeta();
		schwertmeta.setOwner(p.getName());
		skeletonMeta.setOwner(p.getName());
		kdmeta.setOwner(p.getName());
		schwertmeta.setDisplayName("§6§lKills: §7" + kills);
		kdmeta.setDisplayName("§6§lKD: §7" + kda);
		skeletonMeta.setDisplayName("§6§lTode: §7" + Main.getInstance().getConfig().getInt(p.getName() + ".Deaths"));
		schwert.setItemMeta(schwertmeta);
		skeleton.setItemMeta(skeletonMeta);
		kd.setItemMeta(kdmeta);
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
		inv.setItem(10, schwert);
		inv.setItem(11, nop);
		inv.setItem(12, nop);
		inv.setItem(13, skeleton);
		inv.setItem(14, nop);
		inv.setItem(15, nop);
		inv.setItem(16, kd);
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
		

		
		} else if(args.length == 1) {
			Player t = Bukkit.getPlayer(args[0]);
			int kills = Main.getInstance().getConfig().getInt(t.getName() +".Kills");
			double deaths = Main.getInstance().getConfig().getInt(t.getName() +".Deaths");
			double kda = (kills/deaths);
			kda = Math.round(kda * 100) /100.00;
			if(kda > 1000000000) {
				kda = kills;
			}
			Inventory inv = Bukkit.createInventory(null, 9*3, "§6§l" + t.getName() + "'s" + " §6§lStats");
			ItemStack schwert = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemStack skeleton = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);;
			ItemStack kd = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
			ItemStack nop = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 0);
			SkullMeta schwertmeta = (SkullMeta) schwert.getItemMeta();
			SkullMeta skeletonMeta = (SkullMeta) skeleton.getItemMeta();
			SkullMeta kdmeta = (SkullMeta) kd.getItemMeta();
			ItemMeta nopmeta = nop.getItemMeta();
			schwertmeta.setOwner(t.getName());
			skeletonMeta.setOwner(t.getName());
			kdmeta.setOwner(t.getName());
			
			
			schwertmeta.setDisplayName("§6§lKills: §7" + kills);
			schwertmeta.setOwner(p.getName());
			kdmeta.setDisplayName("§6§lKD: §7" + kda);
			skeletonMeta.setDisplayName("§6§lTode: §7" + Main.getInstance().getConfig().getInt(t.getName() + ".Deaths"));
			nopmeta.setDisplayName("");
			schwert.setItemMeta(schwertmeta);
			skeleton.setItemMeta(skeletonMeta);
			nop.setItemMeta(nopmeta);
			kd.setItemMeta(kdmeta);
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
			inv.setItem(10, schwert);
			inv.setItem(11, nop);
			inv.setItem(12, nop);
			inv.setItem(13, skeleton);
			inv.setItem(14, nop);
			inv.setItem(15, nop);
			inv.setItem(16, kd);
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
		
		return false;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(e.getInventory().getName() == "§6§lStats") {
			e.setCancelled(true);
		}
		


}
}
