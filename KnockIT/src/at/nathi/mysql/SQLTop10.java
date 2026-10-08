package at.nathi.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import org.bukkit.entity.Player;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;


import at.nathi.main.Main;





public class SQLTop10 {
	
	public static HashMap<Integer, String> rang = new HashMap<Integer, String>();
	 public static List<Location> LOC = new ArrayList<Location>();
	
 public static void set(Player p) {
	 ResultSet rs = MySQL.getResult("SELECT UUID FROM Stats ORDER BY KILLS DESC LIMIT 100");
	 
	 int in = 0;

	 try {
		 while(rs.next()) {
			 in++;
			 rang.put(in, rs.getString("UUID"));
		 }
	 } catch(SQLException e) {
		 e.printStackTrace();
	 }
	 int a = 100;
	 for(int i = 0; i < a; i++) {
		 int id = i+1;
		  
		 
		 String name = Bukkit.getOfflinePlayer(UUID.fromString(rang.get(id))).getName();
		 if(id < 1) {
			 return;
		 }
			 if(id == 1) {
			 String text = "§e§l#" + id + " §7" + name;

				double x = p.getLocation().getX();
				double y = p.getLocation().getY();
				double z = p.getLocation().getZ();
				World w = p.getLocation().getWorld();
				Location loc8 = new Location(w, x, y + 2, z);
				Hologram hologram = HologramsAPI.createHologram(Main.getInstance(), loc8);
			    hologram.appendTextLine(text);
				hologram.setAllowPlaceholders(true);
				 
		 } 
			 if(id == 2) {
				 String text = "§e§l#" + id + " §7" + name;
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					World w = p.getLocation().getWorld();
					Location loc9 = new Location(w, x, y + 1.8, z);
					Hologram hologram = HologramsAPI.createHologram(Main.getInstance(), loc9);
					hologram.appendTextLine(text);
					hologram.setAllowPlaceholders(true);

			 } 
			 if(id == 3) {
				 String text = "§e§l#" + id + " §7" + name;
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					World w = p.getLocation().getWorld();
					Location loc10 = new Location(w, x, y + 1.6, z);
					Hologram hologram = HologramsAPI.createHologram(Main.getInstance(), loc10);
					hologram.appendTextLine(text);
					hologram.setAllowPlaceholders(true);

			 }
			 if(id == 4) {
				 String text = "§e§l#" + id + " §7" + name ;
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					World w = p.getLocation().getWorld();
					Location loc11 = new Location(w, x, y + 1.4, z);
					Hologram hologram = HologramsAPI.createHologram(Main.getInstance(), loc11);
					hologram.appendTextLine(text);
					hologram.setAllowPlaceholders(true);

			 }
			 if(id == 5) {
				 String text = "§e§l#" + id + " §7" + name ;
					double x = p.getLocation().getX();
					double y = p.getLocation().getY();
					double z = p.getLocation().getZ();
					World w = p.getLocation().getWorld();
					Location loc12 = new Location(w, x, y + 1.2, z);
					Hologram hologram = HologramsAPI.createHologram(Main.getInstance(), loc12);
					hologram.appendTextLine(text);
					hologram.setAllowPlaceholders(true);
			 }
			

		
	 }
 }
 

}
