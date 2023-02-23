package com.test.question;

public class MyQueue {
	
	private String[] queue;
	private int index;
	private final String ERROR_MSG = "반환할 값이 없습니다.";
	
	
	
	public MyQueue() {
		this.index = 0;
	}

	public boolean add(String value) {
		
		if (this.index == 0) {
			this.queue = new String[4];
		}
		
		if(this.index == this.queue.length) {
			this.queue = newQueue(this.queue, this.index);
		}
	
		this.queue[this.index] = value;
		this.index++;
		
		return true;
	}
	
	private String[] newQueue(String[] queue, int addIndex) {
		
		String[] queue2 = new String[addIndex * 2];
		
		copyList(queue, queue2);
		
		return queue2;
	}

	private void copyList(String[] queue, String[] queue2) {
		
		int length = queue.length > queue2.length ? queue2.length : queue.length;
		
		for(int i = 0; i < length; i++) { //깊은 복사
			queue2[i] = queue[i];
		}
		
	}
	
	public String poll() {
		
		try {
			if(index <= 0) {
				throw new NegativeArraySizeException();
			}
			
			String tmp = this.queue[0];
			
			for(int i = 0; i < this.index - 1; i++) {
				this.queue[i] = this.queue[i+1];
			}
			
			index--;
			
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
			
			if(index <= 0) {
				throw new NegativeArraySizeException();
			}
			
			return queue[0];
			
		} catch(NegativeArraySizeException e) {
			return e.toString() + ": " + ERROR_MSG;
		}
		
	}
	
	public void trimToSize() {
		
		String[] queue2 = new String[this.index];
		
		copyList(this.queue, queue2);
		
		this.queue = queue2;
	}
	
	public void clear() {
		this.index = 0;
		this.queue = new String[4];
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		
		sb.append(String.format("index: %d\n", this.index));
		sb.append(String.format("length: %d\n", this.queue.length));
		
		//실제로 사용자가 보게 하려면 this.list.length 대신 this.index를 사용할 것
		for(int i = 0; i < this.queue.length; i++) {
			
			sb.append(String.format("\t%d: %s\n", i, this.queue[i]));
			
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
}
