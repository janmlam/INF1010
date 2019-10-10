class kristian{
	public static void main(String[] args) throws Exception{

		int teller2 = 0;
		int boksKolonner = 3;
		int boksRad = 2;
		int storrelse = boksRad*boksKolonner;
		for(int i= 0; i<storrelse; i++){//kolonne
     		for(int k = 0; k < storrelse; k++){//rad
		 	System.out.println(i+" og "+k);

			if(k%boksKolonner == 0 && k != 0){
	    	 teller2++;     
	 		}
		 	if(i%boksRad == 0 && i != 0 && k==0){
		    	teller2 = teller2 +boksKolonner;
		 	}
	     }
	     teller2 = teller2 - boksKolonner;
 		}
	}
}
	


for(int i= 0; i<storrelse; i++){//kolonne
     for(int k = 0; k < storrelse; k++){//rad
		 verdi = bokstaver[i][k];
		 ruteArray[teller] = new Rute(boksArray[teller2],kolonneArray[i],radArray[k],verdi);
		 boksArray[teller2].taVerdi(verdi);
		 kolonneArray[i].taVerdi(verdi);
		 radArray[k].taVerdi(verdi);
		 teller++;
			 
		 if(k%boksKolonner == 0 && k != 0){
		     teller2++;
			     
		 }
		 if(i%boksRad == 0 && i != 0 && k==0){
		     teller2 = teller2 +boksKolonner;
		 }
     }
     teller2 = teller2 - boksKolonner;
 }

 /*
//     1   1*2
     			if(i>=(i*r)) {
	     			if(j<k) {
	     				System.out.println(i+" og "+j+" skal i boks "+boksTeller);			 		
	     			}
	     			else if(j>=k && j<=2*k) {
						System.out.println(i+" og "+j+" skal i boks "+(boksTeller+1));
	     			}
	     		}
	     		else{
	     			if(j<k) {
	     				System.out.println(i+" og "+j+" skal i boks "+(boksTeller-1));			 		
	     			}
	     			else if(j>=k && j<=2*k) {
						System.out.println(i+" og "+j+" skal i boks "+(boksTeller));
	     			}
	     		}
 */

	for(int i= 0; i<storrelse; i++){//rad
	     
	    for(int k = 0; k < storrelse; k++){//kolonne
			verdi = bokstaver[i][k];
			ruteArray[teller] = new Rute(boksArray[teller2],kolonneArray[k],radArray[i],verdi,teller+1);
			boksArray[teller2].taVerdi(verdi);
			kolonneArray[k].taVerdi(verdi);
			radArray[i].taVerdi(verdi);
			teller++;
				 
			if((k+1)%boksKolonner == 0 && k != 0){
			    teller2++;
				     
			}
			if((i+1)%boksRad == 0 && (k+1)%boksKolonner == 0  && k==storrelse-1){
			    teller2 = teller2 + ((storrelse/boksKolonner));
			}
	    }
	    teller2 = teller2 - ((storrelse/boksKolonner));
	}