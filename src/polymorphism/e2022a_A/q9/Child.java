package polymorphism.e2022a_A.q9;

public class Child extends Mom{
	public int func() {
		int res = 1 + ((Mom)this).foo();
		res += super.func(); // #
		return res;
	}
	
	public int foo() { return 1+super.foo(); }

}
