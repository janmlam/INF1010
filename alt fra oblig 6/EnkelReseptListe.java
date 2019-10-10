import java.util.*;

//enkelreseptliste som implementerer iterable
class EnkelReseptListe implements Iterable<Resept>{

	//node klasse
    protected class Node{
	Node neste;
	Resept obj;
	Node(Resept r){
	    obj = r;
	}
    }

    protected Node foran;
    protected Node bak;
    protected int antall;


    //lager klasse og metode for å iterere
    public Iterator<Resept> iterator(){
	return new LenkeListeIterator();
    }

    private class LenkeListeIterator implements Iterator<Resept>{

	int teller = 0;
	Node pekerTilNeste = foran;

	public boolean hasNext(){
	    return (teller < antall);
	}

	public void remove(){
	    
	}

	public Resept next(){

	    Resept returnerDenne = pekerTilNeste.obj;
	    teller++;
	    pekerTilNeste = pekerTilNeste.neste;
	    return returnerDenne;
	}
	    
    }
    
    //finne resept basert på oppgit nummer
    //kaster unntak dersom det ikke finnes et slik nummer
    public Resept finnResept(int nummer){

	try{
	    for(Resept r:this){
		if(r.giNummer() == nummer){
		    return r;
		}
	    }

	}
	catch(NoSuchElementException e){
	    return null;
	}
	return null;
    }

}
