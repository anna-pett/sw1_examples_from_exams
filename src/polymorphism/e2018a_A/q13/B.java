package polymorphism.e2018a_A.q13;

public class B extends A{
	public static void foo() {	//*
		System.out.println ("B.foo");
	}
	public static void foo(A a) { //**
		foo();
	}
	public static void bar(A a) { //**
		foo(a);
	}
	
	public static void main(String args[]) {
		A ab = new B();
		B bb = new B();
//		ab.bar(bb); //***
	}
}
