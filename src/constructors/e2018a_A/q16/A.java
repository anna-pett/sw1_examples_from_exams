package constructors.e2018a_A.q16;

public class A {
	
	public static String str = "A"; // q17: remove static modifier
	
	public A() { foo(); }
	
	public void foo() { //q17: change to private
		System.out.println(str);
	}
}
