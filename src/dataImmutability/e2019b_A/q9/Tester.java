package dataImmutability.e2019b_A.q9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {
	public static void main(String args[]) {
		
		/**  DataItems1  */
		List<String> data = Arrays.asList("a", "b");
		DataItems1 d1 = new DataItems1(data);
		
		data.set(0, "c");
		System.out.println("d1; " + d1.getData().get(0));	// a
		
		d1.getData().set(0, "c");
		System.out.println("d1; " + d1.getData().get(0));	// c
		
		
		/**  DataItems2  */
		DataItems2 d2 = new DataItems2(Arrays.asList("a", "b"));
		
		d2.getData().set(0, "c");
		System.out.println("d2; " + d2.getData().get(0));	// a
		
		class DataItems2Breach extends DataItems2{
			private List<String> data;	// shadowing
			public List<String> getData() { return this.data; }	// breach
			
			public DataItems2Breach(List<String> data) {
				super(data);
				this.data = new ArrayList<>(data);
			}
		}
			
		
		DataItems2 d2Breach = new DataItems2Breach(Arrays.asList("a", "b"));
			
		d2Breach.getData().set(0, "c");	// code that expects d2 can get d2Breach instead.
		System.out.println("d2Breach; " + d2Breach.getData().get(0));	// c
		
			
		/**  DataItems3  */
		DataItems3 d3 = DataItems3.makeDataItems3(Arrays.asList("a", "b"));
			
		d3.getData().set(0, "c");
		System.out.println("d3; " + d3.getData().get(0));	// a
			
		DataItems3 d3Breach = new DataItems3.DataItems3Nested(Arrays.asList("a", "b"));
		d3Breach.getData().set(0, "c");	// code that expects d3 can get d3Breach instead.
		System.out.println("d3Breach; " + d3Breach.getData().get(0));	// c
		
			
		/**  DataItemsSafe  */
		List<String> data1 = new ArrayList<>();
		data1.add("a"); data1.add("b");
		
		DataItemsSafe dsafe = new DataItemsSafe(data1);
			
		data1.set(0, "c");
		System.out.println("dsafe#1; " + dsafe.getData().get(0));	// a
			
		dsafe.getData().set(0, "c");
		System.out.println("dsafe#2; " + dsafe.getData().get(0));	// a
			
//		class DataItemsSafeBreach extends DataItemsSafe {/*...*/}	// DataItemsSafe is final

	}	
}
