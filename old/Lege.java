class Lege implements Lik,Comparable<String>{

    String navn;
    
    Lege(String navn){
		this.navn = navn;
    }

    public boolean samme(String navn){

		if(this.navn == navn){
		    return true;
		}
		else{
		    return false;
		}
    }

    public int compareTo(String s){
		return navn.compareTo(s);
    }
}
