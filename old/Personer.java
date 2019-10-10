class Personer {

    private String navn;
    private int fNummer;
    private String addresse;
    private int pNummer;

    private static int nummer;

    Personer(String navn,int fNummer,String addresse,int pNummer){

	this.navn = navn;
	this.fNummer = fNummer;
	this.addresse = addresse;
	this.pNummer = pNummer;
	oekNummer();
    }

    public String giNavn(){
	return navn;
    }

    public int GiFNummer(){
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
