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


import at.nathi.mysql.SQLStats;
import at.nathi.mysql.SQLTop10;
import config.GUI;



public class StatsCommand implements CommandExecutor, Listener{
	

	
	@SuppressWarnings({ "deprecation", "unlikely-arg-type" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

			Player p = (Player) sender;

		if(args.length == 0) {

			int tode = SQLStats.getTode(p.getUniqueId().toString());
			int kills = SQLStats.getKills(p.getUniqueId().toString());
			int elo = SQLStats.getElo(p.getUniqueId().toString());
			double KD = ((double) kills) / ((double) tode);
			KD = Math.round(KD * 100) /100.00;
			if(KD > 1000000000) {
				KD = kills;
			}
			String kc = Double.valueOf(KD).toString();
			
			String StatsGUIName = GUI.GUIConfig.getString("StatsGUI.Name");
			StatsGUIName = StatsGUIName.replace("§6§l%player%'s §6§lStats", "§6§lStats");
			
		Inventory inv = Bukkit.createInventory(null, 9*3, StatsGUIName);
		ItemStack schwert = new ItemStack(Material.PLAYER_HEAD);
		ItemStack skeleton = new ItemStack(Material.PLAYER_HEAD);
		ItemStack kd = new ItemStack(Material.PLAYER_HEAD);
		ItemStack elokopf = new ItemStack(Material.PLAYER_HEAD);
		ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
		ItemStack EloRank = new ItemStack(Material.PLAYER_HEAD);
		
		SkullMeta schwertmeta = (SkullMeta) schwert.getItemMeta();
		SkullMeta skeletonMeta = (SkullMeta) skeleton.getItemMeta();
		SkullMeta kdmeta = (SkullMeta) kd.getItemMeta();
		SkullMeta elokopfmeta = (SkullMeta) elokopf.getItemMeta();
		SkullMeta EloRankMeta = (SkullMeta) EloRank.getItemMeta();
		
		ItemMeta nopmeta = nop.getItemMeta();
		
		EloRankMeta.setOwner(p.getName());
		schwertmeta.setOwner(p.getName());
		skeletonMeta.setOwner(p.getName());
		kdmeta.setOwner(p.getName());
		elokopfmeta.setOwner(p.getName());
		
		String StatsGUIkills = GUI.GUIConfig.getString("StatsGUI.Kills");
		String StatsGUITode = GUI.GUIConfig.getString("StatsGUI.Tode");
		String StatsGUIkdr = GUI.GUIConfig.getString("StatsGUI.Kdr");
		String StatsGUIElo = GUI.GUIConfig.getString("StatsGUI.Elo");
		String StatsGUIEloRank = GUI.GUIConfig.getString("StatsGUI.EloRank");
		StatsGUIkills = StatsGUIkills.replace("%knockffa_kills%", String.valueOf(kills));	
		StatsGUITode = StatsGUITode.replace("%knockffa_deaths%", String.valueOf(tode));
		StatsGUIkdr = StatsGUIkdr.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
		StatsGUIElo = StatsGUIElo.replace("%knockffa_elo%", String.valueOf(elo));
	

			 StatsGUIEloRank = StatsGUIEloRank.replace("%knockffa_elorank%", String.valueOf(SQLTop10.rang.containsKey(p.getUniqueId().toString())));
			 EloRankMeta.setDisplayName(StatsGUIEloRank);
			

			
		 	
		nopmeta.setDisplayName(" ");
		schwertmeta.setDisplayName(StatsGUIkills);
		kdmeta.setDisplayName(StatsGUIkdr);
		skeletonMeta.setDisplayName(StatsGUITode);
		elokopfmeta.setDisplayName(StatsGUIElo);
		
		schwert.setItemMeta(schwertmeta);
		skeleton.setItemMeta(skeletonMeta);
		kd.setItemMeta(kdmeta);
		nop.setItemMeta(nopmeta);
		elokopf.setItemMeta(elokopfmeta);
		EloRank.setItemMeta(EloRankMeta);
		
		
		p.openInventory(inv);
		inv.setItem(0, EloRank);
	
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
		inv.setItem(26, elokopf);
	

		 
	
		} else if(args.length == 1) {
			Player t = Bukkit.getPlayer(args[0]);
			int tode = SQLStats.getTode(t.getUniqueId().toString());
			int kills = SQLStats.getKills(t.getUniqueId().toString());
			int elo = SQLStats.getElo(t.getUniqueId().toString());
			double KD = ((double) kills) / ((double) tode);
			KD = Math.round(KD * 100) /100.00;
			if(KD > 1000000000) {
				KD = kills;
			}
			String kc = Double.valueOf(KD).toString();
			
			String StatsGUIName = GUI.GUIConfig.getString("StatsGUI.Name");
			StatsGUIName = StatsGUIName.replace("%player%", t.getName());
			
			Inventory inv = Bukkit.createInventory(null, 9*3, StatsGUIName);
			ItemStack schwert = new ItemStack(Material.PLAYER_HEAD);
			ItemStack skeleton = new ItemStack(Material.PLAYER_HEAD);
			ItemStack kd = new ItemStack(Material.PLAYER_HEAD);
			ItemStack elokopf = new ItemStack(Material.PLAYER_HEAD);
			ItemStack nop = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
			
			SkullMeta schwertmeta = (SkullMeta) schwert.getItemMeta();
			SkullMeta skeletonMeta = (SkullMeta) skeleton.getItemMeta();
			SkullMeta kdmeta = (SkullMeta) kd.getItemMeta();
			SkullMeta elokopfmeta = (SkullMeta) elokopf.getItemMeta();
			ItemMeta nopmeta = nop.getItemMeta();
			
			schwertmeta.setOwner(t.getName());
			skeletonMeta.setOwner(t.getName());
			kdmeta.setOwner(t.getName());
			elokopfmeta.setOwner(t.getName());
			String StatsGUIkills = GUI.GUIConfig.getString("StatsGUI.Kills");
			String StatsGUITode = GUI.GUIConfig.getString("StatsGUI.Tode");
			String StatsGUIkdr = GUI.GUIConfig.getString("StatsGUI.Kdr");
			String StatsGUIElo = GUI.GUIConfig.getString("StatsGUI.Elo");
			
			StatsGUIkills = StatsGUIkills.replace("%knockffa_kills%", String.valueOf(kills));	
			StatsGUITode = StatsGUITode.replace("%knockffa_deaths%", String.valueOf(tode));
			StatsGUIkdr = StatsGUIkdr.replace("%knockffa_kdr%", String.valueOf(kc.replace("Infinity", "0").replace("NaN", "0")));
			StatsGUIElo = StatsGUIElo.replace("%knockffa_elo%", String.valueOf(elo));
			
			nopmeta.setDisplayName(" ");
			schwertmeta.setDisplayName(StatsGUIkills);
			kdmeta.setDisplayName(StatsGUIkdr);
			skeletonMeta.setDisplayName(StatsGUITode);
			elokopfmeta.setDisplayName(StatsGUIElo);
			
			schwert.setItemMeta(schwertmeta);
			skeleton.setItemMeta(skeletonMeta);
			kd.setItemMeta(kdmeta);
			nop.setItemMeta(nopmeta);
			elokopf.setItemMeta(elokopfmeta);
			
			
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
			inv.setItem(26, elokopf);
		
		}

		
		return false;
}
		
	

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if(!(e.getWhoClicked() instanceof Player)) return;
		if(e.getInventory().contains(Material.WHITE_STAINED_GLASS_PANE)) {
			e.setCancelled(true);
		} 
	

	}
}
