//klassen person med egenskaper gitt i opp. tekst
class Personer {

    private String navn;
    private String fNummer;
    private String addresse;
    private int pNummer;

    private static int nummer;

    //konstruktoer som angir egenskapene til objektet
    Personer(String navn,String fNummer,String addresse,int pNummer){

	this.navn = navn;
	this.fNummer = fNummer;
	this.addresse = addresse;
	this.pNummer = pNummer;
	oekNummer();
    }

    //get metoder for å få verdi
    public String giNavn(){
	return navn;
    }

    public String GiFNummer(){
	return fNummer;
    }

    public String giAddresse(){
	return addresse;
    }

    public int giPNummer(){
	return pNummer;
    }

    public int giNummer(){
	return nummer;
    }

    public void oekNummer(){
	nummer++;
    }
}
