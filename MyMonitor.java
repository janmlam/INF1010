//main monitor to maintain threads
class MyMonitor {
	private int sum;
	private int finishedThread = 0;
	private int k;

	//a constructor to determine how many threads there are
	public MyMonitor(int k) {
		this.k = k;
	}

	//a synchronized method to make all "finished-threads" to wait
	synchronized void waits() {
		while(finishedThread != k) {
			try {wait();
				System.out.println("Numbers of finished threads are: " + finishedThread);
			}
			catch(InterruptedException e) {
				System.out.println("Random cancellation appears");
				System.exit(1);
			}
		}
	}

	//a synchronized method to add the value together
	synchronized void add(int value){
		finishedThread++;
		sum = (sum + value);
		if(finishedThread == k) {
			notify();
		}
	}

	//a synchronized method to return sum
	synchronized int returnSum() {
		return sum;	
	}
}