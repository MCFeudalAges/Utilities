package org.nowireless.utilities.s2b;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.nowireless.utilities.Utilities;
import org.nowireless.utilities.util.SyncReturnMessageTask;

import com.massivecraft.massivecore.util.Txt;

public class TaskS2B implements Runnable {
	private UUID id;
	
	public TaskS2B(UUID player) {
		this.id = player;
	}
	
	@Override
	public void run() {
		String msg = "<info>s2b Finished";
		if(!S2B.get().convert()) {
			msg = "<bad>s2b Failed";
		}
		new SyncReturnMessageTask(Txt.parse(msg), id).register();;
	}
	
	public void register() {
		Bukkit.getScheduler().runTaskAsynchronously(Utilities.get(), this);
	}
}
 