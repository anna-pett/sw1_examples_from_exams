package polymorphism.e2020b_B.q20;

public class Base1 {
	public int sum = 0;
	private int i = 3;
	
	public Base1() {
		sum = i + 3 * getNum();
	}
	
	public int getNum() {
		return i;
	}
	
	public static void main(String[] args) {
		Base1 a = new Sub1();
		System.out.println(a.sum);
	}
}
