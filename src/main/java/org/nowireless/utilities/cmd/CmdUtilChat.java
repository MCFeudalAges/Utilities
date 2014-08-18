package org.nowireless.utilities.cmd;

import org.bukkit.Bukkit;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.req.ReqIsntPlayer;
import com.massivecraft.massivecore.util.Txt;

public class CmdUtilChat extends MassiveCommand {
	public CmdUtilChat() {
		this.addAliases("chat", "c");
		
		this.addRequiredArg("msg");
		this.setErrorOnToManyArgs(false);
		
		this.addRequirements(ReqHasPerm.get("util.chat"));
		this.addRequirements(ReqIsntPlayer.get());
	}
	
	@Override
	public void perform() {
		String msg = this.argConcatFrom(0);
		if(!this.senderIsConsole) {
			this.sendMessage(Txt.parse("<bad>You need to be at the console"));
		} 
		
		Bukkit.getServer().broadcastMessage(Txt.parse("<white>[<red>Controller<white>]<notice> " + msg));
	}
}
