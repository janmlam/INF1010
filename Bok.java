//creating a class which implements a generic interface
class Bok implements TilUtlaan{

	//creating private variable, title
	private String title;

	//a contructor to give Bok a title
	public Bok(String title) {
		this.title = title;
	}

	//a method to loan the title out
	boolean loanedOut;
	public boolean objectOut(String out) {
		if (title == null) {
			title = out;
			loanedOut = true;
		}
		else {
			loanedOut = false;
		}
		return loanedOut;
	}

	//a method to return title
	private String keeper;
	public String objectIn(String in) {
		if(title == in) {
			keeper = in;
			title = null;
		}
		else {
			keeper = null;
		}
		return keeper;
	}
}