//klasse resept med gitte egenskaper fra opp. tekst
class Resept{

    protected static int nummer = 0;
    private int reit;
    
    private Lege lege;
    private Legemiddel legemiddel;
    private int eierNummer;
    private int reseptNummer;

    private int pris = 10;

    //konstruktoer som angir egenskapene til objektet
    Resept(int reit,Lege lege,Legemiddel legemiddel, int eierNummer){ // setter inn eier.giNummer(); naar man lager Resepten
    	this.reit = reit;
    	this.lege = lege;
    	this.legemiddel = legemiddel;
    	this.eierNummer = eierNummer;
    	this.reseptNummer = nummer;
    	oekNummer();
    }

    //en metode for å øke nummeret på resept
    public void oekNummer(){
	   this.nummer++;
    }

    //get/set metoder for å få/endre på verdi
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
