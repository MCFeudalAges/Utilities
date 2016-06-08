package org.nowireless.utilities.cmd;

import java.util.List;

import org.bukkit.Bukkit;

import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsntPlayer;
import com.massivecraft.massivecore.command.type.primitive.TypeString;
import com.massivecraft.massivecore.util.Txt;

public class CmdUtilChat extends MassiveCommand {
	public CmdUtilChat() {
		this.addAliases("chat", "c");
		
		this.addParameter(TypeString.get(),"msg");
		this.setOverflowSensitive(false);
		
		this.addRequirements(RequirementHasPerm.get("util.chat"));
		this.addRequirements(RequirementIsntPlayer.get());
	}
	
	@Override
	public void perform() {
		List<String> msg = this.getArgs();
		if(!this.senderIsConsole) {
			this.message(Txt.parse("<bad>You need to be at the console"));
			
		} 
		
		Bukkit.getServer().broadcastMessage(Txt.parse("<white>[<red>Controller<white>]<notice> " + Txt.implode(msg, " ")));
	}
}
