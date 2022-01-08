package constructors.e2020a_A.q14;

public class B extends A{
	private String s = "B";
	
	public void f() { System.out.print(s); }
	
	public B() { f(); }
	
	public static void main(String[] args) {
		A a = new B(); // ***
		System.out.print(a.s);
	}
}
