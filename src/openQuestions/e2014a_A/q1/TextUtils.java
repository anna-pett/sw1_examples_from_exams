package openQuestions.e2014a_A.q1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TextUtils {
	public static List<String> sortByLengthAndFrequency (String inputFileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inputFileName));
			Map<String, Integer> hist = new HashMap<>();	// effectively final
			String line = null;
			while ( (line=br.readLine()) != null )
				hist.put(line, 1 + hist.getOrDefault(line, 0));
			
			return hist.keySet().stream()
					.sorted(Comparator.comparing(String::length, Comparator.reverseOrder())
							.thenComparing(s->hist.get(s), Comparator.reverseOrder()))
					.collect(Collectors.toList());
		}
		catch (IOException e) { return null; }
		finally {
			try { br.close(); }
			catch (IOException e) { return null; }
		}
	}
	
	
	public static List<String> sortByLengthAndFrequency_TreeSet (String inputFileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(inputFileName));
			Map<String, Integer> hist = new HashMap<>();	// effectively final
			String line = null;
			while ( (line=br.readLine()) != null )
				hist.put(line, 1 + hist.getOrDefault(line, 0));
			
			Set<String> t = new TreeSet<>((s1,s2)-> {
												int tmp = Integer.compare(s2.length(), s1.length());
												return (tmp != 0) ? tmp : Integer.compare(hist.get(s2), hist.get(s1));
											});
			t.addAll(hist.keySet());
			return new ArrayList<>(t);
		}
		catch (IOException e) { return null; }
		finally {
			try { br.close(); }
			catch (IOException e) { return null; }
		}
	}
	
	
	public static List<String> sortByLengthAndFrequency_officialSolution_1 (String inputFileName) {
		
		Scanner inputScanner = null;
		
		try {
			
			// Counting word occurrences in the input file using a HashMap
			Map<String,Integer> wordsFreq = new HashMap<>();
			
			inputScanner = new Scanner (new File(inputFileName));
			
			while(inputScanner.hasNext()) {
				String curWord = inputScanner.next();
				if(!wordsFreq.containsKey(curWord))
					wordsFreq.put(curWord, 1);
				else
					wordsFreq.put(curWord, wordsFreq.get(curWord)+1);
			}
			
			// Sorting the map's entries by value
			List<Map.Entry<String,Integer>> entries = new ArrayList<>( wordsFreq.entrySet());
			
			Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
				
				// Compares words based on length (descending) and then by Frequency (descending)
				@Override
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// If length is the same, secondary order is by frequency
					if(o1.getKey().length()==(o2.getKey().length()))
						return((Integer) o2.getValue())-((Integer) o1.getValue()); // descending order
					return o2.getKey().length() -o1.getKey().length();
				}
			});
			
			// Builds the result list composed of only keys
			List<String> result = new ArrayList<>();
			for(Map.Entry<String, Integer> entry: entries)
				result.add(entry.getKey());
			
			return result;
		}
		catch(Exception e) {
			return null;
		}
		finally {
			if (inputScanner!=null)
				inputScanner.close();
		}
	}

	
	
	public static List<String> sortByLengthAndFrequency_officialSolution_2 (String inputFileName) {
		BufferedReader inputReader = null;
		try{
			
			// Counting word occurrences in the input file using a HashMap
			final Map<String,Integer> wordsFreq = new HashMap<>();	// added final. try removing it!
			String curWord;
			inputReader = new BufferedReader (new FileReader(inputFileName));
			while((curWord=inputReader.readLine())!=null) {
				if(!wordsFreq.containsKey(curWord))
					wordsFreq.put(curWord, 1);
				else
					wordsFreq.put(curWord,wordsFreq.get(curWord)+1);
			}
			inputReader.close();
			
			// Extracting the words without repetitions from the map keys
			List<String> wordList = new ArrayList<>(wordsFreq.keySet());
			
			// Sorting the word list using an external comparator which takes wordFreq as a parameter
			Collections.sort(wordList, new MyComparator(wordsFreq) );

			
			// added code;
			// lambda can see final (or effectively final) wordsFreq
			Collections.sort(wordList, (s1,s2)-> {
													int tmp = Integer.compare(s2.length(), s1.length());
													return (tmp != 0) ? tmp : Integer.compare(wordsFreq.get(s2), wordsFreq.get(s1));
												}
							);
			
			// anonymous class can see final (or effectively final) wordsFreq
			Collections.sort(wordList, new Comparator<String>(){
				@Override
				public int compare(String s1, String s2) {
					int tmp = Integer.compare(s2.length(), s1.length());
					return (tmp != 0) ? tmp : Integer.compare(wordsFreq.get(s2), wordsFreq.get(s1));
				}
			}
			);
			// end of added code;
			
			return wordList;
		}catch(Exception e) {
			return null;	// should have closed inputReader here.
		}
	}
	
	// part of official solution # 2;
	
	// Nested class defining a String comparator. 
	public static class MyComparator implements Comparator<String> {
		Map<String,Integer> wordFreqMap;
		
		// Constructor
		public MyComparator (Map<String,Integer> map) {
			this.wordFreqMap = map;
		}
		
		// Compares based on length (descending) and then by Frequency (descending)
		@Override
		public int compare(String  s1, String s2) {
			if(s2.length() > s1.length())
				return 1;
			if(s2.length() < s1.length())
				return -1;
			if( wordFreqMap.get(s2) >  wordFreqMap.get(s1))
				return 1;
			else
				if( wordFreqMap.get(s2) <  wordFreqMap.get(s1))
					return -1;
			return 0;
		}
	}
	
	
	
	
	public static void main(String args[]) {
		String relativeRoot = "./src/openQuestions/e2014a_A/q1/";
		System.out.println(sortByLengthAndFrequency(relativeRoot+"test.txt"));
		
		System.out.println(sortByLengthAndFrequency_TreeSet(relativeRoot+"test.txt"));
		
		System.out.println(sortByLengthAndFrequency_officialSolution_1(relativeRoot+"test.txt"));
		
		System.out.println(sortByLengthAndFrequency_officialSolution_2(relativeRoot+"test.txt"));
	}
}
