package nestedClasses.e2020a_B.q17;

public class Outer {
	private void f() { new NS().m(); }
	private static void s() { /*new NI().n();*/ }
	private static class NS {
		private void m() {
//			f();
			s();
		}
	}
	
	private class NI {
		private void n() {
			f();
			s();
		}
	}
}
