class musikk { 
	public static void main (String[] args) { 
		MedicineA qwe = new MedicineA("qwe", 100, 2, 1, "Liquid", 1, 16);
		MedicineB zxc = new MedicineB("zxc", 200, 3, 2, "Pills", 2, 18);
		Person a = new Person("a", "gt1 2316", "27019537787");
		Person b = new Person("b", "gt2", "23099612345");
		Doctor hans = new Doctor("hans");
		Doctor nils = new Doctor("nils");
		nils.townNumber(1234);

		PrescriptionWhite lol = new PrescriptionWhite(qwe, nils, b.number, 6, 100);
		PrescriptionBlue asd = new PrescriptionBlue(zxc, hans, a.number, 7);

		EnkelReseptListe beholder = new EnkelReseptListe();
		beholder.settInn(asd);
		beholder.settInn(lol);
		System.out.println(beholder.finn(2));
		beholder.finn(3);
	//	System.out.println(beholder.finn(1));

		
 	} 
} 