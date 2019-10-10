//pilleform av medisin B. den implementerer legemiddel og pille
class LegemiddelBPille extends Legemiddel implements Pille{

    private int antall;
    private int vanedannende;
    private int virkestoff;
    //konstruktor for å anngi egenskaper
    LegemiddelBPille(String navn, int pris, int virkestoff,int antall, int vanedannende){
	super(navn,pris);
	this.virkestoff = virkestoff;
	this.antall = antall;
	this.vanedannende = vanedannende;
    }
    

    //get metoder
    public int giAntall(){
	return antall;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
}
