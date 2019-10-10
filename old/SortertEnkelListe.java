class SortertEnkelListe<T> implements AbstraktSortertEnkelListe<T> {

	private class Node{
		Node neste;
		T obj;
		Node (T t) {
			obj = t;
		}
	}

	Node foran, bak;

	boolean sukess;
	public boolean settIn(T t)	{	
		if(t instanceof Lik) {
			"SETT INN MINSTE";
			sukess = true;
		}
		else if(t instanceof Comparable) {
			"SETT INN MINSTE";
			sukess = true;
		}
		else {
			sukess = false;
		}
		return sukess;
	}
	

	public T finnObjekt(String string) {
		"FINNE ELEMENT BASERT PÅ string"
	}

	public Iterator itererOver(T t) {
		
	}

}