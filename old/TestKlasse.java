class TestKlasse { 
    public static void main (String[] args) {

		Lege lege1 = new Lege("a");
		LegemiddelAPille legemiddel1 = new LegemiddelAPille("ibux",100,50,10,2);
		Resept resept1 = new Resept(10,lege1,legemiddel1,1);

		Lege lege2 = new Lege("b");
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept2 = new Resept(11,lege2,legemiddel2,2);

		Lege lege3 = new Lege("c");
		LegemiddelAPille legemiddel3 = new LegemiddelAPille("ibux3",102,52,12,4);
		Resept resept3 = new Resept(12,lege3,legemiddel3,3);

		EldsteForsteReseptListe beholder1 = new EldsteForsteReseptListe();
		beholder1.settInn(resept1);	
		beholder1.settInn(resept2);
		beholder1.settInn(resept3);
		System.out.println(beholder1.finnResept(0));
		System.out.println(beholder1.finnResept(1));
		System.out.println(beholder1.finnResept(2));

		for(Resept r1:beholder1){
		    System.out.println(resept3.giNummer());
		    System.out.println(r1.giNummer());
		}
    }
}
