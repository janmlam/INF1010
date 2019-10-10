abstract class Bil {
	private String regNr;

	Bil(String regNr) {
		if(regNr.length() != 7) {
			this.regNr = regNr;
		}
		else{
			System.out.println("ERROR");
			System.exit(0);
		}
		
	}
}


abstract class Varebil extends Bil {
	Varebil(String regNr) {
		super(regNr);
	}
}

class Lastebil extends Varebil {
	Lastebil(String regNr) {
		super(regNr);
	}
}



abstract class Personbil extends Bil {
	Personbil(String regNr) {
		super(regNr);
	}
}

class Drosje extends Personbil {
	Drosje(String regNr) {
		super(regNr);
	}
}

class Privatbil extends Personbil {
	Privatbil(String regNr) {
		super(regNr);
	}
}