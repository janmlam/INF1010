import java.util.*;

//sorteringsliste som implementerer iterable , generiske objektet skal i tilegg ha lik og comparable funksjoner
class SortertEnkelListe2<T extends Lik & Comparable<T>> implements Iterable<T>, AbstraktSortertEnkelListe<T> {

    private Node foran;
    private Node bak;
    private int antall;

    //privat klasse for node
    private class Node{
	Node(T t) {
	    data = t;
	}
	protected Node neste;
	protected T data;
    }

    //konstruktoer for å inisiere en tom mengde
    SortertEnkelListe2(){
	foran = null;
	bak = null;
	antall = 0;
    }

    //metoder og klasse for å gjøre itereringingen mulig
    public Iterator<T> iterator(){
	return new LenkeListeIterator();
    }

    private class LenkeListeIterator implements Iterator<T>{

	int teller = 0;
	Node pekerTilNeste = foran;

	public boolean hasNext(){
	    return (teller < antall);
	}

	public void remove(){	}
	
	public T next(){
	    T returnerDenne = pekerTilNeste.data;
	    teller++;
	    if(pekerTilNeste.neste == null){
		return returnerDenne;
	    }
	    pekerTilNeste = pekerTilNeste.neste;
	    return returnerDenne;
	}
    }


    
    //metode for å sette inn objekt, her tar vi hensyn til å sortere de 
    //fra minst til størst av hengig av noden sin data
    public void settInn(T obj){

	Node n = new Node(obj);
	Node lagre = foran;
	Node forrige;

	if(lagre == null){ //hvis 0 noder i lista
	    foran = n;
	    bak = n;
	    antall++;
	    System.out.println("1");
	    System.out.println(n.data);
	    return;
	}
	else if(foran == bak){ // hvis 1 node i lista
	    
	    if(n.data.compareTo(lagre.data) < 0){ //hvis den er mindre, sett foran
		n.neste = foran;
		foran = n;
		antall++;
		System.out.println("2");
		System.out.println(n.data);
		return;
	    }
	    else if(n.data.compareTo(lagre.data) > 0){ //hvis den er større sett bak
		bak = n;
		foran.neste = n;
		antall++;
		System.out.println("3");
		System.out.println(n.data);
		return;
	    }
	}
	else{
	    if(n.data.compareTo(foran.data) < 0){ //sjekker om noden er mindre enn den første.
		n.neste = foran;
		foran = n;
		antall++;
		System.out.println("6");
		System.out.println(n.data);
		return;
	    }
	    while(lagre.neste != null){ //går gjennom lista og setter den i mellom den større og den mindre
		forrige = lagre;
		lagre = lagre.neste;
		if(n.data.compareTo(lagre.data) < 0){
		    n.neste = lagre;
		    forrige.neste = n;
		    antall++;
		    System.out.println("4");
		    System.out.println(n.data);
		}
		else if(lagre == bak && n.data.compareTo(lagre.data) > 0){ //hvis noden er bakerest og den nye
		    lagre.neste = n; //er større enn den bakerste, sett den bakerst.
		    bak = n;
		    antall++;
		    System.out.println("5");
		    System.out.println(n.data);
		}
	    }
	}
    }

    //finner objekt basert på en nøkkel
    //dette gjøres ved hjelp av iterering
    public T finn(String nokkel){	
	for(T t : this){
	    if(t.samme(nokkel)){
		return t;
	    }
	}
	return null;
    }
    
    
}
