//pilleform av medisin C. den implementerer legemiddel og pille
class LegemiddelCPille extends Legemiddel implements Pille{

    private int antall;
    private int virkestoff;

    //konstruktor for å anngi egenskaper
    LegemiddelCPille(String navn, int pris, int virkestoff,int storrelse){
	super(navn,pris);
	
	this.antall = antall;
    }
    

    //get metoder
    public int giAntall(){
	return antall;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
    
}
