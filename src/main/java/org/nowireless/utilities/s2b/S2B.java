package org.nowireless.utilities.s2b;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.jruby.embed.PathType;
import org.jruby.embed.ScriptingContainer;
import org.nowireless.utilities.Utilities;
import org.nowireless.utilities.util.StringFilter;

public class S2B {
	
	public static final String kMehtod = "convert";
	private final Logger logger = Logger.getLogger("S2B");
	private final StringFilter filter = new StringFilter("bo2");
	private final File inDir = new File("in");
	private final File outDir = new File("out");
	private final File schematicDir = new File("./plugins/WorldEdit/schematics");	
	
	private static S2B i;
	public static S2B get() { return i; }
	
	private ScriptingContainer container;
	private Object receiver;
	
	public static void init() {
		i = new S2B();
		i.container = new ScriptingContainer();
		i.container.setClassLoader(Utilities.class.getClassLoader());
		i.container.setOutput(System.out);
		i.receiver = i.container.runScriptlet(PathType.CLASSPATH, "s2b.rb");
	}
	
	public boolean convert() {
		if(this.createFolders()) {
			if(this.clearInFolder()) {
				if(this.copyToInFolder()) {
					this.container.callMethod(receiver, kMehtod, Object.class);
					return true;
				}
			}
		}
		return false;
	}
	
	public ScriptingContainer getContainer() {
		return container;
	}
	
	private boolean createFolders() {
		boolean ret = true;
		
		if(!inDir.exists()) {
			logger.info("Creating In Dir at ./" + inDir.getPath());
			ret = inDir.mkdirs();
		}
		
		if(!ret) return false;
		
		if(!schematicDir.exists()) {
			logger.info("Creating schematic Dir at ./" + schematicDir.getPath());
			ret = schematicDir.mkdirs();
		}
		
		if(!ret) return false;
		
		if(!outDir.exists()) {
			logger.info("Creating out Dir at ./" + outDir.getPath());
			ret = outDir.mkdirs();
		}
		
		return ret;
	}
	
	private boolean clearInFolder() {
		boolean ret = false;
		try {
			logger.info("Cleaning In dir");
			FileUtils.cleanDirectory(inDir);
			ret = true;
		} catch (IOException e) {
			logger.severe("Could not clean In dir");
			e.printStackTrace();
		}
		return ret;
	}
	
	private boolean copyToInFolder() {
		boolean ret = true;
		String[] files = schematicDir.list();
		if(files == null) {
			logger.warning("No files to copy over from " + schematicDir.getPath());
			ret = false;
		} else {
			List<String> in = filter.filter(Arrays.asList(files));
			logger.info("In Dir Items: " + in.size());
			for(String fileName : in) {
				File inFile = new File(schematicDir, fileName);
				File afterFile = new File(inDir, fileName);
				logger.info("Moving " + inFile.getPath() + " to " + afterFile.getPath());
				
				
				try {
					FileUtils.copyFile(inFile, afterFile);
				} catch (IOException e) {
					logger.severe("Could not move file");
					ret = false;
					e.printStackTrace();
					break;
				}
			}
		}
		
		return ret;
	}
}
