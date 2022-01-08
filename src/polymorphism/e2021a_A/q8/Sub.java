package polymorphism.e2021a_A.q8;

public class Sub extends Base{
//	public String func(String str) { return null; }
	public String func(String str) { System.out.println("from Sub"); return null; }
	public static void main(String[] args){
		Base a = new Sub();
		a.func("abc");
	}
}

