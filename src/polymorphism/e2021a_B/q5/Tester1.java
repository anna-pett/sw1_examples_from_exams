package polymorphism.e2021a_B.q5;

// for proposition#1
public class Tester1 {
	
	public static void func(A a1, A a2) {
		B b1=(B)a1;	//line 1
        B b2=(B)a2;	//line 2
        C c1=(C)a1;	//line 3
        C c2=(B)a1;	//line 4
	}
	
	public static void main(String[] args) {
		A a1= new A();
        A a2= new B();
        func(a1,a2);	// line 1 throws ClassCastException and line 2 doesn't
        
        a1= new B();
        a2= new A();
        func(a1,a2);	// line 2 throws ClassCastException and line 1 doesn't
	}
}
