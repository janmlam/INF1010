class TestEldst { 
    public static void main (String[] args) {

    	int metodeFeil = 0;
    	int iteratorFeil = 0;

		Lege lege1 = new Lege("a");
		LegemiddelAPille legemiddel1 = new LegemiddelAPille("ibux",100,50,10,2);
		Resept resept0 = new Resept(10,lege1,legemiddel1,1);

		Lege lege2 = new Lege("b");
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept1 = new Resept(11,lege2,legemiddel2,2);

		Lege lege3 = new Lege("c");
		LegemiddelAPille legemiddel3 = new LegemiddelAPille("ibux3",102,52,12,4);
		Resept resept2 = new Resept(12,lege3,legemiddel3,3);

		EldsteForsteReseptListe beholder1 = new EldsteForsteReseptListe();
		Resept test1 = beholder1.finnResept(0);
		System.out.println("Sjekker index 0. Forventer null. Resultat: " + test1);
		if (test1 != null) {
			System.out.println("Forventet verdi != resultatverdi.");
			metodeFeil++;
		}


		beholder1.settInn(resept0);	
		beholder1.settInn(resept1);
		beholder1.settInn(resept2);
		int test2 = beholder1.finnResept(0).giNummer();
		System.out.println("Legger inn resept med nr. 0-2 i beholder, og sjekker om vi finner"
		+"riktig resept nr i beholderen. Forventer 0. Resultat: "+ test2);
		if (test2 != 0) {
			System.out.println("Forventet verdi != resultatverdi");
			metodeFeil++;
		}

		System.out.println("Tester iterator. Rekkfoelgen på reseptnr. skal vere 0 1 2");
		int i = 0;
		for(Resept r:beholder1){
			if(beholder1.finnResept(i).giNummer() != r.giNummer()) {
				iteratorFeil++;
			}
		    System.out.println(r.giNummer());
		    i++;
		}

		int sum = iteratorFeil + metodeFeil;
		System.out.println("Total feil: " + sum + "hvor "+ iteratorFeil + "var iteratorfeil"+
			"og " + metodeFeil + "var metodefeil");
    }
}
