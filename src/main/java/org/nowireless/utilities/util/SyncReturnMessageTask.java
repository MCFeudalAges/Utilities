package org.nowireless.utilities.util;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.nowireless.utilities.Utilities;

public class SyncReturnMessageTask implements Runnable {
	private UUID id;
	private String msg;
	private Plugin plugin;
	
	public SyncReturnMessageTask(String msg, UUID id) {
		this(Utilities.get(), msg, id);
	}
	
	public SyncReturnMessageTask(Plugin plugin, String msg, UUID id) {
		this.plugin = plugin;
		this.msg = msg;
		this.id = id;
	}
	
	public void register() {
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, this, 10);
	}
	
	@Override
	public void run() {
		Player sender = Bukkit.getServer().getPlayer(id);
		
		if(sender != null) {
			sender.sendMessage(msg);
		} else {
			Bukkit.getConsoleSender().sendMessage(msg);
		}
	}
}
