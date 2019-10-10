//blaa resept av hovedklassen resept
//den har en konstrukoer som angir de spesielle egenskapene til blaa resept
class BlaaResept extends Resept{

    private int pris = 0;
    
    BlaaResept(int reit,Lege lege,Legemiddel legemiddel, int eierNummer){
	super(reit,lege,legemiddel,eierNummer);
    }
}
