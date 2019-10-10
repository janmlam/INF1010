class LegemiddelBMikstur extends Legemiddel implements Mikstur{

    private int storrelse;
    private int vanedannende;
    private int virkestoff;

    LegemiddelBMikstur(String navn, int pris, int virkestoff,int storrelse,int vanedannende){
    	super(navn,pris);
    	this.storrelse = storrelse;
    	this.vanedannende = vanedannende;
    }
    

    public int giStorrelse(){
	   return storrelse;
    }

    public int giVirkestoff(){
	   return virkestoff;
    }
    
}
