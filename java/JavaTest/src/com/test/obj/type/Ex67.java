package com.test.obj.type;

public class Ex67 {

}


interface AAA {
	void aaa();
}

abstract class BBB {
	public int b;
	abstract void bbb();
}

abstract class FFF extends BBB {
	public int f;
}

class CCC {
	public int c;
}

interface DDD extends AAA {
	void ddd();
}

class EEE implements DDD {

	@Override
	public void aaa() {
		
	}

	@Override
	public void ddd() {
		
	}
	
}

abstract class GGG implements AAA {
	
}
