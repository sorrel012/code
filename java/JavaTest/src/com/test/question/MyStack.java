package com.test.question;

public class MyStack {
	
	private String[] stack;
	private int index;
	private final String ERROR_MSG = "반환할 값이 없습니다.";
	
	
	
	public MyStack() {
		this.index = 0;
	}

	public boolean push(String value) {
		
		if (this.index == 0) {
			this.stack = new String[4];
		}
		
		if(this.index == this.stack.length) {
			this.stack = newStack(this.stack, this.index);
		}
	
		this.stack[this.index] = value;
		this.index++;
		
		return true;
	}
	
	private String[] newStack(String[] stack, int index) {
		
		String[] stack2 = new String[index * 2];
		
		copyList(stack, stack2);
		
		return stack2;
	}

	private void copyList(String[] stack, String[] stack2) {
		
		int length = stack.length > stack2.length ? stack2.length : stack.length;
		
		for(int i = 0; i < length; i++) { //깊은 복사
			stack2[i] = stack[i];
		}
		
	}
	
	public String pop() {
		
		try {
			if(this.index <= 0) {
				throw new NegativeArraySizeException();
			}
			
			String tmp = this.stack[this.index - 1];
			
			this.index--;
			
			return tmp;
			
		} catch(NegativeArraySizeException e) {
			return e.toString() + ": " + ERROR_MSG;
		}
		
	}
	
	public int size() {
		return this.index;
	}
	
	public String peek() {
		try {
			
			if(this.index <= 0) {
				throw new NegativeArraySizeException();
			}
			
			return stack[this.index - 1];
			
		} catch(NegativeArraySizeException e) {
			return e.toString() + ": " + ERROR_MSG;
		}
		
	}
	
	public void trimToSize() {
		
		String[] stack2 = new String[this.index];
		
		copyList(this.stack, stack2);
		
		this.stack = stack2;
	}
	
	public void clear() {
		this.index = 0;
	}
	
}
