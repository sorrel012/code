package com.test.question;

public class MyArrayList {

	private String[] list; //보조
	private int index; //★★★★★★★★★★★★★★★★★주인공
	
	public MyArrayList() {
		this.index = 0;
	}
	
	public boolean add(String value) {
		
		if (this.index == 0) {
			this.list = new String[4];
		}
		
		if(this.index == this.list.length) {
			this.list = newList(this.list, this.index);
		}
		
		//인자값을 배열에 차례대로 넣기 > Append
		this.list[index] = value;
		this.index++;
		
		return true;
	}

	public int size() {
		
		return this.index;
	}
	
	
	public String get(int index) {
		
		try {
			return this.list[index];
		} catch(ArrayIndexOutOfBoundsException e) {
			return "입력 가능 범위를 벗어났습니다.";
		}
		
	}

	public void set(int index, String value) {
		try {
			this.list[index] = value;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("입력 가능 범위를 벗어났습니다.");
		}
		
	}
	
	public String remove(int index) {
		
		try {
			String value = this.list[index];
			
			for(int i = index; i < this.index - 1; i++) {
				list[i] = list[i+1];
			}
			
			this.index--;
			
			return value;
		} catch(ArrayIndexOutOfBoundsException e) {
			return "입력 가능 범위를 벗어났습니다.";
		}
	}
	
	public boolean add(int index, String value) {
		
		for(int i = index; i < this.index - 1; i++) {
			list[i+1] = list[i];
		}
		
		list[index] = value;
		
		this.index++;
		
		return true;
	}
	
	public int indexOf(String value) {
		
		for(int i = 0; i < this.index; i++) {
			if(this.list[i].equals(value)) {
				return i;
			}
		}
		
		return -1;
	}

	public int lastIndexOf(String value) {

		for(int i = this.index - 1; i >= 0 ; i--) {
			if(this.list[i].equals(value)) {
				return i;
			}
		}

		return -1;
	}
	
	public void clear() {
		this.list = new String[4];
		this.index = 0;
	}
	
	public void trimToSize() {
		
		String[] list2 = new String[index];
		
		copyList(this.list, list2);
		
		this.list = list2;
	}

	private String[] newList(String[] list, int index) {
		
		String[] list2 = new String[index * 2];
		
		copyList(list, list2);
		
		return list2;
	}

	private void copyList(String[] list, String[] list2) {
		
		int length = list.length > list2.length ? list2.length : list.length;
		
		for(int i = 0; i < length; i++) {
			list2[i] = list[i];
		}
		
	}
	
}
