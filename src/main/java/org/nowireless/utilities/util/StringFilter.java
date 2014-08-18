package org.nowireless.utilities.util;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StringFilter {
	private final String start;
	private final Logger logger;
	
	public StringFilter(String start, Logger log) {
		this.start = start.toLowerCase();
		this.logger = log;
	}
	
	public StringFilter(String start) {
		this(start, null);
	}
	
	public List<String> filter(List<String> in) {
		log(in.toString());
		List<String> ret = new ArrayList<String>(in.size());
		
		for(String string : in) {
			if(string.toLowerCase().startsWith(start)) {
				log("Adding "+ string);
				ret.add(string);
			} else {
				log("Ignoring " + string);
			}
		}
		
		return ret;
	}
	
	private void log(String msg) { if(logger != null) logger.info(msg); }
}
