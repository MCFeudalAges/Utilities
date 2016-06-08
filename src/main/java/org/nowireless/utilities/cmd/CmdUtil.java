package org.nowireless.utilities.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;

public class CmdUtil extends MassiveCommand {
	public CmdUtilS2B cmdUtilS2B = new CmdUtilS2B();
	public CmdUtilRuntime cmdUtilRuntime = new CmdUtilRuntime();
	public CmdUtilChat cmdUtilChat = new CmdUtilChat();
	
	private static CmdUtil i = new CmdUtil();
	public static CmdUtil get() { return i; }
	
	public CmdUtil() {
		this.addChild(cmdUtilS2B);
		this.addChild(cmdUtilRuntime);
		this.addChild(cmdUtilChat);
		this.addAliases("util", "u");
	}
}
