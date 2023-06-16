package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.domain.MyBatisDTO;
import com.test.persistence.MyBatisDAO;

@Controller
public class MyBatisController {
   
   //MyBatisController > (의존) > MyBatisDAO
   
   @Autowired
   private MyBatisDAO dao;
   
   
   @GetMapping("/test.do")
   public String test() {
      
      System.out.println(this.dao == null);
      
      this.dao.test();
      
      return "list";
   }
   
   //반환값(X), 매개변수(X)
   
   @GetMapping("/m1.do")
   public String m1() {
      
      this.dao.m1();
      
      return "list";
   }
   
   
   @GetMapping("/add.do")
   public String add() {
	   
	   return "add";
   }
   
   @PostMapping("/addok.do")
   public String addok(MyBatisDTO dto) {
	   
	   //this.dao.add(dto);
	   this.dao.add(dto);
	   
	   return "addok";
   }
   
   @GetMapping("/m2.do")
   public String m2(Model model, String seq) {
	   
	   //삭제
	   //- delete from tblMyBatis where seq = 5
      
	   int result = this.dao.m2(seq);
	   
	   model.addAttribute("result", result);
	   
	   return "list";
   }

   @GetMapping("/m3.do")
   public String m3() {
      
	   //3 하하하 37 서울시 동대문구 ,
	   // > 수정하기
	   
	   Map<String,String> map = new HashMap<String,String>();
	   map.put("seq", "3");
	   map.put("name", "헤헤헤");
	   map.put("address", "서울시 동대문구");
	   
	   int result = dao.m3(map);
	   
	   return "list";
   }
   
   @GetMapping("/m4.do")
   public String m4(Model model) {
      
	   //단일값 반환(1행 1열)
	   //- select count(*) from tblMyBatis
	   
	   int count = dao.m4();
	   
	   model.addAttribute("count", count);
	   
	   return "list";
   }
   
   
   @GetMapping("/m5.do")
   public String m5(Model model, String seq) {
	   
	   //다중값 반환(1행 n열)
	   //- select * from tblMyBatis where seq = 1
	   
	   MyBatisDTO dto = dao.m5(seq);
	   
	   model.addAttribute("dto", dto);
	   
	   return "list";
   }
   
   @GetMapping("/m6.do")
   public String m6(Model model) {
	   
	   //다중 반환(n행 1열)
	   //- select name from tblMyBatis where seq = 1
	   
	   List<String> names = dao.m6();
	   
	   model.addAttribute("names", names);
	   
	   return "list";
   }
	   
   @GetMapping("/m7.do")
   public String m7(Model model) {

	   //다중 반환(n행 n열)
	   //- select * from tblMyBatis
	   
	   List<MyBatisDTO> list = dao.m7();
	   
	   model.addAttribute("list", list);
	   
	   return "list";
   }
   
   @GetMapping("/m8.do")
   public String m8(Model model, String table) {
	   
	   //m8.do?table=tblMyBatis
	   //- select count(*) from tblMyBatis
	   
	   //m8.do?table=employees
	   //- select count(*) from employees
	   
	   int count = dao.m8(table);
	   
	   model.addAttribute("count", count);
	   
	   return "list";
   }
   
   @GetMapping("/m9.do")
   public String m9(Model model, int age) {
	   
	   //m9.do?age=25
	   //- select * from tblMyBatis where age > 25
	   
	   List<MyBatisDTO> list = dao.m9(age);
	   
	   model.addAttribute("list", list);
	   
	   return "list";
   }
   
   @GetMapping("/m10.do")
   public String m10(Model model, String word) {
	   
	   //m10.do?word=검색어
	   //- select * from tblMyBatis where address like '%검색어%'
	   
	   List<MyBatisDTO> list = dao.m10(word);
	   
	   model.addAttribute("list", list);
	   
	   return "list";
   }
   
   @GetMapping("/m11.do")
   public String m11(Model model) {
	   
	   //insert + dto
	   //방금 insert한 Pk를 가져오는 방법
	   
	   MyBatisDTO dto = new MyBatisDTO();
	   
	   dto.setName("장보고");
	   dto.setAge("23");
	   dto.setAddress("바닷가");
	   dto.setGender("m");
	   
	   int result = dao.m11(dto);
	   
	   model.addAttribute("result", result);
	   
	   return "result";
   }

   @GetMapping("/m12.do")
   public String m12(Model model, String type) {
	   
	   //MyBatis 동적 쿼리
	   // - 동적 태그
	   // - JSTL 유사
	   
	   //1. if
	   //2. choose(when, otherwise)
	   //3. trim(where, set)
	   //4. foreach
	   
	   //m12.do?type=1 > select first_name from employees
	   //m12.do?type=2 > select last_name from employees
	   
	   List<String> elist = dao.m12(type);
	   
	   model.addAttribute("elist", elist);
      
       return "list";
   }
   
   @GetMapping("/m13.do")
   public String m13(Model model, String column, String word) {
	   
	   //1. 이름 m13.do?column=name&word=홍길동
	   //2. 주소 m13.do?column=address&word=서울
	   //3. 나이 m13.do?column=age&word=25
	   
	   Map<String,String> map = new HashMap<String, String>();
	   
	   map.put("column", column);
	   map.put("word", word);
	   
	   List<MyBatisDTO> list = dao.m13(map);
	   
	   model.addAttribute("list", list);
	   	   
       return "list";
   }
   
   @GetMapping("/m14.do")
   public String m14(Model model, String address) {
	   
	   List<MyBatisDTO> list= dao.m14(address);
	   
	   model.addAttribute("list", list);
      
       return "list";
   }
   
   @GetMapping("/m15.do")
   public String m15(Model model) {
	   
	   //검색어
	   List<String> word = new ArrayList<String>();
	   
	   word.add("홍길동");
	   word.add("아무개");
	   
	   List<MyBatisDTO> list = dao.m15(word);
	   
	   model.addAttribute("list", list);
	         
       return "list";
   }
   
   /*
   @GetMapping("/m1.do")
   public String m1() {
      
       return "list";
   }
   */

}