package polymorphism.e2021a_A.q8;

public class Base{
//	public Object func(String str) { //impl 1
//		//implementation here
//		System.out.println(" from Base # 1");
//		return null;
//	}
//	public String func(String str) throws Exception{ //impl 2
//		//implementation here
//		return null;
//	}
	public String func(Object str){ //impl 3
		//implementation here
		System.out.println(" from Base # 3");
		return null;
	}
}
