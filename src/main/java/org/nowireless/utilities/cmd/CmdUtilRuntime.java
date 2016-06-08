package org.nowireless.utilities.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.util.Txt;

public class CmdUtilRuntime extends MassiveCommand {
	public CmdUtilRuntime() {
		this.addRequirements(RequirementHasPerm.get("util.runtime"));
		this.addAliases("runtime");
	}
	
	@Override
	public void perform() {
		
		long freeMen = Runtime.getRuntime().freeMemory();
		long totalMen = Runtime.getRuntime().totalMemory();
		long maxMem = Runtime.getRuntime().maxMemory();
		long usedMem = totalMen - freeMen;
		
		List<Object> ret = new ArrayList<Object>();
		
		ret.add(Txt.titleize("Runtime"));
		ret.add(Txt.parse("<i>Free: <v>" + Math.round(this.byteToMb(freeMen)) + "<i>MB"));
		ret.add(Txt.parse("<i>Total: <v>" + Math.round(this.byteToMb(totalMen)) + "<i>MB"));
		ret.add(Txt.parse("<i>Max: <v>" + Math.round(this.byteToMb(maxMem)) + "<i>MB"));
		ret.add(Txt.parse("<i>Used: <v>" + Math.round(this.byteToMb(usedMem)) + "<i>MB"));
		
		this.message(ret);
	}
	
	private double byteToMb(long bytes) {
		return bytes/1000000;
	}
}
