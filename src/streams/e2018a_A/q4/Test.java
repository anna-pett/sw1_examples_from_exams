package streams.e2018a_A.q4;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(2,3,4);
		lst.stream().
				map(x->{
						System.out.print("m ");
						return x*5;
				})
				.filter(x->{
							System.out.print("f ");
							return x%2==0;
				})
				.sorted()
				.peek(x->System.out.print("p "))
				.forEach(x->System.out.print(x + " "));
	}
}
