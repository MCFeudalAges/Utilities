package org.nowireless.utilities.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.util.Txt;

public class CmdUtilRuntime extends MassiveCommand {
	public CmdUtilRuntime() {
		this.addRequirements(ReqHasPerm.get("util.runtime"));
		this.addAliases("runtime");
	}
	
	@Override
	public void perform() {
		
		long freeMen = Runtime.getRuntime().freeMemory();
		long totalMen = Runtime.getRuntime().totalMemory();
		long maxMem = Runtime.getRuntime().maxMemory();
		long usedMem = totalMen - freeMen;
		
		List<String> ret = new ArrayList<String>();
		
		ret.add(Txt.titleize("Runtime"));
		ret.add(Txt.parse("<i>Free: <v>" + Math.round(this.byteToMb(freeMen)) + "<i>MB"));
		ret.add(Txt.parse("<i>Total: <v>" + Math.round(this.byteToMb(totalMen)) + "<i>MB"));
		ret.add(Txt.parse("<i>Max: <v>" + Math.round(this.byteToMb(maxMem)) + "<i>MB"));
		ret.add(Txt.parse("<i>Used: <v>" + Math.round(this.byteToMb(usedMem)) + "<i>MB"));
		
		sendMessage(ret);
	}
	
	private double byteToMb(long bytes) {
		return bytes/1000000;
	}
}
