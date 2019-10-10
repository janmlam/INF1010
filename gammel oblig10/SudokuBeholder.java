class SudokuBeholder {
	Rute[] losninger = new Rute[2500];
	int totLosninger = 0;

	public void settInn(Rute losning) {
		totLosninger++;
		for(int i= 0; i<losninger.length; i++) {
			if(losninger[i] == null) {
				losninger[i] = losning;
				break;
			}
		}
	}

	public void taUt() {

	}

}