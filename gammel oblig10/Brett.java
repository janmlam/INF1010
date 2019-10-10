import java.util.Scanner;
import java.io.*;

class Brett {

	private int r;
	private int k;
	
	Rute[] brettet;
	Boks[] bokser;
	Rad[] rader;
	Kolonne[] kolonner;
	Rute[][] brettet2;
	Rute[] brettet3;
	String[][] ruteArray;
	SudokuBeholder beholder;

	Brett(SudokuBeholder sb) {

	}

	public Boolean legalValue(String i) {
		for(Rute s: brettet3) {
			System.out.println(i+" matches med " +s.getVerdi());
			if((s.getVerdi()).equals(i)) {
				System.out.println("tuturu");
				return false;
			}
		}
		return true;
	}
	
	public void delInnRuter() {
		int str = (r*k);

		int teller = 0;
		while(teller<r*k) {
			bokser[teller] = new Boks(r*k, teller+1);
			kolonner[teller] = new Kolonne(r*k, teller+1);
			rader[teller] = new Rad(r*k, teller+1);
			teller++;
		}

		brettet3 = new Rute[str*str];
		String verdi;
		int teller4 = 0;
		int boksTeller = 0;
		for(int i=0; i<(str); i++) { 
			for(int j=0; j<(str); j++) { 
				verdi = ruteArray[i][j];
				brettet3[teller4] = new Rute(kolonner[j], rader[i], bokser[boksTeller], verdi, (teller4+1));
				if(teller4 != 0) {
					brettet3[(teller4-1)].giNeste(brettet3[teller4]);
				}

				kolonner[j].giVerdi(verdi);
				rader[i].giVerdi(verdi);
				bokser[boksTeller].giVerdi(verdi);

				teller4++;

				if((j+1)%k == 0) {
					boksTeller++;
				}
				if((i+1)%r==0 && j==(str-1)) {
					boksTeller = boksTeller+(str/k);
				}
			}
			boksTeller = boksTeller-(str/k);
		}

		
		//brettet3[0].fyllUt();

		//System.out.println(brettet3[5].kol.kid);
		//System.out.println(brettet3[10].kol.kid);
		//System.out.println(brettet3[11].kol.kid);
		//System.out.println(brettet3[17].kol.kid);
		//System.out.println(brettet3[23].kol.kid);
		//System.out.println(brettet3[29].kol.kid);
		//printBrett();
		for(int i=0; i<brettet3.length; i++) {
			brettet3[i].hentArray(brettet3);
		}	
		brettet3[0].fyllUt();
	}

	

	public void printBrett() {
		for(int i=0; i<brettet3.length; i++) {
			System.out.print(brettet3[i].getVerdi());
			if((i+1)%(k*r)==0) {
				System.out.println();
			}
		}
	}

	public void lesFil(String s) throws Exception{
		Scanner sc = new Scanner(new File(s));

		this.r = Integer.parseInt(sc.nextLine());
		this.k = Integer.parseInt(sc.nextLine()); 

		bokser = new Boks[r*k];
		rader = new Rad[r*k];
		kolonner = new Kolonne[r*k];
		ruteArray = new String[r*k][r*k];

		brettet2 = new Rute[r*k][r*k]; 

		while(sc.hasNextLine()) {
			for(int i=0; i<(r*k); i++) {
				String[] line = sc.nextLine().split("");
				for(int j=0; j<(r*k); j++) {
					ruteArray[i][j] = line[j];
				}
			}
		}
	}

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
			kolArray = new Rute[str]
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
					for(int b=kolIndeks; b<kolIndeks+k; b++)
						boksArray[counter4] = ruter[a][b];
				}
			}
			bokser[j/k][i/r] = new Boks(boksArray);
		}

		//create pointers
		Rute[] ruteKeeper = new Rute[str*str];
		int counter2 = 0;
		for(int i=0; i<str; i++) {
			for(int j=0; j<str; j++) {
				ruteKeeper[counter2] = rute[i][j];
				if(counter2 != 0 ) {
					ruteKeeper[counter2-1].giNeste(ruteKeeper[counter2]); //lag setNext som giNeste
				}
				counter2++;
			}
		}

		//lag tellSquares som giRute
		for(Rad a: rader) {
			a.giRute(this);
		}

		for(Kol b: rader) {
			b.giRute(this);
		}

		for(int i=0; i<k; i++) {
			for(int j=0; j<r; j++) {
				bokser[j][i].giRute(this);
			}
		}
	}
}

