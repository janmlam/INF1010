import java.util.* ;

class Lenkeliste<T> implements Iterable<T>{

    Node foran;
    Node bak;
    int antall;

    private class Node{
		Node(T t) {
		    obj = t;
		}
		protected Node neste;
		protected T obj;
    }

    Lenkeliste(){
		foran = null;
		bak = foran.neste;
		bak = null;
		antall = 0;
    }

    public Iterator<T> iterator(){
		return new LenkeListeIterator();
    }

    private class LenkeListeIterator implements Iterator<T>{

		int teller = 0;
		Node pekerTilNeste = foran;

		public boolean hasNext(){
		    return (teller < antall);
		}

		public void remove(){
		    
		}

		public T next(){

		    T returnerDenne = pekerTilNeste.obj;
		    teller++;
		    pekerTilNeste = pekerTilNeste.neste;
		    return returnerDenne;
		}  
    }
}
