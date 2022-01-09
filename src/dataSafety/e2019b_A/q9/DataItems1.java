package dataSafety.e2019b_A.q9;

import java.util.ArrayList;
import java.util.List;

// unsafe because it exposes its data reference
public final class DataItems1 {
	private List<String> data;
	public List<String> getData() { return data; }	// breach
	
	public DataItems1(List<String> data) {
		this.data = new ArrayList<>(data);	// String is immutable so this is enough
											// otherwise, have to deep copy each element in the list.
	}
	
}
