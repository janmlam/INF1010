import java.util.*;

class EnkelReseptListe implements Iterable<Resept>{

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

    
    /* public void settInn(Resept r){

		if(antall == 0){
	    Node n = new Node(r);
	    foran = n;
	    foran.neste = bak;
	    bak = n;
	    antall++;
	    System.out.println("hei");
	}
	else{
	    Node n = new Node(r);
	    n.neste = foran;
	    foran = n;
	    antall++;
	    System.out.println("hei");
	}
	}*/
    
    public Resept finnResept(int nummer){
		Resept r = null;
		if(antall == 0){
			System.out.println("ingenting i beholder");
		    return null;
		}
		else{
		    Node n = foran;
		    for(int i = antall; i > 0; i--){		
				if(n.obj.giNummer() == nummer){
				    r = n.obj;
				}
			n = n.neste;		
		    }	
		}

		try{
		    return r;
		}
		catch(Exception e){
		    System.out.println("ikke gyldig nummer");
		    return null;
		}
    }
   
}
