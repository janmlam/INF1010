class Katt {
	private String navn;
	private int vekt;
	private int antMus;
	private boolean syk;

	//constructor which takes 3 parameters
	public Katt(String navn, int vekt, boolean syk) {
		this.navn = navn;
		this.vekt = vekt;
		this.syk = syk;
	}
	//another constructor with default value if the new object doesn't have 3 parameters
	public Katt(String navn) {
		this.navn = navn;
		this.vekt = 5000;
		this.syk = false;
	}

	//a method to to check if there's a mus in bol, sick, dead, also adding mus's weight to the katt's
	//and adding amount of mus in katt's stomach
	public Mus gaaPaaJaktI(Bol<Mus> a) {
		if (a.beboer() != null) {
			Mus x = a.taUt();
			if (x.lever() == true) {
				if (this.antMus < 2) {
					this.vekt += x.vekt();
					this.antMus++;
					if (x.syk() == true) {
						this.syk = true;
					}
					return null;
				}
				else {
					if (x.syk() == true) {
						x.kill(false);
					}
					else {
						x.syk(true);
					}
					return x;
				}
			}
		}
		return null;
	}

	//get methods
	public String navn() {
		return navn;
	}
	public int vekt() {
		return vekt;
	}
	public int antMus() {
		return antMus;
	}
	public Boolean syk() {
		return syk;
	}
}