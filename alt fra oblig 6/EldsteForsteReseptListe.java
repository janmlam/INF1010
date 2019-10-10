//elsteforst fra hovedklassen enkelrespetliste
//den har en egen sett inn metode som gjør at
//itereringen tar den eldste forst automatisk
class EldsteForsteReseptListe extends EnkelReseptListe{
	
    public boolean settInn(Resept r){
	    boolean sukkess = false;
		if(antall == 0){
		    Node n = new Node(r);
		    bak = n;
		    foran = n;
		    bak.neste = foran;
		    antall++;
		    sukkess = true;
		}
		else{
		    Node n = new Node(r);
		    bak.neste = n;
		    bak = n;
		    antall++;
		    sukkess = true;
		}
		return sukkess;
	}
}
