package polymorphism.e2020b_A.q8;

public class Q9 {
	public static void main(String[] args) {
		AA a= new BB();
		BB b= new BB();
		System.out.print(a.getComp("abc").compare(1, 1) + " ");
		System.out.print(b.getComp("abc").compare(1, 1) + " ");
	}
}
