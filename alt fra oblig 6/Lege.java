//lege sim impleneterer grensesnittet lik og comparable
//den har egenskaper oppgitt i opp. tekst
class Lege implements Lik,Comparable<Lege>{

    String navn;
    
    //konstruktoer som angir egenskapen
    Lege(String navn){
	this.navn = navn;
    }

    //metoden samme som lovt i Lik
    public boolean samme(String navn){

	if(this.navn.equals(navn)){
	    return true;
	}
	else{
	    return false;
	}
	
    }

    //metoden compareTo som lovt i comparable
    public int compareTo(Lege l){
	return navn.compareTo(l.navn);
    }
}
