package polymorphism.e2020b_A.q8;

import java.util.Comparator;

public class AA {
	public Comparator<Integer> getComp(Object a) {
		return (x,y) -> Integer.compare(x, y);
	}
}
