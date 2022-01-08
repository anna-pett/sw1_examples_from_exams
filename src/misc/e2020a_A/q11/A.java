package misc.e2020a_A.q11;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class A {
	private int i, j;
	private static int k; // added code
	
	public A(int i, int j) {
		this.i = i;
		this.j = j;
	}
	//the rest of the code is not provided
	
	@Override
	public boolean equals(Object o) { return true; }
	
	public static void main(String args[]) {
		Set<A> s = new HashSet<>();
		s.add(new A(3, 1));
		s.add(new A(1, 3));
		s.add(new A(3, 1));
		s.add(new A(2, 1));
		System.out.println(s.size());
	}
	
	// added code
	@Override
	public int hashCode() {
		return Objects.hash(0);		// 1
//		return Objects.hash(j);		// 2
//		return Objects.hash(i,j);	// 3
//		return Objects.hash(k++);	// 4
	}
}
