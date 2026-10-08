package at.nathi.listeners;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import at.nathi.main.Main;
import config.messages;
public class RandomEffects {
	
	public static int taskID1;
	public static int mapseconds1 = 10800;
	
	
	public static void Aktiviert() {
		PotionEffect weakness = new PotionEffect(PotionEffectType.WEAKNESS, 12000, 0);
		PotionEffect jump = new PotionEffect(PotionEffectType.JUMP, 12000, 0);
		PotionEffect absorption = new PotionEffect(PotionEffectType.ABSORPTION, 12000, 0);
		
	
		
		PotionEffect random = null;
		Random rand = new Random();
        int zufall = rand.nextInt(3); 
        
        switch(zufall) {
        case 0:
        	for(Player all: Bukkit.getOnlinePlayers()) {
        		all.removePotionEffect(PotionEffectType.JUMP);
         		all.removePotionEffect(PotionEffectType.ABSORPTION);
        	}
        	random = weakness;
        	Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.WEAKNESS_EFFEKT"));
        	break;
        case 1:
          	for(Player all: Bukkit.getOnlinePlayers()) {
        		all.removePotionEffect(PotionEffectType.WEAKNESS);
         		all.removePotionEffect(PotionEffectType.ABSORPTION);
        	}
        	random = jump;
        	Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.JUMP_EFFEKT"));
        	break;
        case 2:
          	for(Player all: Bukkit.getOnlinePlayers()) {
        		all.removePotionEffect(PotionEffectType.WEAKNESS);
         		all.removePotionEffect(PotionEffectType.JUMP);
        	}
        	random = absorption;
        	Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.ABSORPTION_EFFEKT"));
        	break;
        	
        }
       for(Player all : Bukkit.getOnlinePlayers()) {
    	   all.addPotionEffect(random);
       } 
	}
	
	public static void startEffects() {
		taskID1 = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				mapseconds1--;
				switch(mapseconds1) {
				case 10799:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 10210:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 10209:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 10208:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 10207:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 10206:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 10205:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 10204:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 10203:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 10202:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 10201:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 10200:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 9610:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 9609:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 9608:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 9607:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 9606:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 9605:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 9604:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 9603:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 9602:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 9601:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 9600:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 9010:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 9009:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 9008:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 9007:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 9006:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 9005:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 9004:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 9003:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 9002:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 9001:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 9000:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 8410:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 8409:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 8408:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 8407:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 8406:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 8405:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 8404:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 8403:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 8402:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;					
				case 8401:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 8400:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 7810:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 7809:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 7808:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 7807:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 7806:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 7805:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 7804:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 7803:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 7802:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 7801:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 7800:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 7210:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 7209:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 7208:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 7207:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 7206:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 7205:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 7204:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 7203:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 7202:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 7201:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 7200:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 6610:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 6609:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 6608:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 6607:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 6606:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second16"));
					break;
				case 6605:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 6604:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 6603:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 6602:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 6601:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 6600:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 6010:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 6009:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 6008:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 6007:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 6006:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 6005:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 6004:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 6003:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 6002:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 6001:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 6000:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 5410:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 5409:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 5408:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 5407:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 5406:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 5405:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 5404:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 5403:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 5402:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 5401:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 5400:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 4810:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 4809:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 4808:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 4807:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 4806:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 4805:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 4804:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 4803:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 4802:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 4801:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 4800:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 4210:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 4209:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 4208:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 4207:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 4206:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 4205:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 4204:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 4203:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 4202:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 4201:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 4200:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 3610:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 3609:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 3608:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 3607:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 3606:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 3605:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 3604:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 3603:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 3602:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 3601:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 3600:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 3010:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 3009:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 3008:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 3007:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 3006:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 3005:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 3004:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 3003:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 3002:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 3001:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 3000:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 2410:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 2409:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 2408:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 2407:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 2406:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 2405:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 2404:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 2403:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 2402:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 2401:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 2400:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 1810:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 1809:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 1808:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 1807:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 1806:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 1805:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 1804:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 1803:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 1802:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 1801:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 1800:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 1210:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 1209:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 1208:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 1207:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 1206:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 1205:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 1204:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 1203:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 1202:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 1201:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 1200:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 610:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 609:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 608:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 607:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 606:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 605:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 604:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 603:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 602:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 601:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 600:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
				case 10:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second10"));
					break;
				case 9:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second9"));
					break;
				case 8:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second8"));
					break;
				case 7:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second7"));
					break;
				case 6:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second6"));
					break;
				case 5:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second5"));
					break;
				case 4:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second4"));
					break;
				case 3:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second3"));
					break;
				case 2:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second2"));
					break;
				case 1:
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Second1"));
					break;
				case 0:
					Aktiviert();
					Bukkit.broadcastMessage(Main.prefix + messages.messageConfig.getString("MSGConfig.Effect_Minute"));
					break;
					default:
						break;
				}
				
			}
		}, 0, 20);
	}
	


}
