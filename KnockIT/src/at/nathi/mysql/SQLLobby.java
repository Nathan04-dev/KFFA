package at.nathi.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLLobby {
	
	
	public static boolean playerExists(String uuid) {
		
		try {
		ResultSet rs = MySQL.getResult("SELECT * FROM Lobby WHERE UUID= '" + uuid + "'");
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
			MySQL.update("INSERT INTO Lobby(UUID, X, Y, Z, World, Yaw, Pitch) VALUES ('" + uuid + "', '0', '0', '0', 'world', '0', '0');");
		}
	}
	public static Double getX(String uuid) {
		Double i = 0.0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (Double.valueOf(rs.getDouble("X")) == null));
				
					i = rs.getDouble("X");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getX(uuid);
		}
		return i;
	}
	public static Double getY(String uuid) {
		Double i = 0.0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (Double.valueOf(rs.getDouble("Y")) == null));
				
					i = rs.getDouble("Y");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getY(uuid);
		}
		return i;
	}
	public static Double getZ(String uuid) {
		Double i = 0.0;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (Double.valueOf(rs.getDouble("Z")) == null));
				
					i = rs.getDouble("Z");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getZ(uuid);
		}
		return i;
	}
	public static Float getYaw(String uuid) {
		Float i = null;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (Float.valueOf(rs.getFloat("Yaw")) == null));
				
					i = rs.getFloat("Yaw");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getYaw(uuid);
		}
		return i;
	}
	public static Float getPitch(String uuid) {
		Float i = null;
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (Float.valueOf(rs.getFloat("Pitch")) == null));
				
					i = rs.getFloat("Pitch");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getPitch(uuid);
		}
		return i;
	}
	
	public static String getWorld(String uuid) {
		String i = "";
		
		if(playerExists(uuid)) {
			
			try {
				ResultSet rs = MySQL.getResult("SELECT * FROM Lobby");
				
				if((!rs.next()) || (String.valueOf(rs.getString("World")) == null));
				
					i = rs.getString("World");
				
					} catch (SQLException e) {
					
						e.printStackTrace();
				
				}
			
		} else  {
			createPlayer(uuid);
			getWorld(uuid);
		}
		return i;
	}
	
	public static void setX(String uuid, Double x) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET X= '" + x + "';");
			
		} else {
			createPlayer(uuid);
			setX(uuid, x);
		}
	}
	public static void setY(String uuid, Double y) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET Y= '" + y + "';");
			
		} else {
			createPlayer(uuid);
			setY(uuid, y);
		}
	}
	
	public static void setZ(String uuid, Double z) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET Z= '" + z +  "';");
			
		} else {
			createPlayer(uuid);
			setZ(uuid, z);
		}
	}
	public static void setYaw(String uuid, Float yaw) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET Yaw= '" + yaw + "';");
			
		} else {
			createPlayer(uuid);
			setYaw(uuid, yaw);
		}
	}
	public static void setPitch(String uuid, Float pitch) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET Pitch= '" + pitch + "';");
			
		} else {
			createPlayer(uuid);
			setPitch(uuid, pitch);
		}
	}
	public static void setWorld(String uuid, String w) {
		if(playerExists(uuid)) {
			MySQL.update("UPDATE Lobby SET World= '" + w + "';");
			
		} else {
			createPlayer(uuid);
		
		}
	}
	
	public static void addX(String uuid, Double x) {
		if(playerExists(uuid)) {
			setX(uuid, Double.valueOf(getX(uuid).doubleValue()+ x.doubleValue()));
			
		} else {
			createPlayer(uuid);
			
		}
	}
	public static void addY(String uuid, Double y) {
		if(playerExists(uuid)) {
			setY(uuid, Double.valueOf(getY(uuid).doubleValue()+ y.doubleValue()));
			
		} else {
			createPlayer(uuid);
			
		}
	}
	public static void addZ(String uuid, Double z) {
		if(playerExists(uuid)) {
			setZ(uuid, Double.valueOf(getZ(uuid).doubleValue() + z.doubleValue()));
			
		} else {
			
			
			
			createPlayer(uuid);
		
		}
	}
	public static void addYaw(String uuid, Float yaw) {
		if(playerExists(uuid)) {
			setYaw(uuid, Float.valueOf(getYaw(uuid).floatValue() + yaw.floatValue()));
			
		} else {
			createPlayer(uuid);
		
		}
	}
	public static void addPitch(String uuid, Float pitch) {
		if(playerExists(uuid)) {
			setPitch(uuid, Float.valueOf(getPitch(uuid).floatValue() + pitch.floatValue()));
			
		} else {
			createPlayer(uuid);
		
		}
	}
	public static void addWorld(String uuid, String w) {
		if(playerExists(uuid)) {
			setWorld(uuid, String.valueOf(getWorld(uuid).toString()));
			
		} else {
			createPlayer(uuid);
			
		}
	}
}
