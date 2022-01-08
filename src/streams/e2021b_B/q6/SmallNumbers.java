package streams.e2021b_B.q6;

import java.util.function.Supplier;

public class SmallNumbers implements Supplier<Integer>{
	int currNum;
	public Integer get() {
		currNum++;
		if(currNum >= 6) {currNum = 0;}
		return currNum;
	}
}