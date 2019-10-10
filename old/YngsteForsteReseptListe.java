class YngsteForsteReseptListe extends EnkelReseptListe{

    public void settInn(Resept r){
		if(antall == 0){
		    Node n = new Node(r);
		    foran = n;
		    foran.neste = bak;
		    bak = n;
		    antall++;
		}
		else{
		    Node n = new Node(r);
		    n.neste = foran;
		    foran = n;
		    antall++;
		}
    }
}
