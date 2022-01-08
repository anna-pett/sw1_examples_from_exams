package polymorphism.e2020b_A.q8;

import java.util.Comparator;

public class BB extends AA{
	public Comparator<Integer> getComp(String a) {
		return (x,y)-> super.getComp(a).compare(2*x, y);
	}
	
	public Comparator<Integer> getComp(Object a) {
		return (x,y)-> super.getComp(a).compare(x, 3*y);
	}
}
