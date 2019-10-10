//pilleform av medisin A. den implementerer legemiddel og mikstur
class LegemiddelAMikstur extends Legemiddel implements Mikstur{

    private int storrelse;
    private int narkotisk;
    private int virkestoff;

    //konstruktor for å anngi egenskaper
    LegemiddelAMikstur(String navn, int pris, int virkestoff,int storrelse,int narkotisk){
	super(navn,pris);
	
	this.storrelse = storrelse;
	this.narkotisk = narkotisk;
    }

    public int giStorrelse(){
	return storrelse;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
}
