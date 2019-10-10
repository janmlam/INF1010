import java.util.Scanner;
import java.io.*;

class Brett {

	private int r;
	private int k;
	
	Rute[] brettet;
	Boks[] bokser = new Boks[123];
	Rad[] rader = new Rad[123];
	Kolonne[] kolonner = new Kolonne[123];


	public void delInnRuter() {
		
		int radTeller = 0;
		while(radTeller < r*k) {
			rader[radTeller] = new Rad(r*k);

			for(int i=0; i<(r*k); i++) {
				rader[radTeller].ruteInn(i, brettet[i][radTeller]);
				brettet[i][radTeller].rad((rader[radTeller]));
			}
			//rader[radTeller].printRad();
			radTeller++;
		}

		int kolTeller = 0;
		while(kolTeller < r*k) {
			kolonner[kolTeller] = new Kolonne(r*k);

			for(int i=0; i<(r*k); i++) {
				kolonner[kolTeller].ruteInn(i, brettet[kolTeller][i]);
				brettet[kolTeller][i].kol((kolonner[kolTeller]));
			}
			//kolonner[kolTeller].printKolonne();
			kolTeller++;
		}

		//brettet[0][0].finnAlleMuligeTall();

		
		int boks = 0;
		while(boks<r*k) {
			bokser[boks] = new Boks(r,k);
			boks++;
		}

		int teller = 0;
 		int teller2 = 0;
		for(int i= 0; i<(r*k); i++){//rad
	     
		    for(int j =0; j<(r*k); j++){//kolonne
				bokser[teller2].ruteInn(teller, brettet[i][j]);

				teller++;
					 
				if((j+1)%k == 0 && j != 0){
				    teller2++;
					     
				}
				if((i+1)%r == 0 && (j+1)%k == 0  && j==(r*k)-1){
				    teller2 = teller2 + ((r*k)/k);
				}
		    }
		    teller2 = teller2 - ((r*k)/k);
		}

		/*
		int teller = 0;
		int boksTeller = 0;

		for(int i= 0; i<((r*k)); i++){//kolonne
     		for(int j = 0; j < (r*k); j++){//rad
     			//System.out.println(i+" og "+j+" skal i boks "+(boksTeller));


				if(j%k==0 && j!=0){
					System.out.println(i+" and "+j+" skal i boks "+(boksTeller+k));
		    		teller++;     
		 		}
			 	if(i%r==0 && i!=0 && j==0){
			 		System.out.println(i+" og "+j+" skal i boks "+(boksTeller));
			    	teller = teller +k;
			 	}
			 	else {
			 		System.out.println(i+" heh "+j+" skal i boks "+(boksTeller));
			 	}
	     	}
	     	System.out.println();
	     	boksTeller = boksTeller+1;
	    	teller = teller - k;
 		}

 		*/



	}

	public void lesFil(String s) throws Exception{
		Scanner sc = new Scanner(new File(s));

		this.r = Integer.parseInt(sc.nextLine()); // 2
		this.k = Integer.parseInt(sc.nextLine()); // 3

		brettet = new Rute[r*k][r*k]; // 6x6

		for(int i=0; i<(r*k); i++) {
			String[] line = sc.nextLine().split(" ");
			for(int j=0; j<(r*k); j++) {
				if(line[j].equals(".")) {
					brettet[i][j] = new Rute();
					//System.out.print("ny rute "+brettet[i][j].getVerdi());
				}
				else {
					brettet[i][j] = new Rute(Integer.parseInt(line[j]));
					//System.out.print("ny rute "+brettet[i][j].getVerdi());
				}
			}
		}
	}

	public void printBrett() {
		for(int i=0; i<(r*k); i++) {
			for(int j=0; j<(r*k); j++) {
				System.out.print(brettet[i][j].getVerdi());
			}
			System.out.println();
		}
	}
}


