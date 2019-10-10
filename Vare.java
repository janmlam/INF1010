class Vare { 
	public static void main (String[] args) { 
		Vare v = new Vare();
		v.pris = 100;
		SalgsVare s = new SalgsVare();
		s.pris = 100;
		s.rabatt =25; 
 	} 
} 

class Vare { 
	int pris;

	int prisUtenMoms() {
		return pris;
	}
	int prisMedMoms() {
		return (int) (1.25*prisUtenMoms());
	}
} 

class SalgsVare extends Vare { 
	int rabatt;

	int prisUtenMoms() {
		return pris-(pris*rabatt/100);
	}
} 