package constructors.e2022a_A.q13;

public abstract class MyAbstract implements MyInterface {
    String id;
    String name;


    //Constructor for Abstract class
    public MyAbstract(String id, String name){
        this.id = id;
        this.name = name;
    }

    //All functions are implemented, no abstract functions
    @Override
    public void printID() {
        System.out.println(this.id);
    }

    @Override
    public void printName() {
        System.out.println(this.name);

    }
}
