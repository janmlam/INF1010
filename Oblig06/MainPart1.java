class MainPart1 {

    /**
     * public main method accepting String[] commandArgs from the command line.
     * Determines whether or not the solutions should be written to file or screen.
     */
    public static void main(String[] commandArgs) {
		SudokuContainer solutions = new SudokuContainer();
		Board board;
		boolean filePrint = false;

		// Decides if the answers are to be written to file.
		if (commandArgs.length == 0) {
		    System.out.println("Usage: java MainPart1 input.filename output.filename (optional)");
		    System.exit(0);
		} 
		else if (commandArgs.length == 1) {
		    filePrint = false;
		} 
		else {
		    filePrint = true;
		}

		board = new Board(commandArgs[0], solutions);
		board.solve();

		if (filePrint) {
		    solutions.printToFile(commandArgs[1]);
		    board.janPrint();
		} 
		else {
		    solutions.printSolutions();
		    board.janPrint();
		}
    }
}