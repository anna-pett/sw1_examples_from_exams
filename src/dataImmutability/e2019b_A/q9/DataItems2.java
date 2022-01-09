package dataImmutability.e2019b_A.q9;

import java.util.ArrayList;
import java.util.List;

// not final and has a public constructor

// unsafe because it can be extended
public class DataItems2 {
	private List<String> data;
	public List<String> getData() { return new ArrayList<>(data); }	// String is immutable so this is enough
	
	public DataItems2(List<String> data) {
		this.data = new ArrayList<>(data);	// String is immutable so this is enough
	}
}
