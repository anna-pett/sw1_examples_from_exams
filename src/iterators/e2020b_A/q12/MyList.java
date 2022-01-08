package iterators.e2020b_A.q12;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
	List<E> innerList;
	
	public MyList() {
		innerList = new ArrayList<E>();
	}
	
	public boolean add(E e) {
		return innerList.add(e);
	}
	
	public Iterator<E> iterator() {
		return innerList.iterator();
	}
}
