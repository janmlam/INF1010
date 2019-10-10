//creating a class, Mus
class Mus { 

	//creating private variables 
	private String navn;
	private int antMus;
	private boolean syk;
	private boolean lever = true;
	private int vekt;

	//constructor Mus which takes vekt, and lever as parameters, then gives numbers to each mus
	public Mus(int vekt, boolean lever) {
		antMus = antMus + 1;
		this.vekt = vekt;
		this.syk = syk;
		navn = "Mus nr:" + antMus;
		
	}

	//method to inflict dead as a status for mus
	public void kill(boolean status) {
		this.lever = status;
	}

	//method to inflict syk as a status for mus
	public void syk(boolean status) {
		this.syk = status;
	}

	//method sjekktilstand which takes 5 parameters, and printing all these values 
	public void sjekktilstand (String testid, String navn, boolean syk, int vekt, boolean lever) {
		System.out.println("********* Test av musobjekt, testid:" + testid + " ***");
	    System.out.println("** navn: " + navn + ", OK.");
	    System.out.println("** syk: " + syk + ", OK.");
	    System.out.println("** vekt: " + vekt + ", OK");
	    System.out.println("** lever: " + lever + ", OK");
	}

	//method to print the current status of mus
	public void infoOmTilstand(String testid) {
		System.out.println("---" + testid + "--- Info om mus: navn: " + navn + ", vekt: " + vekt + ", syk: " + syk + ", lever: " + lever);
	}

	//get methods to call the private variables
	public Boolean syk() {
		return syk;
	}
	public int vekt() {
		return vekt;
	}
	public Boolean lever() {
		return lever;
	}
}
