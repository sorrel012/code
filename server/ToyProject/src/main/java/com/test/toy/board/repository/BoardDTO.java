package com.test.toy.board.repository;

import lombok.Data;

@Data
public class BoardDTO {
    
    private String seq;
    private String subject;
    private String content;
    private String id;
    private String regdate;
    private String readcount;
    
    private String name; //작성자명
    
    private double isnew; //최신글 여부
    
    private String ccnt; //현재글에 달린 댓글 개수
    
}
