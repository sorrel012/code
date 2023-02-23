package com.test.question;

public class MyArrayList {

	private String[] list; //보조
	private int index; //★★★★★★★★★★★★★★★★★주인공
	private final String errorMsg = "입력 가능 범위를 벗어났습니다.";
	
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
			
			if(index < 0 || index > this.index) {
				throw new IndexOutOfBoundsException();
			}
			
			return this.list[index];
			
		} catch(IndexOutOfBoundsException e) {
			return errorMsg;
		}
		
	}

	public void set(int index, String value) {

		try {

			if(index < 0 || index > this.index) {
				throw new IndexOutOfBoundsException();
			}
			
			this.list[index] = value;
			
		} catch(IndexOutOfBoundsException e) {
			System.out.println(errorMsg);
		}
		
	}
	
	public String remove(int index) {

		try {

			if(index < 0 || index > this.index) {
				throw new IndexOutOfBoundsException();
			}
			
			String value = this.list[index];

			for(int i = index; i < this.index - 1; i++) {
				list[i] = list[i+1];
			}

			this.index--;

			return value;
			
		} catch(IndexOutOfBoundsException e) {
			return errorMsg;
		}
	}
	
	//TODO index의 범위는 연속적이어야 하는가?
	//ex) 배열 길이 8, 현재 index 5, 9번째에 값을 넣으려고 함 > 에러 처리? or 새 배열 생성?
	// > class 설명 보니 새로 하는 듯 하긴 한데..
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
		
		for(int i = 0; i < length; i++) { //깊은 복사
			list2[i] = list[i];
		}
		
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		
		sb.append(String.format("index: %d\n", this.index));
		sb.append(String.format("length: %d\n", this.list.length));
		
		for(int i = 0; i < this.list.length; i++) {
			
			sb.append(String.format("\t%d: %s\n", i, this.list[i]));
			
		}
		
		sb.append("\n");
		
		return sb.toString();
	}
	
}
