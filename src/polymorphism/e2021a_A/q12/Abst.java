package polymorphism.e2021a_A.q12;

public abstract class Abst{
	public abstract int getFirst();
	
	private int getSecond(){ //*
		return 3;
	}
	
	public void printRes(){
		System.out.print(getFirst() + getSecond()); //**
	}
}
