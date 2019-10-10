class Rad {
	private Rute[] array;
	public int r;
	int rid;
	String verdi;
	int[] tallArray;
	int tall = 0;

	public Rad(int rad, int id) {
		this.r = rad;
		array = new Rute[r];
		tallArray  = new int[r];
		this.rid = id;
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
		System.out.println("rad: setter inn : "+num+" i plass i array "+tall);
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
