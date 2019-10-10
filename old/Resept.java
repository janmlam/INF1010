class Resept{

    protected static int nummer = 0;
    private int reit;
    
    private Lege lege;
    private Legemiddel legemiddel;
    private int eierNummer;
    private int reseptNummer;

    private int pris = 10;

    Resept(int reit,Lege lege,Legemiddel legemiddel, int eierNummer){ // setter inn eier.giNummer(); naar man lager Resepten
    	this.reit = reit;
    	this.lege = lege;
    	this.legemiddel = legemiddel;
    	this.eierNummer = eierNummer;
    	this.reseptNummer = nummer;
    	oekNummer();
    }

    public void oekNummer(){
	   this.nummer++;
    }

    public int fjernReit(){
    	int nyReit = reit--;
    	return nyReit;
    }

    public int giNummer(){
	   return reseptNummer;
    }

    public int brukResept(){
	   return fjernReit();
    }

    public Lege giLege(){
	   return lege;
    }

    public Legemiddel giLegemiddel(){
	   return legemiddel;
    }

    public int giEierNummer(){
	   return eierNummer;
    }
}
