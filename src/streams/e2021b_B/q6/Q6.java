package streams.e2021b_B.q6;

import java.util.stream.Stream;

public class Q6 {
	public static void main(String[] args) {
		Stream<Integer> s= Stream.generate(new SmallNumbers());
		System.out.println(s.peek(x->System.out.print("x"))
				.filter(x->x%2== 0)
				.map(x->x/2)
				.peek(x->System.out.print("y"))
				.allMatch(x-> x < 3));
		}
}
