package constructors.e2018a_A.q16;

public class B extends A {
	
	public static String str = "B"; // q17: remove static modifier
	
	public B() { foo(); }
	
	public void foo() { System.out.println(str); }
	
	public static void main(String args[]) {
		B b = new B();
	}
}
