class Kolonne {
	private Rute[] array;
	private int k; 
	int kid;
	String verdi;
	int[] tallArray;
	int tall = 0;

	public Kolonne(int kol, int id) {
		this.k = kol;
		tallArray = new int[kol];
		array = new Rute[k];
		this.kid = id;
	}

	public void giVerdi(String verdi) {
		if(verdi.equals(".")) {
			this.verdi = verdi;
		}
		else {
			tallArray[tall] = Integer.parseInt(verdi);
			tall++;
		}
	}

	public void giTall(int num) {
		for(int i=0; i<tallArray.length; i++) {
			if(tallArray[i] == num) {
				return;
			}
			
		}
		System.out.println("Kol: setter inn : "+num+" i plass i array "+tall);
		tallArray[tall] = num;
		tall++;
	}
	
	public void fjernTall(int num) {
		for(int i=0; i<tallArray.length; i++) {
			if(tallArray[i] == num) {
				tallArray[i] = 0;
				tall--;
			}
		}
	}
}
