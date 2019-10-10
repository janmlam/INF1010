import java.io.*;
import java.util.Scanner;

class MainProgram {

	//main program to read filename from command line, then check the starting word of each line
	//for x starting word, it splits the whole line into an array. Creating a new object with x,
	//and giving the object "names", they are then put into an Car array
	public static void main(String[] args) throws IOException {
		System.out.print("Enter the file name: ");
		Scanner fileIn = new Scanner(System.in);
	
		File file = new File(fileIn.nextLine());
		Scanner scannerino = new Scanner(file);
		int lines = amountLines(fileName);
	    Car[] garage = new Car[lines];
	    int arrayNumber = 0;


	    while(arrayNumber < lines) {
	    	while(scannerino.hasNextLine()) {
				String readLine = scannerino.nextLine();

				if(readLine.startsWith("BIL")) {
					String[] line = readLine.split(" ");
					Car car = new Car();
					car.carNumber = line[1];
					garage[arrayNumber] = car;
				}
				else if(readLine.startsWith("EL")) {
					String[] line = readLine.split(" ");
					ElCar elcar = new ElCar();
					elcar.carNumber = line[1];
					elcar.kW = Integer.parseInt(line[2]);
					garage[arrayNumber] = elcar;
				}
				else if(readLine.startsWith("FOSSIL")) {
					String[] line = readLine.split(" ");
					FossCar fosscar = new FossCar();
					fosscar.carNumber = line[1];
					fosscar.co2 = Double.parseDouble(line[2]);
					garage[arrayNumber] = fosscar;
				}
				else if(readLine.startsWith("LASTEBIL")) {
					String[] line = readLine.split(" ");
					Truck truck = new Truck();
					truck.carNumber = line[1];
					truck.co2 = Double.parseDouble(line[2]);
					truck.newWeight = Double.parseDouble(line[3]);
					garage[arrayNumber] = truck;
				}
				else if(readLine.startsWith("PERSONFOSSILBIL")) {					
					String[] line = readLine.split(" ");
					PersCar pascar = new PersCar();
					pascar.carNumber = line[1];
					pascar.co2 = Double.parseDouble(line[2]);
					pascar.passagers = Integer.parseInt(line[3]);
					garage[arrayNumber] = pascar;
				}
				arrayNumber++;
			}
	    }

	    //for-each loop to check through array for PersCar objects
	    for(Car a: garage) {
	    	if(a instanceof PersCar) {
	    		PersCar perscar = (PersCar) a;
	    		System.out.println("Carnumber: " + perscar.carNumber +
	    		" Amount of co2: " + perscar.co2 + " Amount of passagers: " + perscar.passagers);
	    	}
	    }
	}

	//a method to read how many lines there are in file. This is to measure how big one should make the array.
	public static int amountLines(String readIn){
		int count = 0;
		try {
				BufferedReader br = new BufferedReader(new FileReader(readIn));
				while (br.readLine() != null) {
					count++;
				}
			}
		catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}
}
