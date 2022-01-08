package openQuestions.e2021b_B.q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	
	// maybe empty lines should be considered ok..
	public static List<List<String>> loadSentences(String fileName) throws FileContentException {
		
		BufferedReader br = null;
				
		try {
			br = new BufferedReader(new FileReader(fileName));
		
			List<List<String>> res = new ArrayList<>();
		
			String curLine = br.readLine();
			if (curLine == null) 
				return res;

			if (!curLine.startsWith("<") || curLine.length() <= 1)
				throw new FileContentException("msg1");

			List<String> curSent = new ArrayList<>();
			curSent.add(curLine.substring(1));
			
//			List<String> curSent = Arrays.asList(curLine.substring(1));
			
			while ((curLine = br.readLine()) != null) {
				if (curLine.startsWith("<")) {
					if (curLine.length() == 1) 
							throw new FileContentException("msg2");
					else {
						res.add(curSent);
						curSent = new ArrayList<>();
						curSent.add(curLine.substring(1));
					}
				}
				else {
					if (curLine.length() == 0) 
						throw new FileContentException("msg3");
					else
						curSent.add(curLine);
				}	
			}
			res.add(curSent);
			return res;
		
		}
		catch(IOException e) { throw new FileContentException(e.getMessage()); }
		finally {
			try { br.close(); }
			catch (IOException e) { throw new FileContentException(e.getMessage()); }
		}
	}
	
	private static void print(String s, List<List<String>> lists) {
		System.out.println(s);
		for (List<String> list : lists)
			System.out.println(Arrays.toString(list.toArray()));
	}
	
	
	public static List<List<String>> loadSentences_officialSolution(String fileName) throws FileContentException {
		
		BufferedReader br=null;
		try{
			br= new BufferedReader(new FileReader(fileName));
			String line;
			List<String> currSentence=null;
			List<List<String>> allSentences = new ArrayList<>();
			while((line= br.readLine()) != null){
				line = line.trim();
				String word;
				if (line.startsWith("<")){
					currSentence = new ArrayList<>();
					allSentences.add(currSentence);
				}
				word = line.replace("<", "");
				// bug in the official solution!!
//				if(line.length() > 0){
				if(word.length() > 0){
					currSentence.add(word);
				}
			}
			for(List<String> s: allSentences){
				if(s.size() == 0){
					throw new FileContentException("Empty sentence!");
				}
			}
			return allSentences;
		}
		catch(Exception e){
			throw new FileContentException(e.getMessage());
		}
		finally{
			try {   br.close();  }
			catch(IOException e) {
				throw new FileContentException(e.getMessage());
			}
		}
	}

	public static void printFirstWordInSentence(String fileName){
		try {
			List<List<String>> sents = loadSentences(fileName);
			for (List<String> sent : sents)
				System.out.println(sent.get(0));
		}
		catch (FileContentException e) {};
	}
	
	public static void printFirstWordInSentence_officialSolution(String fileName){
		try{
			List<List<String>> sentences= loadSentences(fileName);
			sentences.stream().map(x->x.get(0))
								.forEach(System.out::println);
		}
		catch(Exception exp){
		}
	}
	
	public static void main(String args[]) {
		String relativeRoot = "./src/openQuestions/e2021b_B/q2/";
		for (int i = 1; i < 15; i++) {
			try {
				print(i+"", loadSentences(relativeRoot + "test" + i + ".txt"));
				
			}
			catch (FileContentException e){System.out.println(i + " " + e);}
		}
		
		try {
			print("oe1", loadSentences(relativeRoot + "official_example1.txt"));
			
		}
		catch (FileContentException e){System.out.println("oe1 " + e);}
		try {
			print("oe2", loadSentences(relativeRoot + "official_example2.txt"));
			
		}
		catch (FileContentException e){System.out.println("oe2 " + e);}
		
		printFirstWordInSentence(relativeRoot + "official_example1.txt");
		
		printFirstWordInSentence_officialSolution(relativeRoot + "official_example1.txt");
		
	}
	
}
