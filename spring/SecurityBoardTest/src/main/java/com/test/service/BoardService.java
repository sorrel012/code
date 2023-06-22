package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.domain.BoardDTO;

@Service
public interface BoardService {
	
	//글쓰기
	int add(BoardDTO dto);
	
	//목록보기
	List<BoardDTO> list();
	
	//상세보기
	BoardDTO get(String seq);
	
	//수정하기
	int edit(BoardDTO dto);
	
	//삭제하기
	int del(String seq);

}
