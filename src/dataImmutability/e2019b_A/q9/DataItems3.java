package dataImmutability.e2019b_A.q9;

import java.util.ArrayList;
import java.util.List;

// can't be extended from outside because the only constructor is private,
// does deep copy in constructor so can't be modified by changing the underlying data given to the constructor,
// does deep copy in getter, so doesn't expose its data reference
// has a private constructor, so has full control over created instances, but

// unsafe because it has a public nested class that extends it
public class DataItems3 {
		private List<String> data;
		public List<String> getData() { return new ArrayList<>(data); }	// String is immutable so this is enough
		
		private DataItems3(List<String> data) {
			this.data = new ArrayList<>(data);	// String is immutable so this is enough
		}
		
		static public DataItems3 makeDataItems3(List<String> data) {
			return new DataItems3(data);
		}
		
		public static class DataItems3Nested extends DataItems3 {
			public  DataItems3Nested(List<String> data) { super(data); }
			
			public List<String> getData() { return super.data; }	// breach
		}
}
