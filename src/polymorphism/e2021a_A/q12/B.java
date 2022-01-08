package polymorphism.e2021a_A.q12;

public class B extends Abst{
	public int getFirst(){
		return 5 + getSecond();
	}
	
	private int getSecond(){ return 6; }
}
