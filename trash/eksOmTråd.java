public class MinstR {
	final int maxVerdiInt = Integer.MAX_VALUE;
	int [ ] tabell;
	MinstMonitor monitor;
	public static void main(String[ ] args) {
	new MinstR();
}

public MinstR ( ) {
	tabell = new int[640000];
	for (int in = 0; in< 640000; in++) {
		tabell[in] = (int)Math.round(Math.random()* maxVerdiInt);
		monitor = new MinstMonitorR();
	}
	for (int i = 0; i< 64; i++) {
	// Lag og start 64 tråder
		new MinstTradR(tabell,i*10000,((i+1)*10000)-1,monitor).start();
		monitor.vent();
		System.out.println("Minste verdi var: " + monitor.hentMinste());
	}
}