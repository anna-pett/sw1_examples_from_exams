package polymorphism.e2021b_B.q12;

public final class Q12 {
	public final int i = func();
	
	public final Q12 f(){ return new Q12(); }	//*
	
	public int func(){  //#
//		i = 1;
		return i;
	}
	
	public void foo() {    //$
//		Q12 q = new Q12(){
//			public void func(){
//				System.out.println("override");
//			}
//		};
	}
}
