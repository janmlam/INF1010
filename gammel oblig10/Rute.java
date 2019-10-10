import java.util.Arrays;

class Rute {
	public int verdi;
	public String sVerdi;

	Rad rad;
	Kolonne kol;
	Boks boks;
	Rute[] brett;
	int teller;
	static int counter = 0;
	int tall;
	int i = 0;
	int keeper;
	Rute neste;



	public Rute(Kolonne kol, Rad rad, Boks boks, String verdi, int teller) {
		if(verdi.equals(".")) {
			this.sVerdi = verdi;
		}
		else {
			this.verdi = Integer.parseInt(verdi);
		}
		this.rad = rad;
		this.kol = kol;
		this.boks = boks;
		this.teller = teller;
		//System.out.print(rad.rid);
		//System.out.print(kol.kid);
		//System.out.println(boks.bid);
	}

	public Rute(String verdi) {
		if(verdi.equals(".")) {
			this.sVerdi = verdi;
		}
		else {
			this.verdi = Integer.parseInt(verdi);
		}
	}

	public void giNeste(Rute ru) {
		this.neste = ru;
	}

	public Boolean hasNext() {
		return neste != null;
	} 
	public String getVerdi() {
		if(sVerdi == null) {
			return Integer.toString(verdi);
		}
		else {
			return sVerdi;
		}
	}

	public void hentArray(Rute[] ruteBrett) {
		this.brett = ruteBrett;
	}

	public int[] finnAlleMuligeTall() {
		if(getVerdi().equals(".")) {
			int[] tall = new int[this.boks.str];

			for(int i=0; i<rad.r; i++) {
				tall[i] = (i+1);
			}
			
			int[] mBoks = addTogether(tall, (this.boks.tallArray));
			int[] mRad = addTogether(mBoks, (this.rad.tallArray));
			int[] done = addTogether(mRad, (this.kol.tallArray));
		
			Arrays.sort(done);
			/*
			for(int i=0; i<done.length; i++) {
				System.out.print(done[i]);
			}
			System.out.println();
			*/

			int sjekk = 1;
			int size = 0;
			int[] ferdig = new int[boks.str];

			while(sjekk<=(boks.str)) {
				int count = 0;
				for(int i=0; i<done.length; i++) {
					if(done[i] == sjekk) {
						count++;
					}
				}
				if(count==1) {
					ferdig = addElement(ferdig, sjekk);
					size++;
				}
				sjekk++;
			}			

			int j = 0;
		    for( int i=0;  i<ferdig.length;  i++ ) {
		        if (ferdig[i] != 0) {
		        	ferdig[j++] = ferdig[i];
		        }
		    }
		    int [] nyFerdig = new int[j];

		    System.arraycopy(ferdig, 0, nyFerdig, 0, j);
			return nyFerdig;
		}
		else {
			System.out.println("Ruten har en verdi ffs");	
			return null;
		}
	}

	public void fyllUt() {

		if((brett[counter].getVerdi()).equals(".")) {
			int[] ledigeTall = finnAlleMuligeTall();
			System.out.println(finnAlleMuligeTall());
			
			for(int i=0; i<ledigeTall.length; i++) {
				tall = ledigeTall[i];
				System.out.println("Setter inn tallet : "+tall);
				this.rad.radVerdier();
				this.rad.giTall(tall);
				this.rad.radVerdier();
				this.kol.giTall(tall);
				this.boks.giTall(tall);
			}
		}
		counter++;
	}
	/*
			if(neste != null) {
				this.neste.fyllUt();
			}
			else {
				return;
			}
	*/

	public int[] addTogether(int[] a, int[] b) {
	   int aLen = a.length;			
	   int bLen = b.length;
	   int[] c = new int[aLen+bLen];
	   System.arraycopy(a, 0, c, 0, aLen);
	   System.arraycopy(b, 0, c, aLen, bLen);
	   return c;			
	}

	public int[] addElement(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length+1);
	    a[a.length - 1] = e;
	    return a;
	}
}
/*

public void fyllUt() {	
		if(finnAlleMuligeTall() != null) {
			int[] ledig = finnAlleMuligeTall();
			if(!(brett[counter].getVerdi()).equals(".")) {
				counter++;
				brett[counter].fyllUt();
				
			}

			while(i<ledig.length && counter != brett.length) {
				tall = ledig[i];
				keeper = ledig[i];
				this.rad.giTall(tall);
				this.kol.giTall(tall);
				this.boks.giTall(tall);
				counter++;
				
				if(counter == brett.length) {
					System.out.println("Counter == brettlengden");
					return;
				}
				else {
					brett[counter].fyllUt();	
				}
			}
		}
	}



	public void fyllUt() {
		if(finnAlleMuligeTall() != null) {
			int[] ledige = finnAlleMuligeTall();
			System.out.println("Starten av fyllUt counter: "+counter+" brettlengde: "+brett.length);
			System.out.println();
			if(counter == brett.length) {
				System.out.println("Counter "+counter+"=="+" brettlengde "+brett.length);
				return;
			}
			if(!(brett[counter].getVerdi()).equals(".")) {
				counter++;
				brett[counter].fyllUt();
			}
			else {
				while(i<ledige.length) {
					tall = ledige[i];

					
					System.out.println();
					System.out.println("sjekker om tall er i rad array");
					if(dupliRad((this.rad.tallArray), tall) == false) {
						System.out.println("Ja, tall er i rad, fjerener");
						System.out.println();
						this.rad.giTall(tall);
						this.rad.fjernTall(tall);
						//return;
					}
					else {
						
					}

					System.out.println("sjekker om tall er i kol array");
					this.kol.giTall(tall);
					System.out.println();
					if(dupliKol((this.kol.tallArray), tall) == true) {
						System.out.println("Ja, tall er i kol, fjerener");
						System.out.println();
						this.kol.fjernTall(tall);
						//return;
					}

					System.out.println("sjekker om tall er i boks array");
					this.boks.giTall(tall);
					System.out.println();
					if(dupliBoks((this.boks.tallArray), tall) == true) {
						System.out.println("Ja, tall er i boks, fjerener");
						System.out.println();
						this.boks.fjernTall(tall);
						//return;
					}
					counter++;
					brett[counter].fyllUt();
				}
			}
		}
	}






	public void fyllUt() {	
		if(finnAlleMuligeTall() != null) {
			int[] ledig = finnAlleMuligeTall();
			if(!(brett[counter].getVerdi()).equals(".")) {
				counter++;
				brett[counter].fyllUt();
				
			}

			while(i<ledig.length && counter != brett.length) {
				tall = ledig[i];
				keeper = ledig[i];
				this.boks.giTall(tall);
				this.kol.giTall(tall);
				this.rad.giTall(tall);
				counter++;
				
				if(counter == brett.length) {
					System.out.println("Counter == brettlengden");
					return;
				}
				else {
					brett[counter].fyllUt();	
				}
			}
		}
	}











*/