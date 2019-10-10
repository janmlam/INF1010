//importing "things" to library
import java.util.Scanner;
import java.io.*;


//
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


		MyMonitor monitor = new MyMonitor(k);

		String[] array =  new String[1000000];
		int currentLine = 0;
		while(currentLine < amountWords) {
			array[currentLine] = sc.nextLine();
			currentLine++;
		}

		int start = 0;
		int stopp = amountThread;
		for(int i = 0; i<k; i++) {
			if(i != k) {
				if(i==0) {
					System.out.println(start+(i*amountThread) + "-->" + (stopp+(i*amountThread)));
					new MyThread(array, (start+(i*amountThread)), (stopp+(i*amountThread)), monitor, word).start();
				}
				else {
					System.out.println((start+(i*amountThread)+1) + "-->" + (stopp+(i*amountThread)));
					new MyThread(array, (start+(i*amountThread)+1), (stopp+(i*amountThread)), monitor, word).start();	
				}
			}
			else {
				System.out.println(start+((i*amountThread)+1) + "-->" + (stopp+(i*amountThread)+rest));
				new MyThread(array, (start+(i*amountThread)+1), (stopp+(i*amountThread)+rest), monitor, word).start();
			}
		}
		monitor.waits();
		System.out.println("Amount of times " + word + " appeared: " + monitor.returnSum());
	}
}
