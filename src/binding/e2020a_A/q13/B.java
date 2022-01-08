package binding.e2020a_A.q13;

public class B extends A {
	private int i = 3;	//*
	
	public static void main(String[] args) {
		A a = new B();
		a.foo();		// **
		((B) a).foo();	//***
	}
	
	// added code
	public void baz() { System.out.println("B"); }
}
