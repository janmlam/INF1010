//pilleform av medisin B. den implementerer legemiddel og mikstur
class LegemiddelBMikstur extends Legemiddel implements Mikstur{

    private int storrelse;
    private int vanedannende;
    private int virkestoff;

    //konstruktor for å anngi egenskaper
     LegemiddelBMikstur(String navn, int pris, int virkestoff,int storrelse,int vanedannende){
	super(navn,pris);
	
	this.storrelse = storrelse;
	this.vanedannende = vanedannende;
    }
    

    //get metoder
    public int giStorrelse(){
	return storrelse;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
    
}
