package org.nowireless.utilities.cmd;

import com.massivecraft.massivecore.cmd.MassiveCommand;

public class CmdUtil extends MassiveCommand {
	public CmdUtilS2B cmdUtilS2B = new CmdUtilS2B();
	public CmdUtilRuntime cmdUtilRuntime = new CmdUtilRuntime();
	public CmdUtilChat cmdUtilChat = new CmdUtilChat();
	
	public CmdUtil() {
		this.addSubCommand(cmdUtilS2B);
		this.addSubCommand(cmdUtilRuntime);
		this.addSubCommand(cmdUtilChat);
		this.addAliases("util", "u");
	}
}
