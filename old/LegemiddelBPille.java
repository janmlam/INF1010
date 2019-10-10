class LegemiddelBPille extends Legemiddel implements Pille{

    private int antall;
    private int vanedannende;
    private int virkestoff;

    LegemiddelBPille(String navn, int pris, int virkestoff,int antall, int vanedannende){
	super(navn,pris);
	this.virkestoff = virkestoff;
	this.antall = antall;
	this.vanedannende = vanedannende;
    }
    

    public int giAntall(){
	return antall;
    }

    public int giVirkestoff(){
	return virkestoff;
    }
}
