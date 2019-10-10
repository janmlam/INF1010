class LegemiddelCPille extends Legemiddel implements Pille{

    private int antall;
    private int virkestoff;

    LegemiddelCPille(String navn, int pris, int virkestoff,int storrelse){
	   super(navn,pris);
	   this.antall = antall;
    }
    

    public int giAntall(){
	   return antall;
    }

    public int giVirkestoff(){
	   return virkestoff;
    }
    
}
