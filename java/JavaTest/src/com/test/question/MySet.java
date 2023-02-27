package com.test.question;

public class MySet {
	
	private String[] set;
	private int index;
	private int checkIndex;
	private int containIndex;
	
	public MySet() {
		this.index = 0;
	}
	
	public boolean add(String value) {
		
		if (this.index == 0) {
			this.set = new String[4];
		}
		
		if(this.index == this.set.length) {
			this.set = newSet(this.set, this.index);
		}
		
		//인자값을 배열에 차례대로 넣기 > Append
		this.set[index] = value;
		this.index++;
		
		return true;
	}

	private String[] newSet(String[] set, int index) {

		String[] set2 = new String[index * 2];

		copyList(set, set2);

		return set2;
	}

	private void copyList(String[] set, String[] set2) {

		int length = set.length > set2.length ? set2.length : set.length;

		for(int i = 0; i < length; i++) {
			set2[i] = set[i];
		}

	}

	public int size() {
		return this.index;
	}
	
	public boolean remove(String value) {
		
		if(containsValue(value)) {
			
			for(int i = this.containIndex; i < this.index - 1; i++) {
				this.set[i] = this.set[i+1];
			}
			
			this.index--;
			
			return true;
		}
		
		return false;
		
	}
	
	public boolean containsValue(String value) {

		try {
			for(int i = 0; i < this.index; i++) {

				if(this.set[i].equals(value)) {
					this.containIndex = i;
					return true;
				}
			}
			return false;

		} catch(NullPointerException e) {
			return false;
		}
	}
	
	public void clear() {
		this.index = 0;
	}

	public boolean hasNext() {
		
		boolean result = false;
		
		if(this.checkIndex < this.index) {
			result = true;
			this.checkIndex++;
		}
		
		return result;
	}
	
	public String next() {
		return set[this.checkIndex - 1];
	}
	
}
