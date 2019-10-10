import java.util.Scanner;
import java.io.*;

class test {
	public static void main(String[] args) throws Exception{
		SudokuBeholder beholder = new SudokuBeholder();

		Brett brettet = new Brett(beholder);
		brettet.lesFil("amane.txt");
		brettet.delInnRuter();
		//brettet.printBrett();

	}
}
