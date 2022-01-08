package polymorphism.e2020b_A.q18;

public class B extends A {
	protected String str;
	
	// added code
	public static void main(String[] args) {
//		C c = new C();
//		((B) c).printStrOfA2(); 
		
		B b = new B();
		b.printStrOfA();
		b.printStrOfA2();
		
		printStrOfA3(b);
		}
	public void printStrOfA() {  System.out.println(super.str);  }				// works only inside class B
	public void printStrOfA2() {  System.out.println(((A) this).str);  }		// works only inside class B
	public static void printStrOfA3(B b) {  System.out.println(((A) b).str);  }	// works in code outside B too
//	public static void printStrOfA4(B b) {  System.out.println(super.str);  }	// static has no this and no super.
	
}
