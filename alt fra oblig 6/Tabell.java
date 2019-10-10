import java.util.*;
//subklasse som implementerer Iterable og abstrakttabell
class Tabell<T> implements Iterable<T>, AbstraktTabell<T> {

    int foran;
    int antall;

    //lager metoder, og klasse for å gjøre iterering mulig
    public Iterator<T> iterator(){
	return new LenkeListeIterator();
    }

    private class LenkeListeIterator implements Iterator<T>{
	int teller = 0;
	T neste  = tabellArray[foran];

	public boolean hasNext(){
	    return(teller<antall);
	}

	public void remove(){}

	public T next(){
	    T returnerDenne = tabellArray[teller];
	    teller++;
	    neste = tabellArray[teller];
	    return returnerDenne;
		}
    }

    private T[] tabellArray;
    
    //konstrukoer for å angi array lengde
    Tabell(int lengde){
		foran = 0;
		antall = 0;
		tabellArray = (T[]) new Object[lengde];
    }

    //sett inn metode for angitt indeks
    public boolean settInn(T obj, int index){
		if(tabellArray[index] == null){
		    tabellArray[index] = obj;
		    return true;
		}
		else{
		    return false;
		}
    }

    //metode for å finne objekt ved hjelp av indeks
    public T finn(int index){
		if(tabellArray[index] != null){
		    return tabellArray[index];
		}
		else{
		    return null;
		}
    }

    //iterering
	int i = 0;
	int feil = 0;
    public void skrivUt(){
    	System.out.println("Tester iterator. Forventer at indexene 0 og 3 skal ha resept, 1,2,4 skal vere null");
		for(T t:tabellArray){
		    if(i == 0 || i == 3) {
		    	if(t == null) {
		    		feil++;
		    	}
		    }
		    System.out.println("indexnr.: " + i + " innhold: " + t);
		    i++;
		}
		System.out.println("antall feil: " +feil);
    }
}
