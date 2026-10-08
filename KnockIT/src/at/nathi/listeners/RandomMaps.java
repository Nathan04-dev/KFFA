package at.nathi.listeners;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;

import at.nathi.main.Main;
import config.GUI;
import config.locations;
import config.messages;

public class RandomMaps {
	
	public static int taskID1;
	public static int mapseconds1 = 10800;
	



	public static Location startloc1() {
		


					double x1 = (double) locations.LocationConfig.getDouble("Map1.X");
					double y1 = (double) locations.LocationConfig.getDouble("Map1.Y");
					double z1 = (double) locations.LocationConfig.getDouble("Map1.Z");
					String w1 = (String) locations.LocationConfig.getString("Map1.World");
					float yaw1 = (float) locations.LocationConfig.getDouble("Map1.Yaw");
					float pitch1 = (float) locations.LocationConfig.getDouble("Map1.Pitch");
					World world1 = Bukkit.getWorld(w1);
					
					Location loc1 = new Location(world1, x1, y1, z1, yaw1, pitch1);
					
					double x2 = (double) locations.LocationConfig.getDouble("Map2.X");
					double y2 = (double) locations.LocationConfig.getDouble("Map2.Y");
					double z2 = (double) locations.LocationConfig.getDouble("Map2.Z");
					String w2 = (String) locations.LocationConfig.getString("Map2.World");
					float yaw2 = (float) locations.LocationConfig.getDouble("Map2.Yaw");
					float pitch2 = (float) locations.LocationConfig.getDouble("Map2.Pitch");
					World world2 = Bukkit.getWorld(w2);
					
					Location loc2 = new Location(world2, x2, y2, z2, yaw2, pitch2);
					
					double x3 = (double) locations.LocationConfig.getDouble("Map3.X");
					double y3 = (double) locations.LocationConfig.getDouble("Map3.Y");
					double z3 = (double) locations.LocationConfig.getDouble("Map3.Z");
					String w3 = (String) locations.LocationConfig.getString("Map3.World");
					float yaw3 = (float) locations.LocationConfig.getDouble("Map3.Yaw");
					float pitch3 = (float) locations.LocationConfig.getDouble("Map3.Pitch");
					World world3 = Bukkit.getWorld(w3);
					
					Location loc3 = new Location(world3, x3, y3, z3, yaw3, pitch3);
					
					Location random = null;
					Random rand = new Random();
					int zufall = rand.nextInt(2);
					
					switch(zufall) {

					case 0:
						random = loc1;
						for(Player all: Bukkit.getOnlinePlayers()) {
						String map1 = GUI.GUIConfig.getString("MapsGUI.Map1_Select");
						map1 = map1.replace("%Map1_Name%", locations.LocationConfig.getString("Map1.Name"));
						
						all.closeInventory();
						all.sendMessage(Main.prefix + map1);
						all.sendTitle(Main.prefix, null, 20, 20, 20);
						all.teleport(loc1);
						all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
						all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
						}
						break;
					case 1:
						random = loc2;
						for(Player all : Bukkit.getOnlinePlayers()) {
							String map2 = GUI.GUIConfig.getString("MapsGUI.Map2_Select");
							map2 = map2.replace("%Map2_Name%", locations.LocationConfig.getString("Map2.Name"));
							
							all.closeInventory();
							all.sendMessage(Main.prefix + map2);
							all.sendTitle(Main.prefix, null, 20, 20, 20);
							all.teleport(loc2);
							all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
							all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
						}
						break;
					case 2:
						random = loc3;
						for(Player all : Bukkit.getOnlinePlayers()) {
						String map3 = GUI.GUIConfig.getString("MapsGUI.Map3_Select");
						map3 = map3.replace("%Map3_Name%", locations.LocationConfig.getString("Map3.Name"));
						all.closeInventory();
						all.sendMessage(Main.prefix + map3);
						all.sendTitle(Main.prefix, null, 20, 20, 20);
						all.teleport(loc3);
						all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_SNARE, 15, 15);
						all.playSound(all.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 15, 15);
						}
						break;
						
					}
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.teleport(random);
					}
					return random;		
		
	}
	public static void starting() {
	 Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				mapseconds1--;
				switch(mapseconds1) {
				case 10799:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 10000:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 9999:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 9998:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 9997:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 9996:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 9995:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 9994:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 9993:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 9992:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 9991:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 9900:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 9010:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 9009:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 9008:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 9007:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 9006:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 9005:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 9004:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 9003:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 9002:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 9001:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 9000:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 8110:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 8109:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 8108:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 8107:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 8106:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 8105:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 8104:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 8103:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 8102:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 8101:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 8100:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 7210:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 7209:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 7208:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 7207:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 7206:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 7205:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 7204:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 7203:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 7202:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 7201:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 7200:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 6310:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 6309:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 6308:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 6307:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 6306:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 6305:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 6304:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 6303:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 6302:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 6301:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 6300:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 5410:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 5409:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 5408:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 5407:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 5406:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 5405:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 5404:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 5403:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 5402:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 5401:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 5400:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 4510:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 4509:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 4508:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 4507:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 4506:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 4505:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 4504:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 4503:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 4502:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 4501:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 4500:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 3610:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 3609:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 3608:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 3607:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 3606:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 3605:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 3604:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 3603:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 3602:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 3601:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 3600:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 2710:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 2709:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 2708:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 2707:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 2706:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 2705:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 2704:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 2703:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 2702:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 2701:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;		
				case 2700:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 1810:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 1809:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 1808:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 1807:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 1806:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 1805:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;		
				case 1804:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 1803:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;	
				case 1802:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 1801:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 1800:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 910:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 909:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 908:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 907:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 906:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 905:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 904:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 903:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 902:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;		
				case 901:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 900:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
				case 10:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second10"));
					break;
				case 9:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second9"));
					break;
				case 8:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second8"));
					break;
				case 7:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second7"));
					break;
				case 6:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second6"));
					break;
				case 5:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second5"));
					break;
				case 4:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second4"));
					break;
				case 3:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second3"));
					break;
				case 2:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second2"));
					break;
				case 1:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Second1"));
					break;
				case 0:
					startloc1();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Map_Minute"));
					break;
					default:
						break;
				}
				
			}
		}, 0, 20);
	}
	
}
