//importing "things" to library
import java.util.Scanner;
import java.io.*;

//mainclass which uses command line arguments for specific use
class wordsInFile {
	public static void main(String[] args) throws Exception {
		String word = args[0];
		String filename = args[1];
		int k = Integer.parseInt(args[2]); 
		
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		int amountWords = Integer.parseInt(sc.nextLine());
		int amountThread = (amountWords/k);
		int rest = (amountWords%k);

		//creating a mainmonitor, where k is amount of threads 
		MyMonitor monitor = new MyMonitor(k);

		//here we make an array to put words in
		//not expecting amount of words to be more than 100000
		String[] array =  new String[1000000];
		int currentLine = 0;
		//adding words to array
		while(currentLine < amountWords) {
			array[currentLine] = sc.nextLine();
			currentLine++;
		}

		//creating start/stopp values for the for-loop
		int start = 0;
		int stopp = amountThread;
		for(int i = 0; i<k; i++) {
			if(i != k) {
				if(i==0) {
					//System.out.println(start+(i*amountThread) + "-->" + (stopp+(i*amountThread)));
					new MyThread(array, (start+(i*amountThread)), (stopp+(i*amountThread)), monitor, word).start();
				}
				else {
					//System.out.println((start+(i*amountThread)+1) + "-->" + (stopp+(i*amountThread)));
					new MyThread(array, (start+(i*amountThread)+1), (stopp+(i*amountThread)), monitor, word).start();	
				}
			}
			else {
				//System.out.println(start+((i*amountThread)+1) + "-->" + (stopp+(i*amountThread)+rest));
				new MyThread(array, (start+(i*amountThread)+1), (stopp+(i*amountThread)+rest), monitor, word).start();
			}
		}
		//ask the monitor to wait for all threads to be finished
		monitor.waits();
		System.out.println("Amount of times " + word + " appeared: " + monitor.returnSum());
	}
}
