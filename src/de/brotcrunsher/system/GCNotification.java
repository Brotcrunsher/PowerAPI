package de.brotcrunsher.system;

import java.util.ArrayList;
import java.util.List;

public class GCNotification {
	private static boolean shouldInstanciate = true;
	private static boolean printWarning = true;
	private static List<Runnable> gcListeners = new ArrayList<>();
	
	private GCNotification(){
		if(!shouldInstanciate){
			throw new IllegalStateException("");
		}
		
		shouldInstanciate = false;
	}
	
	public static void tick(){
		if(shouldInstanciate){
			new GCNotification();
		}
	}
	
	public static boolean isPrintWarning() {
		return printWarning;
	}

	public static void setPrintWarning(boolean printWarning) {
		GCNotification.printWarning = printWarning;
	}

	@Override
	protected void finalize() throws Throwable {
		shouldInstanciate = true;
		if(printWarning){
			System.out.println("WARNING! GC was run at " + System.currentTimeMillis());
		}
		for(Runnable run : gcListeners){
			run.run();
		}
	}
	
	public static void addGCListener(Runnable run){
		if(run == null) throw new NullPointerException("run was null!");
		
		gcListeners.add(run);
	}
	
	public static void removeGCListener(Runnable run){
		if(run == null) throw new NullPointerException("run was null!");
		
		gcListeners.remove(run);
	}
}
