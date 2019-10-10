
class EnkelReseptListe {
	private class Node{
		Node neste;
		Prescription obj;
		Node(Prescription pre) {
			obj = pre;
		}
	}

	private Node foran, bak;
	private int antall;

	public void settInn(Prescription p) {
		Node n = new Node(p);
		n.neste = foran;
		foran = n;
		antall++;
	}

	public Prescription finn(int nr) {
		Node n = foran;
		Prescription p = null;
		for(int i = antall; i>0; i--) {
			if(n.obj.number == nr) {
				p = n.obj;
			}
			n = n.neste;
		}
		try {
			return p;
		}
		catch(Exception e) {
			return null;
		}
	}
}


/*

class EldsteForstReseptListe extends ReseptListe {

}






class YngsteForstReseptListe extends ReseptListe {

}

*/