class Tabell<T> implements AbstraktTabell {

	private class Node{
		Node neste;
		T obj;
		Node (T t) {
			obj = t;
		}
	}

	private E[] beholder;

	Tabell(int arrayLengde) {
		beholder = (E[]) new Object[number];
	}

	boolean sukess;
	public boolean settIn(T obj, int index) {
		if(E[index] == null) {
			E[index] = obj;
			sukess = true;
		}
		else {
			sukess = false;
		}
		return sukess;
	}

	public T finnObjekt(int index) {
		return E[index];
	}

	public Iterator itererOver(T t) {

	}
}