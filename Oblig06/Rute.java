//Rute klasse som har sine
//egne egenskaper
class Rute {
	int verdi;
	Brett brett;
	Boks boks;
	Rad rad;
	Kolonne kolonne;
	Rute neste;
	int str;

	//gir rute en verdi
	Rute(int i) {
		this.verdi = i;
	}


	//angir boks, brett til rute
	public void settInnBoks(Boks b, Brett br) {
		this.boks = b;
		this.brett = br;
	}

	//angir rad, brett til rute
	public void settInnRad(Rad r, Brett br) {
		this.rad = r;
		this.brett = br;
	}

	//angir kolonne, brett til rute
	public void settInnKolonne(Kolonne k, Brett br) {
		this.kolonne = k;
		this.brett = br;
	}

	//metode som returnerer verdi til ruten
	public int faaVerdi() {
		return verdi;
	}

	//metode som angir nestepekere
	public void setNeste(Rute ru) {
		neste = ru;
	}

	//hasNext metode
	public Boolean hasNext() {
		return neste != null;
	}

	//metoded som gir neste
	public Rute faaNeste() {
		return neste;
	}

	//metode som sjekker om oppgitt verdi, i 
	// er lovlig i denne ruten
	//returnerer true/false
	Boolean sjekk;
	public Boolean erLovlig(int i) {
		if(rad.lovligVerdi(i) == true && boks.lovligVerdi(i) == true && kolonne.lovligVerdi(i) == true) {
			sjekk = true;
		}
		else {
			sjekk = false;
		}
		return sjekk;
	}

	//metode som finner alle mulige tall i en rute
	public int[] finnAlleMuligeTall() {
		this.str = brett.giStr();
		if(this instanceof Opptatt) {
			return null;
		}
		else {
			int[] ledige = new int[str];
			int teller = 0;
			for(int i=0; i<str; i++) {
				System.out.println(i);
				if(rad.lovligVerdi(i) == true && boks.lovligVerdi(i) == true && kolonne.lovligVerdi(i) == true) {
					ledige[teller] = i;
				}
				else {
					ledige[teller] = 0;
				}
				teller++;
			}
			for(int i=0; i<ledige.length; i++) {
				System.out.println(ledige[i]);
			}
			return ledige;
		}	
	}

	//fyllUt-metode. etter hver funnet lovlig tall
	//settes 0 inn
	public void fyllUt() {
		if(this instanceof Opptatt) {
			if(neste != null) {
				neste.fyllUt();
			}
			else {
				System.out.println("Fant losning");
				brett.fantLosning();
			}
		}
		else {
			for(int i=1; i<=rad.faaRuter().length; i++) {
				if(erLovlig(i) == true) {
					verdi = i;
					if(neste != null) {
						neste.fyllUt();
					}
					else {
						System.out.println("Fant losning");
						brett.fantLosning();
					}
				}
				verdi = 0;
			}
		}
	}

	
}

//subklasser for aa kunne skille om ruter er opptatte/ledige
class Opptatt extends Rute {
	Opptatt(int i) {
		super(i);
	}
}

class Ledig extends Rute {
	Ledig(int i) {
		super(i);
	}
}