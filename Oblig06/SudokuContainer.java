import java.util.*;
import java.io.*;

class SudokuContainer {

    // Maximum stored solutions.
    private Board[] solutions = new Board[2500];
    private int counter = 0;

    /**
     * public method accepting Board solution.
     * Storing solution in Board[] solutions.
     */
    public void insert(Board solution) {
    	counter++;
    	for (int i = 0; i < solutions.length; i++) {
    	    if (solutions[i] == null) {
    		  solutions[i] = solution;
    		  break;
    	    }
    	}
    }

    /**
     * public method without arguments.
     * Checking if Board[] solutions is empty.
     * @return boolean
     */
    public boolean hasSolutions() {
    	for (int i = 0; i < solutions.length; i++) {
    	    if (solutions[i] != null) {
                return true;
            }
    	}
    	return false;
    }

    /**
     * public method without arguments.
     * The method finds the closest Board solution.
     * First-in-first-out arrangement.
     * @return Board
     */
    public Board get() {
    	for (int i = 0; i < solutions.length; i++) {
    	    if (solutions[i] != null) {
                return remove(i);
            }
    	}
    	System.out.println("There are no more solutions");
    	return null;
    }

    /**
     * private method accepting an int number.
     * The method removes Board solutions[number].
     * Used primarily in get().
     * @return Board
     */
    private Board remove(int number) {
    	Board temp = solutions[number];
    	solutions[number] = null;
    	return temp;
    }

    /**
     * public method without arguments.
     * The method prints out all solutions stored in Board[] solutions.
     */
    public void printSolutions() {
    	System.out.println("Found " + getSolutionCount() + " solutions. The first " + numberOfSolutions() + " are shown below.");
    	Board b;
    	while(hasSolutions()) {
    	    b = get();
    	    b.janPrint();
    	}
    }

    /**
     * public method accepting a String filename.
     * The method writes all solutions in Board[] solutions to outputfile.
     */
    public void printToFile(String filename) {
	try {
    	    PrintWriter printer = new PrintWriter(new FileWriter(filename));
    	    counter = 0;
    	    Square[][] squares;
    	    Board b;
    	    while(hasSolutions()) {
        		b = get();
        		squares = b.getSquares();
        		counter++;
        		printer.write(counter + " ");
        		for (int i = 0; i < squares.length; i++) {
        		    for (int j = 0; j < squares.length; j++) {
                        printer.write(b.convertToString(squares[j][i].getValue()));
        		    }
        		    printer.write("//");
        		}
        		printer.write("\n");
    	    }
    	    printer.close();
    	} catch (IOException e) {
    	    System.out.println("Invalid filetype (probably).");
    	    System.exit(1);
    	}
    }

    /**
     * public method without arguments.
     * The method counts all stored solutions in Board[] solutions.
     * @return int
     */
    public int numberOfSolutions() {
	int solutionCounter = 0;
    	for (int i = 0; i < solutions.length; i++) {
    	    if (solutions[i] != null) {solutionCounter++;}
    	}
    	return solutionCounter;
    }

    /**
     * public method without arguments.
     * @return counter
     */
    public int getSolutionCount() {
        return counter;
    }
}