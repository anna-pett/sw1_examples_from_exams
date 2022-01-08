package nestedClasses.e2020a_A.q12;

public class Car {
	private int year;
	private Engine engine = new Engine(this);
	
	public Car(int year) { this.year = year; }
	
	public class Engine{
		public Car car;		// changing to private won't change the result
		
		public Engine(Car car) { this.car = car; }
		
		public int f(){ return year; }		// of the enclosing class. same as Car.this.year
	}
	
	public static void main(String[] args) {
		Car c1 = new Car(1960);
		Car c2 = new Car(1970);
		c2.engine.car = c1.engine.car; // *
		System.out.println(c2.engine.f()); // **
		
		//added code
		System.out.println(c2.engine.car.year);
	}
}
