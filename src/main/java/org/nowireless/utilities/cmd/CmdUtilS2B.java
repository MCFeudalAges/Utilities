package org.nowireless.utilities.cmd;

import java.util.UUID;

import org.nowireless.utilities.s2b.TaskS2B;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.util.Txt;

public class CmdUtilS2B extends MassiveCommand {
	public CmdUtilS2B() {
		this.addAliases("s2b");
		this.addRequirements(ReqHasPerm.get("util.s2b"));
	}

	@Override
	public void perform() {
		this.sendMessage(Txt.parse("<info>Starting s2b task"));
		
		UUID id = null;
		if(!this.senderIsConsole) {
			id = me.getUniqueId();
		}
		new TaskS2B(id).register();
	}
	
}
