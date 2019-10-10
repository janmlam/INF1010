class LegemiddelAPille extends Legemiddel implements Pille{

    private int antall;
    private int narkotisk;
    private int virkestoff;

    LegemiddelAPille(String navn, int pris, int virkestoff,int antall, int narkotisk){
    	super(navn,pris);
    	this.virkestoff = virkestoff;
    	this.antall = antall;
    	this.narkotisk = narkotisk;
    }
    
    public int giAntall(){
	   return antall;
    }

    public int giVirkestoff(){
	   return virkestoff;
    }
}
