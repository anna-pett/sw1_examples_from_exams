package polymorphism.e2020b_A.q18;

public class C extends B {
	protected String str;
	public static void main(String[] args) { new C().printStrOfA(); }
//	public void printStrOfA() {  System.out.println(**********);  } //$
	
	// added code
	public void printStrOfA() {  System.out.println(((A) this).str);  } //$
//	public void printStrOfA() {  System.out.println(((B) this).super.str);  } //$	// we're not in class B, can't reference B.super
//	public void printStrOfA() {  System.out.println(((B) this).str);  } //$			// str from B
//	public void printStrOfA() {  System.out.println(super.str);  } //$				// str from B
}
