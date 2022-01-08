package openQuestions.e2021b_A.q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookCollection {

	/*@pre: sentences.size() > 0;*/
	public static Set<String> extractWords(List<String> sentences) {
		Set<String> res = new HashSet<>();
		for(String sent : sentences)
//			res.addAll(Arrays.asList(sent.split(" ")));
			for(String word : sent.split(" "))
				res.add(word);
		return res;
	}
	
	/*@pre: book1Words.size() > 0, book2Words.size() > 0*/
	public static int similarityScore(Set<String> book1Words,Set<String> book2Words){
		return book1Words.stream()
				.filter(w->book2Words.contains(w))
				.collect(Collectors.summingInt(e->1));
//				.collect(Collectors.toSet()).size();
		
//		book1Words.retainAll(book2Words);
//		return book1Words.size();
		
//		int res = 0;
//		for (String word : book1Words)
//			if (book2Words.contains(word)) res++ ;
//		return res;
	}
	
	/*@pre: books.size() > 2, books.containsKey(bookName)*/
	public static List<String> analyzeSimilarityForBook(Map<String, List<String>> books, String bookName){
		List<String> res = new ArrayList<>(books.keySet());
		res.remove(bookName);
		Set<String> bookNameWords = extractWords(books.get(bookName));
		res.sort((bn1, bn2)->Integer.compare(similarityScore(extractWords(books.get(bn2)), bookNameWords),
											similarityScore(extractWords(books.get(bn1)), bookNameWords)));
//		res.sort(Comparator.comparingInt((bn)->similarityScore(extractWords(books.get(bn)), bookNameWords)).reversed());
		return res;
	}
	
	
	/*@pre: books.size() > 2, books.containsKey(bookName)*/
	public static List<String> analyzeSimilarityForBook_officialAnswer(Map<String, List<String>> books, String bookName){
		// all words for book name
		Set<String> wordsForBookName = extractWords(books.get(bookName));
		Map<String, Integer> bookToSimScore = new HashMap<>();
		
		// populate book to score map
		for(String currBookName : books.keySet()){
			if(!currBookName.equals(bookName)){
				Set<String> currS = extractWords(books.get(currBookName));
				int simScore = similarityScore(wordsForBookName, currS);
				bookToSimScore.put(currBookName, simScore);
			}
		}
		
		List<String> res = new ArrayList<>();
		res.addAll(bookToSimScore.keySet());
		// sort names list by score in a descending order
		res.sort((x,y)-> -Integer.compare(bookToSimScore.get(x),
											bookToSimScore.get(y)));
		return res;
	}
		
		
	
	public static void main(String args[]) {
		Map<String, List<String>> books= new HashMap<>();
		books.put("book1", Arrays.asList("i love icecream", "i love cakes"));
		books.put("book2", Arrays.asList("love love me do"));
		books.put("book3", Arrays.asList("do you like cheesecake", "me too"));
		Set<String> set1= new HashSet<>();
		Set<String> set2= new HashSet<>();
		set1.addAll(Arrays.asList("a", "b", "c"));
		set2.addAll(Arrays.asList("a", "b", "d", "e"));
		
		System.out.println(extractWords(books.get("book1")));
		// [i,love, icecream, cakes]
		System.out.println(similarityScore(set1, set2));
		// 2
		System.out.println(analyzeSimilarityForBook(books, "book2"));
		//[book3, book1]
		System.out.println(analyzeSimilarityForBook_officialAnswer(books, "book2"));
	}
}
