class FastLege extends Lege implements KommuneAvtale{

    int avtaleNummer;

   FastLege(String navn,int fNummer,String addresse,int pNummer,int avtaleNummer){
		super(navn,fNummer,addresse,pNummer);
		this.avtaleNummer = avtaleNummer;
    }

    public int giAvtaleNummer(){
		return avtaleNummer;
    }
}
