package com.test.question;

public class Note {

    private String size;
    private String color;
    private int page;
    public String owner;
    private int price = 500; //기본값

    public void setSize(String size) {

        String[] sizes = { "A3", "A4", "A5", "B3", "B4", "B5" };
        int count = 0;

        for(int i = 0; i < sizes.length; i++) {
            if(size.equals(sizes[i])) {
                count++;
                break;
            }
        }

        if(count == 1) {
            this.size = size;

        } else {
            System.out.println("잘못된 크기 대입");
        }

    } //setSize

    public void setColor(String color) {

        String[] colors = { "검정색", "흰색", "노란색", "파란색" };
        int count = 0;

        for(int i = 0; i < colors.length; i++) {
            if(color.equals(colors[i])) {
                count++;
                break;
            }
        }

        if(count == 1) {
            this.color = color;

        } else {
            System.out.println("잘못된 색상 대입");
        }

    } //setColor

    public void setPage(int page) {

        if(page >= 10 && page <= 200) {
            this.page = page;

        } else {
            System.out.println("잘못된 페이지수 대입");
        }

    } //setPage


    public void setOwner(String owner) {

    	if(checkLength(owner) && checkKorean(owner)) {
    		this.owner = owner;

    	} else {
    		System.out.println("잘못된 이름 대입");
    	}


    } //setOwner

    public boolean checkKorean(String owner) {

    	for (int i = 0; i <owner.length(); i++) {

    		char c = owner.charAt(i);

    		if (c < '가' || c > '힣') {
    			return false;
    		}
    	}

    	return true;

    } //checkKorean

    public boolean checkLength(String owner) {

    	if (owner.length() >= 2 && owner.length() <= 5) {
    		return true;

    	} else {
    		return false;
    	}

    } //checkLength


    public String getThickness() { //두께

        if (this.page >= 10 && this.page <= 50) {
            return "얇은";

        } else if (this.page >= 51 && this.page <= 100) {
            return "보통";

        } else {
            return "두꺼운";
        }

    } //getThickness

    private void calSizePrice() { //Q.Getter Setter만 사용해야?

    	switch(this.size) {
    	case "A3":
    		price += 300;
    		break;

    	case "A4":
    		price += 200;
    		break;

    	case "B3":
    		price += 500;
    		break;

    	case "B4":
    		price += 300;
    		break;

    	case "B5":
    		price += 100;
    		break;
    	}

    } //calSizePrice

    private void calColorPrice() {

    	switch(this.color) {
    	case "검정색":
    		price += 100;
    		break;

    	case "노란색":
    	case "파란색":
    		price += 200;
    		break;
    	}

    } //calColorPrice

    private void calPagePrice() {

    	if(this.page > 10) {
    		price += (this.page - 10) * 10;
    	}

    } //calPagePrice

    public String info() {

        String information = "";

        if (this.owner == null) {
        	information += "■■■■■■ 노트 정보 ■■■■■■\n";
        	information += "주인 없는 노트\n";
        	information += "■■■■■■■■■■■■■■■■■■■■■";

        } else {
        	calSizePrice();
        	calColorPrice();
        	calPagePrice();

        	information += "■■■■■■ 노트 정보 ■■■■■■\n";
        	information += String.format("소유자: %s\n", this.owner);
        	information += String.format("특성: %s %s %s노트\n", this.color, getThickness(), this.size);
        	information += String.format("가격: %,d원\n", this.price);
        	information += "■■■■■■■■■■■■■■■■■■■■■";
        }

        return information; //Stringbuilder.toString()

    } //info

}
