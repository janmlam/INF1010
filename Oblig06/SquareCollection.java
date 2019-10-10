abstract class SquareCollection {
    protected Square[] squares;
    
    /**
     * Constructor accepting a Square[] s.
     */
    SquareCollection(Square[] s) {squares = s;}

    /**
     * public method without arguments.
     * @return Square[]
     */ 
    public Square[] getSquares() {
        return squares;
    }

    /**
     * public method accepting an int i.
     * Checking if i is a value in one of the Square-objects in Square[] squares.
     * @return boolean
     */
    public boolean legalValue(int i) {
    	for (Square s: squares) {
    	    if (s.getValue() == i) {
                return false;
            }
    	}
    	return true;
    }
}

/**
 * Subclass of abstract class SquareCollection.
 */
class Box extends SquareCollection {
    /**
     * Constructor accepting a Square[] squares.
     * Sending squares to superclass.
     */
    Box(Square[] squares) {
	   super(squares);
    }

    /**
     * public method accepting a Board b.
     * Sends Box this and b to Square s in Square[] squares.
     */
    public void tellSquares(Board b) {
    	for (Square s: squares) {
    	    s.iBelongHere(this, b);
    	}
    }
}

/**
 * Subclass of abstract class SquareCollection.
 */
class Row extends SquareCollection {
    /**
     * Constructor accepting a Square[] squares.
     * Sending squares to superclass.
     */
    Row(Square[] squares) {
	   super(squares);
    }

    /**
     * public method accepting a Board b.
     * Sends Row this and b to Square s in Square[] squares.
     */
    public void tellSquares(Board b) {
    	for (Square s: squares) {
    	    s.iBelongHere(this, b);
    	}
    }
}

/**
 * Subclass of abstract class SquareCollection.
 */
class Column extends SquareCollection {
    /**
     * Constructor accepting a Square[] squares.
     * Sending squares to superclass.
     */
    Column(Square[] squares) {
    	super(squares);    
    }

    /**
     * public method accepting a Board b.
     * Sends Column this and b to Square s in Square[] squares.
     */
    public void tellSquares(Board b) {
    	for (Square s: squares) {
    	    s.iBelongHere(this, b);
    	}
    }
}