class EldsteForsteReseptListe extends EnkelReseptListe{

    public void settInn(Resept r){
		if(antall == 0){
		    Node n = new Node(r);
		    bak = n;
		    foran = n;
		    bak.neste = foran;
		    antall++;
		}
		else{
		    Node n = new Node(r);
		    n.neste = bak;
		    bak = n;
		    antall++;
		}
    }
    
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
