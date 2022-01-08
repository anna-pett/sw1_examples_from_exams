package polymorphism.e2018a_A.q7;

public class Tester {
	
	public void func(B b1, B b2) {
		A a1 = (A)b1; //line1
		A a2 = (A)b2; //line2	// java.lang.ClassCastException
	}

	public static void main(String args[]) {
		(new Tester()).func(new A(), new B());
//		(new Tester()).func(new A(), new A1());
	}
}
