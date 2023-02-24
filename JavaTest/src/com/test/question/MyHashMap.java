package com.test.question;

public class MyHashMap {
	
	private String[] keys;
	private String[] values;
	private int index;
	private int containIndex;
	
	public MyHashMap() {
		this.index = 0;
		this.keys = new String[4];
		this.values = new String[4];
	}
	
	public String put(String key, String value) {
		
		if(!containsKey(key) || this.index == 0) {
			this.keys[this.index] = key;
			this.values[this.index] = value;
		} else {
			this.values[this.containIndex] = value;
		}
		
		index++;
		
		return null;
	}

	public boolean containsKey(String key) {
		
		try {
			for(int i = 0; i < this.index; i++) {

				if(this.keys[i].equals(key)) {
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

				if(this.values[i].equals(value)) {
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
			value = this.values[this.containIndex];
			
		} else {
			value = "null";
		}
		
		return value;
	}
	
	public int size() {
		return this.index;
	}
	
	public String remove(String key) {

		int removeIndex = 0;
		String tmp = "";
		
		for(int i = 0; i < this.index; i++) {

			if(this.keys[i].equals(key)) {
				removeIndex = i;
				tmp = this.values[i];
				break;
			}
		}
		
		for(int i = removeIndex; i < this.index - 1; i++) {
			
			this.keys[i] = this.keys[i+1];
			this.values[i] = this.values[i+1];
			
		}
		
		this.index--;
		
		return tmp;
	}
	
	public void clear() {
		this.index = 0;
	}
	
	
	@Override
	public String toString() {
		String tmp = "";
		
		tmp += String.format("index: %d\n", this.index);
		tmp += String.format("length: %d\n", this.keys.length);
		
		for (int i = 0; i < this.keys.length; i++) {
			tmp += String.format("  [%s] = %s\n", this.keys[i], this.values[i]);
		}
		
		return tmp;
	}
	
}

class Entry {
	public String key;
	public String value;
}
