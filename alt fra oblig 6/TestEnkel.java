//testklasse for enkel sorteringsliste, tester iterering og metoder
class TestEnkel {

    public static void main(String[] args) { 

		int metodeFeil = 0;

		Lege lege1 = new Lege("ali2");
		LegemiddelAPille legemiddel1 = new LegemiddelAPille("ibux",100,50,10,2);
		Resept resept0 = new Resept(10,lege1,legemiddel1,1);

		Lege lege2 = new Lege("truls1");
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept1 = new Resept(11,lege2,legemiddel2,2);

		Lege lege3 = new Lege("simen3");
		LegemiddelAPille legemiddel3 = new LegemiddelAPille("ibux3",102,52,12,4);
		Resept resept2 = new Resept(12,lege3,legemiddel3,3);

		Lege lege4 = new Lege("tom4");
		Lege lege5 = new Lege("a");

		SortertEnkelListe2<Lege> liste = new SortertEnkelListe2<Lege>();
		liste.settInn(lege1);
		liste.settInn(lege3);
		liste.settInn(lege5);
		liste.settInn(lege4);
		liste.settInn(lege2);




		Lege test1 = liste.finn("simen3");
		System.out.println("Tester finn metode. Forventer Lege object. Resultat: "+ test1);
		if(test1 == null || test1 != lege3) {
			System.out.println("Forventet verdi != resultatverdi");
			metodeFeil++;
		}

		Lege test2 = liste.finn("ali2");
		System.out.println("Tester finn metode. Forventer Lege object. Resultat: "+ test2);
		if(test2 == null || test2 != lege1) {
			System.out.println("Forventet verdi != resultatverdi");
			metodeFeil++;
		}

		Lege test3 = liste.finn("y");
		System.out.println("Tester finn metode. Forventer null. Resultat: "+ test3);
		if(test3 != null) {	
			System.out.println("Forventet verdi != resultatverdi");
			metodeFeil++;
		}

		for(Lege l:liste) {
		    System.out.println(l.navn);
		}
    }
}
