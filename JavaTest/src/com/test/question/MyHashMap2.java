package com.test.question;

public class MyHashMap2 {

	private Entry[] list;
	
	private int index;
	private int containIndex;
	
	public MyHashMap2() {
		this.index = 0;
		this.list = new Entry[4];
	}
	
	public String put(String key, String value) {
		
		if(!containsKey(key) || this.index == 0) {
			
			Entry e = new Entry();

			e.key = key;
			e.value = value;

			this.list[this.index] = e;
			
		} else {
			this.list[this.containIndex].value = value;
		}
		
		index++;
		
		return null;
	}

	public boolean containsKey(String key) {
		
		try {
			for(int i = 0; i < this.index; i++) {

				if(this.list[i].key.equals(key)) {
					this.containIndex = i;
					return true;
				}
			}
			return false;
			
		} catch(NullPointerException e) {
			return false;
		}
	}

	public boolean containsValue(String value) {

		try {
			for(int i = 0; i < this.index; i++) {

				if(this.list[i].value.equals(value)) {
					this.containIndex = i;
					return true;
				}
			}
			return false;

		} catch(NullPointerException e) {
			return false;
		}
	}
	
	public String get(String key) {
		
		String value ="";
		
		if (containsKey(key)) {
			value = this.list[this.containIndex].value;
			
		} else {
			value = "null";
		}
		
		return value;
	}
	
	public int size() {
		return this.index;
	}
	
	public String remove(String key) {

		String tmp = "";

		if(containsKey(key)) {
			tmp = this.list[this.containIndex].value;
		}

		for(int i = this.containIndex; i < this.index - 2; i++) { //TODO 왜 여기는 -2고 MyHashMap은 -1?
			
			this.list[i].key = this.list[i+1].key;
			this.list[i].value = this.list[i+1].value;
			
		}

		this.index--;

		return tmp;
	}
	
	public void clear() {
		this.index = 0;
	}
	
}

class Entry {
	public String key;
	public String value;
}
