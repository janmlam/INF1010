class MinstMonitorR implements MinstMonitor {
	private int minstTilNa = Integer.MAX_VALUE;
	private int antallFerdigeSubtrader = 0;
	
	synchronized void vent() {
		while (antallFerdigeSubtrader != 64) {
			try {wait();
				System.out.println(antallFerdigeSubtrader + " ferdige subtråder ");
			}
			catch (InterruptedException e) {
				System.out.println(" Uventet avbrudd ");
				System.exit(1);
			}
		// antall ferdige subtråder er nå 64
		}
	}		
	synchronized void giMinsteVerdi (int minVerdi) {
		antallFerdigeSubtrader ++;
		if(minstTilNa > minVerdi) minstTilNa = minVerdi;
		if(antallFerdigeSubtrader == 64) notify();
		// eller hver gang, (men stort sett unødvendig): notify();
	}
	synchronized int hentMinste () {
		return minstTilNa;
	}
}