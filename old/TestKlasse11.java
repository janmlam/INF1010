class TestKlasse11 {

    public static void main(String[] args) {
	
    	Lege lege1 = new Lege("a", 1207,"gate1",2312);
		LegemiddelAPille legemiddel1 = new LegemiddelAPille("ibux",100,50,10,2);
		Resept resept1 = new Resept(10,lege1,legemiddel1,1);

		Lege lege2 = new Lege("b", 1208,"gate2",2313);
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept2 = new Resept(11,lege2,legemiddel2,2);

		Lege lege3 = new Lege("c", 1209,"gate3",2316);
		LegemiddelAPille legemiddel3 = new LegemiddelAPille("ibux3",102,52,12,4);
		Resept resept3 = new Resept(12,lege3,legemiddel3,3);


    	YngsteForsteReseptListe beholder2 = new YngsteForsteReseptListe();
		beholder2.settInn(resept1);	
		beholder2.settInn(resept2);
		beholder2.settInn(resept3);
		System.out.println(beholder2.finnResept(0));
		System.out.println(beholder2.finnResept(1));
		System.out.println(beholder2.finnResept(2));


		for(Resept r:beholder2){
		    System.out.println(r.giNummer());
		}
	}
}
