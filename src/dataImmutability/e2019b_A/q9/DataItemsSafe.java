package dataImmutability.e2019b_A.q9;

import java.util.ArrayList;
import java.util.List;

// safe as long as DataItemsSafe itself does not add any methods
// or inner classes that mute or expose data.

// meaning, it's safe in the sense that
// the user code cannot receive an object that "is-a" DataItemsSafe,
// but allows to mute the field data
// (as long as DataItemsSafe itself does't allow to mute data).
public final class DataItemsSafe {
	private List<String> data;
	public List<String> getData() { return new ArrayList<>(data); }	// String is immutable so this is enough
	
	public DataItemsSafe(List<String> data) {
		this.data = new ArrayList<>(data);	// String is immutable so this is enough
	}
	
//	public void dataMuter(int i, String s) { data.set(i, s); }	// this still can mute data
//	public List<String> dataExposer() { return data; }	// this still can expose data
	
//	public class Inner {
//		public void dataMuter(int i, String s) { data.set(i, s); }	// this still can mute data
//		public List<String> dataExposer() { return data; }	// this still can expose data
//	}
}
