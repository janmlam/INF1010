//creating class Bol with <> function (generic)
class Bol<T>  {

	//creating private generic variable, and a private boolean variable
	private T beboer = null;
	private boolean tomt = true;

	//method to put Mus in Bol, also making the Bol occupied
	public void settInn(T a) {
		this.beboer = a;
		tomt = false;
	}

	//method to take the called generic object out, also emptying the Bol
	public T taUt() {
		T tasUt = beboer;
		this.beboer = null;
		tomt = true;
		return tasUt;
	}

	//get method to check if Bol is occupied or not
	public Boolean tomt() {
		return tomt;
	}

	//get method for generic variable 
	public T beboer() {
		return beboer;
	}
}