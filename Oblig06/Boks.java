//klasse boks
class Boks {
	Rute[] ruter;

	//konstruktor som angir ruter
	Boks(Rute[] ru) {
		this.ruter = ru;
	}

	public Rute[] faaRuter() {
		return ruter;
	}

	//sjekker om oppgitt verdi, i er lovlig
	//i denne boksen
	public Boolean lovligVerdi(int i) {
		for(Rute ru: ruter) {
			if(ru.faaVerdi() == i) {
				return false;
			}
		}
		return true;
	}

	//setter inn ruter
	public void giRuter(Brett b) {
		for(Rute ru: ruter) {
			ru.settInnBoks(this, b);
		}
	}
}