class Legemiddel{

    private String navn;
    private static int nummer;
    private int pris;
    protected String type;

    Legemiddel(String navn, int pris){
	this.navn = navn;
	this.pris = pris;
	oekNummer();
    }

    public String giNavn(){
	   return navn;
    }

    public int giNummer(){
	   return nummer;
    }

    public int giPris(){
	   return pris;
    }

    public void oekNummer(){
    	nummer++;
    }

    public String giType(){
	   return type;
    }
}
