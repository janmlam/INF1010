import java.util.Scanner;
import java.io.*;

class HovedKlasse{

    public static void main(String[] args)throws Exception {
	int antall = 0;
	Person[] personArray = new Person[100];

	Scanner in = new Scanner(System.in);
	PrintWriter writer = new PrintWriter("dvdarkiv.txt");

	//lager en kommando loekke
	while(true){
	    System.out.print("Kommandoloekke");
	    System.out.print("(A)vslutt");
	    System.out.print("(K)joep");
	    System.out.print("(L)aan");
	    System.out.print("(N)y");
	    System.out.print("(O)versikt");
	    System.out.print("(R)eturner");
	    System.out.println("(V)is  (*) for alle");
	    System.out.println("Skriv inn Kommando: ");
	    String kommando = in.nextLine();


	    if(kommando.startsWith("A")){
		String[] dvdArray = new String[100];
		for(int i = 0; i < antall; i++){
		    dvdArray = personArray[i].sendDvder();
		    writer.println(personArray[i].toString());
		    for(int j = 0; j < personArray[i].eide()+1;j++){
			if(dvdArray[j] == null){
			    break;
			}
			writer.println(dvdArray[j]);
		    }
		    writer.println("");
		}
		writer.close();
		break;
	    }


	    //hvis kommandoen er K, kjoeper en dvd til en person
	    else if(kommando.startsWith("K")){
		System.out.println("Hvem har kjoept DVDen?");
		String navn = in.nextLine();
		System.out.println("Hva heter DVDen?");
		String dvd = in.nextLine();

		//lager en loop som hopper ut hvis personen finnes.
		boolean sannhet = true;
		outer: while(sannhet){
		    for(int i = 0; i < antall; i++){
			if(navn.equalsIgnoreCase(personArray[i].toString())){
			    personArray[i].kjoepDvd(dvd,personArray[i]);
			    break outer;
			}
		    }
		    sannhet = false;
		}
	    }
   


	    //lager en metode for aa laane bort en dvd
	    else if(kommando.startsWith("L")){
		System.out.println("Hvem vil laane DVDen?");
		String laaner = in.nextLine();
		System.out.println("Hvem vil " + laaner + " laane av?");
		String utLaaner = in.nextLine();
		System.out.println("Hvilken dvd vil du laane?");
		String dvd = in.nextLine();

		int utLaanerPlass = 0;
		int laanerPlass = 0;
		boolean sannhet = true;

		//lager to lÃ¸kker for Ã¥ sjekke personenes posisjon i arrayen
		for(int i = 0; i < antall; i++){
		    if(laaner.equalsIgnoreCase(personArray[i].toString())){
			laanerPlass = i;
		    }
		}
		for(int j = 0; j < antall; j++){
		    if(utLaaner.equalsIgnoreCase(personArray[j].toString())){
			utLaanerPlass = j;
		    }
		}
		    
		    
		//gjoer en sannhetssjekk for ulike feil som kan opstaa
		

		if(laaner.equalsIgnoreCase(utLaaner)){
		    System.out.println("Du kan ikke laane av deg selv!");
		    sannhet = false;
		}

		else if(!personArray[utLaanerPlass].eierJeg(dvd)){
		    System.out.println("Denne personen eier ikke Dvden!");
		    sannhet = false;
		}
		else if(personArray[laanerPlass].eierJeg(dvd)){
		    System.out.println("Denne personen eier ikke Dvden!");
		    sannhet = false;
		}
		else if(personArray[utLaanerPlass].laanerJegUt(dvd)){
		    System.out.println("Denne Dvden er allerede laant ut!");
		    sannhet = false;
		}

		if(sannhet){
		    for(int i = 0; i < antall; i++){
			if(utLaaner.equalsIgnoreCase(personArray[i].toString())){
			    sannhet = true;
			    break;
			}
			sannhet = false;
		    }
		}

		//hvis alt er greit laan Dvden
		if(sannhet){
		    personArray[laanerPlass].laanDvd(dvd,personArray[laanerPlass]);
		    personArray[utLaanerPlass].laanUtDvd(dvd,personArray[laanerPlass]);
		}

	    }


	    //legger til en ny person i arrayen
	    else if(kommando.startsWith("N")){

		boolean sannhet = true;
		
		System.out.println("Hva heter den nye personen?");
		String nyttNavn = in.nextLine();

		if(antall == 0){
		    Person p = new Person(nyttNavn);
		    personArray[antall] = p;
		    antall++;  
		}
		else{
		    outer: while(sannhet){
			for(int i = 0; i < antall; i++){
			    if(nyttNavn.equalsIgnoreCase(personArray[i].toString())){
				System.out.println("denne personen finnes allerede");
				break outer;
			    }
			    sannhet = false;
			}
			Person p = new Person(nyttNavn);
			personArray[antall] = p;
			antall++;
		    }
		}

	    }
	    
	    //gir en skrivtlig oversikt over alle personen og deres laant, utlaante og eide Dvder
	    else if(kommando.startsWith("O")){
		for(int i = 0; i < antall; i++){
		    System.out.print(personArray[i].toString() + " eier " + personArray[i].giAntall() + " DVDer, har laant ut  "); 
		    System.out.println(personArray[i].giUtLaant() + " og har laant " + personArray[i].giLaant());
		    
		}

	    }
	    //returner en dvd tilbake til personen som eier den.
	    else if(kommando.startsWith("R")){

		boolean sannhet = true;
		
		System.out.println("Hvem vil levere tilbake Dvd?");
		String laaner = in.nextLine();
		System.out.println("Hvem vil du gi tilbake til?");//spoer etter hvem personen har laant den av!
		String utLaaner = in.nextLine();
		System.out.println("Hvilken Dvd vil du levere tilbake?");
		String dvd = in.nextLine();

		int laanerPlass = 0;
		int utLaanerPlass = 0;
		//sjekker hvor i arrayen personene er
		for(int i = 0; i < antall; i++){
		    if(laaner.equalsIgnoreCase(personArray[i].toString())){
			laanerPlass = i;
		    }
		}
		for(int j = 0; j < antall; j++){
		    if(utLaaner.equalsIgnoreCase(personArray[j].toString())){
			utLaanerPlass = j;
		    }
		}
		//sjekker om personen laaner ut dvden
		if(!personArray[utLaanerPlass].laanerJegUt(dvd)){
		    System.out.println("Denne personen laaner ikke ut Dvden!");
		    sannhet = false;
		}
		//hvis alt greit, returnerer Dvden
		if(sannhet){
		    personArray[laanerPlass].giTilbake(dvd);
		    personArray[utLaanerPlass].faaTilbake(dvd);
		}	    	
	    }
	    
	    else if(kommando.startsWith("V")){

		int navnePlass = 0;
		
		System.out.println("Hvem vil du se oversikt over?");
		String navn = in.nextLine();
		
		for(int i = 0; i <antall; i++){
		    if(navn.equalsIgnoreCase(personArray[i].toString())){
			navnePlass = i;	
		    }   
		}
		//hvis * skriver ut informasjon om alle
		if(navn.equals("*")){
		    for(int j = 0; j < antall; j++)  {
			String person = personArray[j].toString() ;
			System.out.println(person);
			personArray[j].visDvder() ;
			System.out.println("");
		    }		    
		}
		else{
		    System.out.println("");
		    personArray[navnePlass].visDvder();
		}
	    }
	}
    }
}


