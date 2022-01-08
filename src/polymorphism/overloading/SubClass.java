package polymorphism.overloading;

public class SubClass extends SuperClass {
	@Override
	public void doSomething(Integer i) {
        System.out.println("SUB: INTEGER");
    }

	@Override
    public void doSomething(Object o) {
        System.out.println("SUB: OBJECT");
    }
    
    public void doSomething(String o) {
        System.out.println("SUB: STRING");
    }


    public static void main (String[] args) {
		Object i = Integer.valueOf(2);
        Object o = new Object(); 
        SuperClass sup = new SuperClass();
        SuperClass supsub = new SubClass();
        SubClass sub = new SubClass();

        System.out.println("------1------");
        sup.doSomething(i);
        sup.doSomething(o);
        supsub.doSomething(i);
        supsub.doSomething(o);
        sub.doSomething(i);
        sub.doSomething(o);
        
        String s = "";
        
        System.out.println("------2------");
        sup.doSomething(s);
        supsub.doSomething(s);
        sub.doSomething(s);
        
        Object s1 = "";
        
        System.out.println("------3------");
        sup.doSomething(s1);
        supsub.doSomething(s1);
        sub.doSomething(s1);
        
        System.out.println("------4------");
        String[] arr = new String[]{"", ""};
        sup.doSomething(arr);
        supsub.doSomething(arr);
        sub.doSomething(arr);
    }

}
