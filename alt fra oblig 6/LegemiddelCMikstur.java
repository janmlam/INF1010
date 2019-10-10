//miksturform av medisin C. den implementerer legemiddel og mikstur
class LegemiddelCMikstur extends Legemiddel implements Mikstur{

    private int storrelse;
    private int virkestoff;

    //konstruktor for å anngi egenskaper
    LegemiddelCMikstur(String navn, int pris, int virkestoff,int storrelse){
	super(navn,pris);
	
	this.storrelse = storrelse;
    }


    //get metoder
    public int giStorrelse(){
	return storrelse;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
    
}
