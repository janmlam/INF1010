class MinstTradR extends Thread {
	int [ ] tab; 
	int startInd, endInd;
	MinstMonitor mon;
	MinstTradR(int[] tb, int st, int en, MinstMonitor m) {
		tab = tb; 
		startInd = st; 
		endInd = en;
		mon = m;
	}

	public void run(){
		int minVerdi = Integer.MAX_VALUE;
		for ( int ind = startInd; ind <= endInd; ind++)
			if(tab[ind] < minVerdi) minVerdi = tab[ind];
		// denne tråden er ferdig med jobben:
			mon.giMinsteVerdi(minVerdi);
	} // slutt run
} // slutt MinstTradR