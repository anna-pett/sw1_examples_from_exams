package polymorphism.overloading;

public class SuperClass {
	public void doSomething(Integer i) {
        System.out.println("SUPER: INTEGER");
    }

    public void doSomething(Object o) {
        System.out.println("SUPER: OBJECT");
    }
    
    private void doSomething(String[] o) {
        System.out.println("SUPER: ARR");
    }

    public static void main (String[] args) {
		Object i = Integer.valueOf(2);
        Object o = new Object(); 
        SuperClass sc = new SuperClass();
        sc.doSomething(i);
        sc.doSomething(o); 
        
        System.out.println("***");
        Object arr = new String[]{"", ""};
        sc.doSomething(arr);
        SubClass sub = new SubClass();
        sub.doSomething(arr);
        System.out.println("***");
        String[] arr2 = new String[]{"", ""};
        sc.doSomething(arr2);
        sub.doSomething(arr2);
    } 
}
