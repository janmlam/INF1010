import java.util.Scanner;
import java.io.*;

class Program {
	public static void main(String[] agrs) throws Exception {
		
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("Bruk store bokstaver for å angi kommando:");
			System.out.println("(F)il innlesing.");
			System.out.println("(A)vslutt.");
			System.out.println("(P)rint beholdere.");
			String kommando = in.nextLine();
			Tabell<Personer> tabell = new Tabell<Personer>(10);
			EldsteForsteReseptListe beholder1 = new EldsteForsteReseptListe();
			SortertEnkelListe2<Lege> liste = new SortertEnkelListe2<Lege>();
			YngsteForsteReseptListe beholder2 = new YngsteForsteReseptListe();

			if(kommando.startsWith("F")){
				System.out.println("Skriv filnavn som skal lese:");
				String fileName = in.nextLine();
				File file = new File(fileName);
				Scanner scannerino = new Scanner(file);
				int lines = amountLines(fileName);
				int number = 0;
				int phase = 0;

				while(number < lines) {
					while(scannerino.hasNextLine()) {
						String readLine = scannerino.nextLine();
						if(readLine.startsWith("#")){
							phase++;
							lines++;
							break;
						}
						if(phase == 1) {
							if(readLine.trim().length() == 0) {
								lines++;
								break;
							}
							String[] line = readLine.split(", ");
							Personer person = new Personer(line[1], line[2], line[3], Integer.parseInt(line[4]));
							tabell.settInn(person,Integer.parseInt(line[0]));

						}
						if(phase == 2) {
							if(readLine.trim().length() == 0) {
								lines++;
								break;
							}
							String[] line = readLine.split(", ");
							Legemiddel = new Legemiddel(line[1], line[2], line[3], Integer.parseInt(line[4]));
							tabell.settInn(person,Integer.parseInt(line[0]));
						}
						if(phase == 3) {
							if(readLine.trim().length() == 0) {
								lines++;
								break;
							}
							System.out.println(readLine);
						}
						if(phase == 4) {
							if(readLine.trim().length() == 0) {
								lines++;
								break;	
							}
							System.out.println(readLine);
						}

					}
					number++;
				}
			}
			if(kommando.startsWith("A")) {
				break;
			}
			if(kommando.startsWith("P")) {
				for(Personer p:tabell) {
					System.out.println("123");	
				}
				for(Resept r:beholder1) {
					System.out.println(r);
				}
				for(Resept r:beholder2) {
					System.out.println(r);
				}
		    	for(Lege l:liste) {
				    System.out.println(l.navn);
				}
			}
		}

	}

	public static int amountLines(String readIn) {
		int count = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(readIn));
			while (br.readLine() != null) {
				count++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}