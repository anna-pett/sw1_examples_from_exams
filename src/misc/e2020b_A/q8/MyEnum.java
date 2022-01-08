package misc.e2020b_A.q8;

class MyEnum{
	public static final MyEnum CLAUDE = new MyEnum("claude");
	public static final MyEnum AUGUSTE = new MyEnum("Auguste");
	public static final MyEnum EDGAR = new MyEnum("Edgar");
	
	String name;
	
	private MyEnum(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
