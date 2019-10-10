import java.util.*;

class Tabell<T> implements Iterable<T>, AbstraktTabell<T> {

    int foran;
    int antall;

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
    
    Tabell(int lengde){
		foran = 0;
		antall = 0;
		tabellArray = (T[]) new Object[lengde];
    }

    public boolean settInn(T obj, int index){
		if(tabellArray[index] == null){
		    tabellArray[index] = obj;
		    return true;
		}
		else{
		    return false;
		}
	}

	public T finn(int index){
		return tabellArray[index];
	}

	public void skrivUt(){
		for(T t:tabellArray){
			System.out.println(t);
		}
    }
}
