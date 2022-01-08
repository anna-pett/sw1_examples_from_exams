package nestedClasses.e2020b_B.q12;


public class A {
	private A() {}
	// the rest of the code is not provided
	
	// added code
	// (1.)
	public static class B extends A {
		public B() {}
	}

	// (2.)
	public static A make_new_A() { return new A(); }
}
