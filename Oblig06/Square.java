abstract class Square {
    protected int value;
    protected Board board;
    protected Box box;
    protected Row row;
    protected Column column;
    protected Square next;

    /**
     * Constructor accepting int v.
     * Storing v in value.
     */
    Square(int v) {
    	value = v;
    }
    
    /**
     * public method accepting a Box b and Board bo.
     * Storing values in Square this
     */
    public void iBelongHere(Box b, Board bo) {
        box = b; board = bo;
    }

    public void giStuff() {
        System.out.println("GISTUFF METODE: lengde på boks= "+box);
    }

    /**
     * public method accepting a Row r and Board b.
     * Storing values in Square this
     */
    public void iBelongHere(Row r, Board b) {
        row = r; board = b;
    }

    /**
     * public method accepting a Column c and Board b.
     * Storing values in Square this
     */
    public void iBelongHere(Column c, Board b) {
        column = c; board = b;
    }

    /**
     * public method without arguments.
     * @return int
     */
    public int getValue() {
        return value;
    }

    /**
     * public method without arguments.
     * @return boolean
     */
    public boolean hasNext() {
        return next != null;
    }

    /**
     * public method accepting a Square s.
     * Storing s in Square next.
     */
    public void setNext(Square s) {next = s;}

    /**
     * public method without arguments.
     * @return Square
     */
    public Square getNext() {return next;}

    /**
     * public method accepting an int i.
     * Checking if Row row, Box box and Column c contains i.
     * @return boolean
     */
    public boolean isLegal(int i) {
    	if (row.legalValue(i) && box.legalValue(i) && column.legalValue(i)) {
    	    return true;
    	}
    	return false;
    }

    /**
     * public method without arguments.
     * Recursive method testing all values if they fit in Square this.
     * Calling next to do the same.
     */
    int tellerino = 0;
    public void fillInRemainingOfBoard() {
    	if (this instanceof PreFilled) {
    	    if (next != null) {
                next.fillInRemainingOfBoard();
            }
    	    else {
                tellerino++;
                System.out.println("Funnet losninger "+tellerino+" ganger");
                board.isSolution();
            }
    	} 
        else {
    	    for (int i = 1; i <= row.getSquares().length; i++) {
        		if (isLegal(i)) {
        		    value = i;
        		    if (next != null) {
                        next.fillInRemainingOfBoard();
                    }
        		    else {
                        tellerino++;
                        System.out.println("Funnet losninger "+tellerino+" ganger");
                        board.isSolution();
                    }
        		}
    		    value = 0;
    	    }
    	}
    }
}

/**
 * Subclass of class Square.
 * Used to determine whether or not the value is set or changeable.
 */
class PreFilled extends Square {
    /**
     * Constructor sending value v to superclass Square.
     */
    PreFilled(int v) {
	   super(v);
    }
}

/**
 * Subclass of class Square.
 * Used to determine whether or not the value is set or changeable.
 */
class FindValue extends Square {
    /**getBoxes
     * Constructor sending value v to superclass Square.
     */
    FindValue(int v) {
	   super(v);
    }
}
