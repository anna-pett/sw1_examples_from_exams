package polymorphism.e2020b_B.q20;

public class Sub1 extends Base1 {
	private int j = 2;
	
	public Sub1() {
		sum = (sum * 2) + j + getNum();
	}
	
	@Override
	public int getNum() {
		return j;
	}
}
