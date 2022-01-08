package exceptions.e2021b_A.q3;

public class Test {
	public static void main(String[] args) throws Exception {
		int x= 0;
		int[] a= { 1, 2, 3, 4 };
		for(int i: a) {
			try{
				if(i % 2 == 0) { throw new Exception(); }
				if(i % 3 == 0) { throw new NullPointerException(); }
				x++;
			}
			catch(RuntimeException e) { x = x+ 2; }
			catch(Exception e) { x++; }
			finally{ x++; }
		}
		System.out.println(x);
	}
}
