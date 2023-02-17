package com.test.question;

public class Refrigerator {
	
	public Item[] items = new Item[100];

	public void add(Item item) {
		
		int index = 0;
		
		for(int i = 0; i < 100; i++) {
			
			if(this.items[i] == null) {
				this.items[i] = item;
				index = i;
				break;
			}
			
		}
		
		System.out.printf("'%s'를 냉장고에 넣었습니다.\n", items[index].getName());
		
	} //add

	public Item get(String name) {
		
		int index = 0;

		for(int i = 0; i < 100; i++) {

			if(this.items[i].getName().equals(name)) {
				index = i;
				break;
			}

		}
		
		Item tmp = items[index];
		items[index] = null;
		
		return tmp;
		
	} //get

	public int count() {
		
		int total = 0;
		
		for(int i = 0; i < 100; i++) {
			
			if(this.items[i] != null) {
				total++;
			}
			
		}
		return total;
		
	} //count

	public void listItem() {
		
		System.out.println("\n[냉장고 아이템 목록]");
		

		for(int i = 0; i < 100; i++) {
			
			if(this.items[i] != null) {
				System.out.printf("%s(%s)\n"
								, this.items[i].getName()
								, this.items[i].getExpiration());
			}
			
		}
		
	} //listItem
	
}
