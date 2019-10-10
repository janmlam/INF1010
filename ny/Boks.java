class Boks {

	private Rute[] array;
	int bid;
	String verdi;
	int tall = 0;
	int str;
	int[] tallArray;

	public Boks(int str, int id) {
		array = new Rute[str];
		tallArray = new int[str];
		this.str = str;
		this.bid = id;
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

	public void giBoks() {
		for(int i=0; i<tallArray.length; i++) {
			System.out.println(tallArray[i]);
		}
	}

	public void giTall(int num) {
		for(int i=0; i<tallArray.length; i++) {
			if(tallArray[i] == num) {
				return;
			}
			
		}
		System.out.println("Boks: setter inn : "+num+" i plass i array "+tall);
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
