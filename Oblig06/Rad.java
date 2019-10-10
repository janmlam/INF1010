//klasse kolonne
class Rad {
	Rute[] ruter;

	//konstruktor som angir rute
	Rad(Rute[] ru) {
		this.ruter = ru;
	}
	
	//metode som returnerer ruter
	public Rute[] faaRuter() {
		return ruter;
	}

	//metode som sjekker om oppgitt tall, i
	//er lovlig i denne kolonnen
	public Boolean lovligVerdi(int i) {
		for(Rute ru: ruter) {
			if(ru.faaVerdi() == i) {
				return false;
			}
		}
		return true;
	}

	//setter inn ruter i Kolonne
	public void giRuter(Brett b) {
		for(Rute ru: ruter) {
			ru.settInnRad(this, b);
		}
	}
}