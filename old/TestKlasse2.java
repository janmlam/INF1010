class TestKlasse2 {

    public static void main(String[] args) { 

		Lege lege2 = new Lege("b");
		LegemiddelAPille legemiddel2 = new LegemiddelAPille("ibux2",101,51,11,3);
		Resept resept2 = new Resept(11,lege2,legemiddel2,2);

		Tabell tabell1 = new Tabell(10);

		tabell1.settInn(resept2,0);
		tabell1.finn(0);
		tabell1.skrivUt();
    }
}
