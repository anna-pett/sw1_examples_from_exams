package polymorphism.e2021a_A.q12;

public class C extends B{
	public int getFirst(){
		return 2*super.getFirst();
	}
	
	public int getSecond(){ return 2; }
	
	public static void main(String[] args){
		Abst a = new C(); //***
		a.printRes();
	}
}
