import java.util.*;
import java.io.*;

//beholder som har diverse metoder som 
//legger til, fjerner, printe/skrive ut
//losninger
class SudokuBeholder {
	//setter default 2500 mulige losninger
	Brett[] losninger = new Brett[2500];
	int counter = 0;


	//legger til en losning til array
	public void settInn(Brett losning) {
		for(int i=0; i<losninger.length; i++) {
			if(i==2500) {
				System.out.println(">2.5k losninger yo");
				break;
			}
			if(losninger[i] == null) {
				losninger[i] = losning;
				break;
			}
		}
	}

	//metode som ligner hasNext,
	//gjer saa vi finner fram alle losningene
	public Boolean harLosning() {
		for(int i=0; i<losninger.length; i++) {
			if(losninger[i] != null) {
				return true;
			}
		}
		return false;
	}


	//denne henter den nyeste arrayen, og fjernern
	public Brett taUt() {
		for(int i=0; i<losninger.length; i++) {
			if(losninger[i] != null) {
				return fjern(i);
			}
		}
		return null;
	}

	//fjern metode som brukes i taUt()
	public Brett fjern(int i) {
		Brett keeper = losninger[i];
		losninger[i] = null;
		return keeper;
	}

	//print losning til "skjerm"
	public void printLosning() {
    	Brett brett;
    	while(harLosning()) {
    	    brett = taUt();
    	    brett.printBrett();
    	}
	}

	//print til fil
	public void printToFil(String filnavn) throws Exception {
		PrintWriter printer = new PrintWriter(new FileWriter(filnavn));
		Rute[][] ruter;
		Brett brett;
		while(harLosning()) {
			brett = taUt();
			ruter = brett.faaRuter();
			for(int i=0; i<ruter.length; i++) {
				for(int j=0; j<ruter.length; j++) {
					printer.write(Integer.toString(brett.ruter[i][j].faaVerdi()));
				}
				printer.write("\n");
			}
		}
		printer.close();
	}
}