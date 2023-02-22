package com.test.obj.type;

public class Ex69_Generic {

	public static void main(String[] args) {

		//요구사항] 클래스 설계
		
		WrapperInt n1 = new WrapperInt(10);
		
		System.out.println(n1.getData());
		System.out.println(n1.getData() * 2);
		System.out.println(n1.toString());
		System.out.println();
		

		WrapperObject n2 = new WrapperObject(20);	//업캐스팅
		System.out.println(n2.getData());
		System.out.println((int)n2.getData() * 2);	//다운캐스팅
		System.out.println(n2.toString());
		System.out.println();
		
		
		WrapperString s1 = new WrapperString("홍길동");
		
		System.out.println(s1.getData());
		System.out.println(s1.getData().length());
		System.out.println(s1.toString());
		System.out.println();
		
		WrapperObject s2 = new WrapperObject("홍길동");			//업캐스팅
		System.out.println(s2.getData());
		System.out.println(((String)s2.getData()).length());	//다운캐스팅
		System.out.println(s2.toString());
		System.out.println();
		

		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1.getData());
		System.out.println(b1.getData() ? "참" : "거짓");
		System.out.println(b1.toString());
		System.out.println();
		
		WrapperObject b2 = new WrapperObject(true);				//업캐스팅
		System.out.println(b2.getData());
		System.out.println((boolean)b2.getData() ? "참" : "거짓");	//다운캐스팅
		System.out.println(b2.toString());
		System.out.println();
		
	} //main
	
} //Main

class WrapperInt {
	
	private int data; //클래스의 중심이 되는 데이터

	public WrapperInt(int data) {
		this.setData(data);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "date = " + this.data;
	}
		
}

class WrapperString {
	
	private String data; //클래스의 중심이 되는 데이터

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public WrapperString(String data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "date = " + this.data;
	}
		
}

class WrapperBoolean {
	
	private boolean data; //클래스의 중심이 되는 데이터

	public boolean getData() {
		return data;
	}


	public void setData(boolean data) {
		this.data = data;
	}


	public WrapperBoolean(boolean data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "date = " + this.data;
	}
		
}

class WrapperObject {
	
	private Object data;

	public WrapperObject(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[data=" + data + "]";
	}
		
}
