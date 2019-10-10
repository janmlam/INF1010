import java.util.*;
import java.io.*;

//brett som har inneholder alt...
class Brett {
	Rute[][] ruter;
	Boks[][] bokser;
	Rad[] rader;
	Kolonne[] kolonner;
	SudokuBeholder beholder;
	int str, r, k;

	//en konstrukor som angir beholder
	Brett(SudokuBeholder sb){
		this.beholder = sb;
	}

	//leser inn fil, angir ruteverdier, setter 0 for opptatte
	//angir storrelser osv.
	public void lesFraFil(String filnavn) throws Exception {
		Scanner sc = new Scanner(new File(filnavn));

		this.r = Integer.parseInt(sc.nextLine());
		this.k = Integer.parseInt(sc.nextLine()); 
		this.str = r*k;
		this.bokser = new Boks[r][k];
		this.rader = new Rad[str];
		this.kolonner = new Kolonne[str];
		this.ruter = new Rute[str][str];

		while(sc.hasNextLine()) {
			for(int i=0; i<(r*k); i++) {
				String[] line = sc.nextLine().split("");
				for(int j=0; j<(r*k); j++) {
					if(line[j].equals(".")) {
						//i tillegg til aa gi verdier gir vi hver rute "egenskapen"
						//opptatt eller ledig, som er subclass av Rute
						ruter[i][j] = new Ledig(0);
					}
					else {
						ruter[i][j] = new Opptatt(Integer.parseInt(line[j]));
					}
				}
			}
		}
	}

	//metode som gir str for aa bruke andre steder
	public int giStr() {
		return this.str;
	}

	//en annen konstrukor som lager et brett
	//med losning og riktige dimensjoner
	//naar en losning er funnet blir det laget
	//et nytt brett med denne konstruktor
	Brett(Rute[][] ru, int r, int k) {
		this.ruter = ru;
		this.r = r;
		this.k = k;
		this.str = r*k;
		this.bokser = new Boks[r][k];
		this.rader = new Rad[str];
		this.kolonner = new Kolonne[str];
	}
	
	//en metode som gir brettes ruter
	public Rute[][] faaRuter() {
		return ruter;
	}

	//metode som printer prett til skjerm
	public void printBrett() {
		for(int i=0; i<str; i++) {
			for(int j=0; j<(str); j++) {
				System.out.print(ruter[i][j].faaVerdi());
			}
			System.out.println();
		}
	}

	//metode som lager pekere, og setter ting
	//i riktig boks/kolonne/rad
	public void delInnIRuter() {
		for(int i=0; i<ruter.length; i++) {
			rader[i] = new Rad(ruter[i]);
		}

		Rute[] kolArray = new Rute[str];
		for(int i=0; i<str; i++) {
			for(int rad=0; rad<str; rad++) {
				kolArray[rad] = ruter[rad][i];
			}
			kolonner[i] = new Kolonne(kolArray);
			kolArray = new Rute[str];
		}

		Rute[] boksArray;
		int counter4;

		for(int i=0; i<str; i=i+r) {
			for(int j=0; j<str; j=j+k) {
				counter4 = 0;
				boksArray = new Rute[str];
				int radIndeks = (i/r)*r;
				int kolIndeks = (j/k)*k;

				for(int a=radIndeks; a<radIndeks+r; a++) {
					for(int b=kolIndeks; b<kolIndeks+k; b++) {
						boksArray[counter4] = ruter[a][b];
						counter4++;
					}
				}
				bokser[j/k][i/r] = new Boks(boksArray);
			}
		}

		//lager neste pekere
		Rute[] ruteKeeper = new Rute[str*str];
		int counter2 = 0;
		for(int i=0; i<str; i++) {
			for(int j=0; j<str; j++) {
				ruteKeeper[counter2] = ruter[i][j];
				if(counter2 != 0 ) {
					ruteKeeper[counter2-1].setNeste(ruteKeeper[counter2]); //lag setNext som giNeste
				}
				counter2++;
			}
		}

		//hver rad/kolonne/boks faar ruter
		for(Rad a: rader) {
			a.giRuter(this);
		}

		for(Kolonne b: kolonner) {
			b.giRuter(this);
		}

		for (int i=0; i<k; i++) {
		    for (int j=0; j<r; j++) {
				bokser[j][i].giRuter(this);
		    }
		}

		
		//ruter[2][0].finnAlleMuligeTall();
		//starter fyllUt-metoden
		ruter[0][0].fyllUt();
	}

	//en metode som legger funnet losning til beholder
	public void fantLosning() {
		//printBrett();
		Rute[][] ruterKopi = new Rute[str][str];

		for(int i=0; i<str; i++) {
			for(int j=0; j<str; j++) {
				ruterKopi[j][i] = new Opptatt(ruter[j][i].faaVerdi());
			}
		}
		Brett losning = new Brett(ruterKopi, r, k);

		beholder.settInn(losning);
	} 
}