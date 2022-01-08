package scanners.e2018a_A.q12;

import java.io.File;
import java.util.Scanner;

public class Tester {
	private static String FILE_NAME = "./src/scanners/e2018a_A/q12/f.txt";
	
	public static void main(String[] args) throws Exception {
		final Scanner s = new Scanner(new File(FILE_NAME));
		s.useDelimiter("#");
		String s1 = s.next();
		s.skip("#");
		String text = "";
		while (s.hasNextLine()) {
			text += s. nextLine() + ' ';
		}
		System.out.println(text);
		s.close();
	}
}
