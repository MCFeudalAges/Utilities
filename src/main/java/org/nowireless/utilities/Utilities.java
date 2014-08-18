package org.nowireless.utilities;

import org.nowireless.utilities.cmd.CmdUtil;
import org.nowireless.utilities.s2b.S2B;

import com.massivecraft.massivecore.MassivePlugin;

public class Utilities extends MassivePlugin {
	private static Utilities i;
	public static Utilities get() { return i;}
	public Utilities() { i = this; }
	
	private CmdUtil outerCmdUtil;
	public CmdUtil getOuterCmdUtil() { return outerCmdUtil; }
	
	@Override
	public void onEnable() {
		if(!this.preEnable()) return;
		
		S2B.init();
		
		this.outerCmdUtil = new CmdUtil();
		this.outerCmdUtil.register();
		
		this.postEnable();
	}
}
