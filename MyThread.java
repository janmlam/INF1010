//a classs which extends Thread 
class MyThread extends Thread {
	//creating variables 
	String[] array;
	int startIndex;
	int stoppIndex;
	MyMonitor mon;
	String word;

	//constructor to maintain values for variables
	MyThread(String[] a, int start, int stopp, MyMonitor m, String w) {
		this.array = a;
		this.startIndex = start;
		this.stoppIndex = stopp;
		this.mon = m;
		this.word = w;
	}

	//run function which checks how many times the given word appears in the given intervall 
	public void run() {
		int wordAppears = 0;
		for(int i = startIndex; i<=stoppIndex; i++){
			if(array[i].equals(word)) {
				wordAppears++;
			}
		}
		mon.add(wordAppears);
	}
}