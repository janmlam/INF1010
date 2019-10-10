//hvit resept som extender hovedklassen resept
class HvitResept extends Resept{

	//konstrukoer som legger til de spesielle egenskapene til hvitresept
    HvitResept(int reit,Lege lege,Legemiddel legemiddel, int eierNummer){
	super(reit,lege,legemiddel,eierNummer);
    }
    
}
