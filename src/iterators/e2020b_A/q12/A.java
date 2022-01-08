package iterators.e2020b_A.q12;

import java.util.Iterator;

public class A {
	public static void main(String[] args) {
		MyList<String> list = new MyList<>();
		int res= 0;
		list.add("a");
		list.add("b");
		list.add("c");
		for(Iterator<String> iter = list.iterator(); iter.hasNext();) {
			String current = iter.next();
			if (current.equals("b"))
				res++;
		}
		try {
			for(String current : list) {	// doesn't compile without MyList<E> implements Iterable<E> 
				if (current.equals("c"))
					res++;
			}
		}catch(Exception exp) {
			
		}
		
		System.out.println(res);
	}
}
