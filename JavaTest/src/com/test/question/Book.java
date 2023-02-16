package com.test.question;

/*

요구사항] Book 클래스를 설계하시오.

*/

public class Book {

    private String title;
    private int price;
    private String author;
    private String publisher;
    private String pubYear = "2019";
    private String isbn;
    private int page;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        if(title.length() <= 50) {
            this.title = title;

        } else {
            System.out.println("제목은 50자 이내여야 합니다.");
        }

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {

        if(price >= 0 && price < 1000000) {
            this.price = price;

        } else {
            System.out.println("가격은 0~1000000원 사이여야 합니다.");
        }

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {

        if(page >= 1) {
            this.page = page;
        } else {
            System.out.println("페이지 수는 1 이상이어야 합니다.");
        }

    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String info() {

        String information = "";

        information = String.format("제목: %s\n"
                                    + "가격: %,d원\n"
                                    + "저자: %s\n"
                                    + "출판사: %s년\n"
                                    + "발행년도: %s\n"
                                    + "ISBN: %s\n"
                                    + "페이지: %,d장"
                                    , title, price, author, publisher
                                    , pubYear, isbn, page);

        return information;
    }

}
