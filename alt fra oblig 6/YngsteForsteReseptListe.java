//en subklasse av enkelreseptliste
//subklassen har en settinn metode slik at når vi itererer
//vil den yngste "printes" ut først
class YngsteForsteReseptListe extends EnkelReseptListe{

    public boolean settInn(Resept r){
    	boolean sukkess = false;
		if(antall == 0){
		    Node n = new Node(r);
		    foran = n;
		    foran.neste = bak;
		    bak = n;
		    antall++;
		    sukkess = true;
		}
		else{
		    Node n = new Node(r);
		    n.neste = foran;
		    foran = n;
		    antall++;
		    sukkess = true;
		}
		return sukkess;
    }
}
