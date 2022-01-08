package nestedClasses.e2020a_B.q18;

public class A {
	int i;
	
	public A(int i) { this.i = i; }
	
	public class Engine{
		public A a;
		int i;
		
		public Engine(A a) {
			this.a = a;
			this.i = A.this.i;
		}
		
		public void f() {
			System.out.println(this.i);
			System.out.println(a.i);
			System.out.println(A.this.i);
		}
	}
	
	public static void main(String[] args) {
		A c = new A(1);
		Engine e = c.new Engine(new A(2));
		e.f();
//		e.i = 3;
//		e.f();
	}
}
