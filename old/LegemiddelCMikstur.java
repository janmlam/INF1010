class LegemiddelCMikstur extends Legemiddel implements Mikstur{

    private int storrelse;
    private int virkestoff;

    LegemiddelCMikstur(String navn, int pris, int virkestoff,int storrelse){
	   super(navn,pris);
	   this.storrelse = storrelse;
    }


    public int giStorrelse(){
	   return storrelse;
    }

    public int giVirkestoff(){
	   return virkestoff;
    }
}
