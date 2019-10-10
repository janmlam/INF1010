import java.util.*;
import java.io.*;


class Test {
	public static void main(String[] args) throws Exception {
		SudokuBeholder beholder = new SudokuBeholder();
		Brett brett = new Brett(beholder);
		brett.lesFraFil(args[0]);

		//sjekker antall "ord" ble oppgitt paa kommandolinjen
		//hvis 0, saa blir det feil
		if(args.length == 0) {
			System.out.println("oppgi: filnavn som skal leses inn, evt. en utfilnavn. seperer med en space");
			System.exit(0);
		}
		//hvis 1, print til skjerm
		else if(args.length == 1) {
			brett.delInnIRuter();
			beholder.printLosning();
		}
		//hvis 2, skriv til fil
		else {
			brett.delInnIRuter();
			beholder.printToFil(args[1]);
		}
	}
}