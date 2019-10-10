class TestEnkel {

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


    SortertEnkelListe<Resept> liste = new SortertEnkelListe<Resept>();
    liste.settInn(resept0);
    liste.settInn(resept1);
    liste.settInn(resept2);
    
}
