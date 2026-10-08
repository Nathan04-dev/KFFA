package at.nathi.title;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

public class ActionBar {
	
	private String message;
	
	public ActionBar(String msg) {
		this.message = msg;
	}
	public void send(Player p) {
		
		IChatBaseComponent ichat = ChatSerializer.a("{\"text\": \"\"}").a(message);
		PacketPlayOutChat chat = new PacketPlayOutChat(ichat, (byte)2);
		
		CraftPlayer cp = (CraftPlayer)p;
		cp.getHandle().playerConnection.sendPacket(chat);
	}

}
