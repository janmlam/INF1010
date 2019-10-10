//subklasse fastlege av hovedklassen lege, fastlege har også kommuneavtale
class FastLege extends Lege implements KommuneAvtale{

    int avtaleNummer;

    //konstruktoer som angir de spesielle egenskapene til fastlege
   FastLege(String navn,int fNummer,String addresse,int pNummer,int avtaleNummer){
	super(navn,fNummer,addresse,pNummer);
	this.avtaleNummer = avtaleNummer;
    }

    //metode som gir avtalenummer til legen
    public int giAvtaleNummer(){
	return avtaleNummer;
    }
}
