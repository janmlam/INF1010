class TestTabell {

    public static void main(String[] args) { 

    	int metodeFeil = 0;

    	Lege lege1 = new Lege("a");
		LegemiddelAPille legemiddel1 = new LegemiddelAPille("ibux",100,50,10,2);
		Resept resept0 = new Resept(10,lege1,legemiddel1,1);

		Lege lege2 = new Lege("b");
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept1 = new Resept(11,lege2,legemiddel2,2);

		Lege lege3 = new Lege("c");
		LegemiddelAPille legemiddel3 = new LegemiddelAPille("ibux3",102,52,12,4);
		Resept resept2 = new Resept(12,lege3,legemiddel3,3);

		Tabell<Resept> tabell1 = new Tabell<Resept>(5);


		Resept test1 = tabell1.finn(0);
		System.out.println("Sjekker index 0. Forventer null. Resultat: " + test1);
		if (test1 != null) {
			System.out.println("Forventet verdi != resultatverdi.");
			metodeFeil++;
		}

		boolean test2 = tabell1.settInn(resept2,0);
		System.out.println("Sjekker om det er sukesss når man putter inn element."+
			" forventer true. Resultet: " + test2);
		if(test2 != true) {
			System.out.println("Forventet verdi != resultatverdi.");
			metodeFeil++;
		}

		//??
		tabell1.skrivUt();
    }
}
