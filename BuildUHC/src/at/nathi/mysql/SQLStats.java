package at.nathi.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLStats {
	
	public static boolean playerExists(String uuid) {
		
		try {
		ResultSet rs = MySQL.getResult("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
			if(rs.next()) {
		
				return rs.getString("UUID") != null;
			}
			return false;
			} catch (SQLException e) {
			
				e.printStackTrace();
		
		}
		
		return false;
	}
	
	public static void createPlayer(String uuid) {
		if(!(playerExists(uuid))) {
			MySQL.update("INSERT INTO Stats(UUID, NAME, KILLS, TODE, COINS) VALUES ('" + uuid + "', '', '0', '0', '0');");
		}
	}
	
	
	public static Integer getKills(String uuid) {
		Integer i = 0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				
				if((!rs.next()) || (Integer.valueOf(rs.getInt("KILLS")) == null));
				
					i = rs.getInt("KILLS");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getKills(uuid);
		}
		return i;
	}
	
	public static Integer getTode(String uuid) {
		Integer i = 0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				
				if((!rs.next()) || (Integer.valueOf(rs.getInt("TODE")) == null));
				
					i = rs.getInt("TODE");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getTode(uuid);
		}
		return i;
	}
	public static Integer getCoins(String uuid) {
		Integer i = 0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				
				if((!rs.next()) || (Integer.valueOf(rs.getInt("COINS")) == null));
				
					i = rs.getInt("COINS");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getCoins(uuid);
		}
		return i;
	}
	public static String getName(String uuid) {
		String i = "";
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Stats WHERE UUID= '" + uuid + "'");
				
				if((!rs.next()) || (Integer.valueOf(rs.getString("NAME")) == null));
				
					i = rs.getString("NAME");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getName(uuid);
		}
		return i;
	}
	public static void setKills(String uuid, Integer kills) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Stats SET KILLS= '" + kills + "' WHERE UUID= '" + uuid + "';");
			
		} else {
			createPlayer(uuid);
			setKills(uuid, kills);
		}
	}
	public static void setTode(String uuid, Integer tode) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Stats SET TODE= '" + tode + "' WHERE UUID= '" + uuid + "';");
			
		} else {
			createPlayer(uuid);
			setTode(uuid, tode);
		}
	}
	public static void setCoins(String uuid, Integer coins) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Stats SET COINS= '" + coins + "' WHERE UUID= '" + uuid + "';");
			
		} else {
			createPlayer(uuid);
			setCoins(uuid, coins);
		}
	}
	public static void setName(String uuid, String name) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Stats SET NAME= '" + name + "' WHERE UUID= '" + uuid + "';");
			
		} else {
			createPlayer(uuid);
			setName(uuid, name);
		}
	}
	
	public static void addCoins(String uuid, Integer coins) {
		if(playerExists(uuid)) {
			setCoins(uuid, Integer.valueOf(getCoins(uuid).intValue() + coins.intValue()));
			
		} else {
			createPlayer(uuid);
			addCoins(uuid, coins);
		}
	}
	public static void addKills(String uuid, Integer kills) {
		if(playerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() + kills.intValue()));
			
		} else {
			createPlayer(uuid);
			addKills(uuid, kills);
		}
	}
	public static void addTode(String uuid, Integer tode) {
		if(playerExists(uuid)) {
			setTode(uuid, Integer.valueOf(getTode(uuid).intValue() + tode.intValue()));
			
		} else {
			createPlayer(uuid);
			addTode(uuid, tode);
		}
	}
	public static void addName(String uuid, String name) {
		if(playerExists(uuid)) {
			setName(uuid, String.valueOf(getName(uuid).toString()));
			
		} else {
			createPlayer(uuid);
			addName(uuid, name);
		}
	}
	public static void removeKills(String uuid, Integer kills) {
		if(playerExists(uuid)) {
			setKills(uuid, Integer.valueOf(getKills(uuid).intValue() - kills.intValue()));
			
		} else {
			createPlayer(uuid);
			removeKills(uuid, kills);
		}
	}
	public static void removeTode(String uuid, Integer tode) {
		if(playerExists(uuid)) {
			setTode(uuid, Integer.valueOf(getKills(uuid).intValue() - tode.intValue()));
			
		} else {
			createPlayer(uuid);
			removeTode(uuid, tode);
		}
	}
	public static void removeCoins(String uuid, Integer coins) {
		if(playerExists(uuid)) {
			setCoins(uuid, Integer.valueOf(getCoins(uuid).intValue() - coins.intValue()));
			
		} else {
			createPlayer(uuid);
			removeCoins(uuid, coins);
		}
	}
}
