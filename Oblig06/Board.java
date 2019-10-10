import java.util.*;
import java.io.*;

class Board {
    private Square[][] squares;
    private Box[][] boxes;
    private Row[] rows;
    private Column[] columns;
    private SudokuContainer container;
    // length = nr of columns per box
    // height = nr of rows per box
    private int size, length, height;
    private static int counter = 0;

    /**
     * Constructor used to create a new Board from file.
     * Accepting a String filename and SudokuContainer s.
     */
    Board(String filename, SudokuContainer s) {
		readFromFile(filename);
		rows = new Row[size];
		columns = new Column[size];
		boxes = new Box[height][length];
		container = s;
		createBoard();
    }

    /**
     * private method accepting a String filename.
     * Method used by constructor to create a new Board.
     */
    private void readFromFile(String filename) {
		try {
		    Scanner read = new Scanner(new File(filename));
		    String line;
		    int counter = 0;
		    String temp;
		    line = read.nextLine();
		    temp = line.substring(0);
		    height = convertToInt(temp);

		    line = read.nextLine();
		    temp = line.substring(0);

		    length = convertToInt(temp);
		    size = height*length;
		    
		    squares = new Square[size][size];

		    while(read.hasNextLine()) {
				line = read.nextLine();
		    	for (int i = 0; i < line.length(); i++) {
		    	    temp = line.substring(i, i+1);

		    	    if (temp.equals(".")) {
		    			squares[counter][i] = new FindValue(0);
		    	    } 
		    	    else {
						squares[counter][i] = new PreFilled(convertToInt(temp));
			  		}
		    	}
		    	counter++;
		    }
		} catch(IOException e) {
		    e.printStackTrace();
		}
    }

    /**
     * Constructor accepting a Square[][] s, int n, int m.
     * Used to create a copy of a solved Board for storing in SudokuContainer solutions.
     */
    Board(Square[][] s, int n, int m) {
		height = n;
		length = m;
		size = n*m;
		squares = s;
		rows = new Row[size];
		columns = new Column[size];
		boxes = new Box[n][m];
		createBoard();
    }

    /**
     * public method without arguments.
     * The method starts the solution-engine.
     */
    public void solve() {
    	squares[0][0].fillInRemainingOfBoard();
    }

    /**
     * private method without arguments.
     * The method creates a new Board with Row[], Column[] and Box[][].
     */
    private void createBoard() {
	// An array of rows containing rows with squares are made
		for (int i = 0; i < squares.length; i++) {
	    	rows[i] = new Row(squares[i]);
		}


	// An array of columns containing columns with squares are made
		Square[] columnArray = new Square[size];
		for (int i = 0; i < size; i++) {
		    for (int row = 0; row < size; row++) {
				columnArray[row] = squares[row][i];
		    }
		    columns[i] = new Column(columnArray);
		    columnArray = new Square[size];
		}


		Square[] boxArray;
		int counter;
		// Box nr i
		for (int i = 0; i < size; i = i + height) {
		    // Box nr j
		    for (int j = 0; j < size; j = j + length) {
				counter = 0;
				boxArray = new Square[size];
				int rowIndex = (i / height) * height;
				int columnIndex = (j / length) * length;
				// Row nr k
				for (int k = rowIndex; k < rowIndex + height; k++) {
				    // Column nr l
				    for (int l = columnIndex; l < columnIndex + length; l++) {
						boxArray[counter] = squares[k][l];
						counter++;
				    }
				}
				boxes[j/length][i/height] = new Box(boxArray);
		    }
		}	
		createPointers();
    }

    /**
     * private method without arguments.
     * The method makes all Square-objects point to the next one.
     */
    private void createPointers() {
		Square[] tempSquares = new Square[size*size];
		int counter = 0;
		for (int i = 0; i < size; i++) {
		    for (int j = 0; j < size; j++) {
				tempSquares[counter] = squares[i][j];
				if (counter != 0) {
				    tempSquares[counter - 1].setNext(tempSquares[counter]);
				}
				counter++;
		    }
		}

		for (Row r: rows) {
		    r.tellSquares(this);
		}
		for (Column c: columns) {
		    c.tellSquares(this);
		}

/*
		System.out.println("_________");
		System.out.println("kol paa min, length her er: "+length);
		System.out.println("rad paa min, hoyde her er: "+height);
		System.out.println("boks length: "+boxes[0].length);
		System.out.println("boks length: "+boxes[1].length);
*/

		for (int i = 0; i < length; i++) {
		    for (int j = 0; j < height; j++) {
				boxes[j][i].tellSquares(this);
		    }
		}
    }

    /**
     * public method without arguments.
     * @return Box[][] boxes
     */
    public Box[][] getBoxes() {
    	return boxes;
    }

    /**
     * public method without arguments.
     * @return Box[] temp
     */
	public Box[] getBoxes1D() {
		Box[] temp = new Box[size];
		int tempCounter = 0;
		for (int j = 0; j < length; j++) {
		    for (int i = 0; i < height; i++) {
				temp[tempCounter] = boxes[i][j];
				tempCounter++;
		    }
		}
		return temp;
    }

    /**
     * public method without arguments.
     * @return Row[] rows
     */
    public Row[] getRows() {return rows;}

    /**
     * public method without arguments.
     * @return Column[] columns
     */
    public Column[] getColumns() {return columns;}
	/**
     * public method without arguments.
     * @return Square[][] squares
     */
    public Square[][] getSquares() {
    	return squares;
    }
    /**
     * public method without arguments.
     * @return SudokuContainer container
     */
    public SudokuContainer getSolutions() {return container;}

    

    /**
     * public method without arguments.
     * @return int
     */
    public int getHeight() {return height;}

    /**
     * public method without arguments.
     * @return int
     */
    public int getLength() {return length;}

    /**
     * public method accepting a String i.
     * The method converts i to an int.
     * A substitute method for Integer.parseInt() due to letters being numbers.
     * @return int
     */
    public int convertToInt(String i) {
		switch (i) {
			case ".": return 0;
			case "1": return 1;
			case "2": return 2;
			case "3": return 3;
			case "4": return 4;
			case "5": return 5;
			case "6": return 6;
			case "7": return 7;
			case "8": return 8;
			case "9": return 9;
			case "A": return 10;
			case "B": return 11;
			case "C": return 12;
			case "D": return 13;
			case "E": return 14;
			case "F": return 15;
			case "G": return 16;
			case "H": return 17;
			case "I": return 18;
			case "J": return 19;
			case "K": return 20;
			case "L": return 21;
			case "M": return 22;
			case "N": return 23;
			case "O": return 24;
			case "P": return 25;
			case "Q": return 26;
			case "R": return 27;
			case "S": return 28;
			case "T": return 29;
			case "U": return 30;
			case "V": return 31;
			case "W": return 32;
			case "X": return 33;
			case "Y": return 34;
			case "Z": return 35;
			default: System.out.println("The number is too high.");
			    return 9000;
		}
    }

    /**
     * public method accepting an int i.
     * Converts an int to a string.
     * @return String
     */
    public String convertToString(int i) {
		switch (i) {
			case 0: return "";
			case 1: return "1";
			case 2: return "2";
			case 3: return "3";
			case 4: return "4";
			case 5: return "5";
			case 6: return "6";
			case 7: return "7";
			case 8: return "8";
			case 9: return "9";
			case 10: return "A";
			case 11: return "B";
			case 12: return "C";
			case 13: return "D";
			case 14: return "E";
			case 15: return "F";
			case 16: return "G";
			case 17: return "H";
			case 18: return "I";
			case 19: return "J";
			case 20: return "K";
			case 21: return "L";
			case 22: return "M";
			case 23: return "N";
			case 24: return "O";
			case 25: return "P";
			case 26: return "Q";
			case 27: return "R";
			case 28: return "S";
			case 29: return "T";
			case 30: return "U";
			case 31: return "V";
			case 32: return "W";
			case 33: return "X";
			case 34: return "Y";
			case 35: return "Z";
			default: System.out.println("The number is too high.");
		    return "0";
		}
    }

    /**
     * public method without arguments.
     * The method prints all Square[][] squares to screen.
     */
    public void print() {
		counter++;
		System.out.print(counter + " ");
		for (int i = 0; i < size; i++) {
		    for (int j = 0; j < size; j++) {
				System.out.print(squares[j][i].getValue());
		    }
		    System.out.print("//");
		}
		System.out.println();
    }

    public void janPrint() {
    	for(int i=0; i<(size); i++) {
			for(int j=0; j<(size); j++) {
				System.out.print(squares[i][j].getValue());
			}
			System.out.println();
		}
    }

    /**
     * public method without arguments.
     * Creating a copy of Square[][] squares and Board this.
     * Stores copy in SudokuContainer container.
     */
    int xganger = 0;
    public void isSolution() {
    	xganger++;
    	System.out.println("Funnet losninger "+xganger+" ganger");
		Square[][] copySquares = new Square[size][size];	

		for (int i = 0; i < size; i++) {
		    for (int j = 0; j < size; j++) {
				copySquares[j][i] = new PreFilled(squares[j][i].getValue());
		    }
		}
		Board sol = new Board(copySquares, height, length);
		container.insert(sol);
    }
    
    
}