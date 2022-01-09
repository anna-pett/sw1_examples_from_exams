package polymorphism.overloading;

import java.util.List;

public class Base {
	public void doSomething(Integer i) {
        System.out.println("SUPER: INTEGER");
    }

    public void doSomething(Object o) {
        System.out.println("SUPER: OBJECT");
    }
    
    private void doSomething(String[] o) {
        System.out.println("SUPER: ARR");
    }
    
    public String genFunc(List<String> s) { return null; };

    public static void main (String[] args) {
		Object i = Integer.valueOf(2);
        Object o = new Object(); 
        Base sc = new Base();
        sc.doSomething(i);
        sc.doSomething(o); 
        
        System.out.println("***");
        Object arr = new String[]{"", ""};
        sc.doSomething(arr);
        Sub sub = new Sub();
        sub.doSomething(arr);
        System.out.println("***");
        String[] arr2 = new String[]{"", ""};
        sc.doSomething(arr2);
        sub.doSomething(arr2);
    } 
}
