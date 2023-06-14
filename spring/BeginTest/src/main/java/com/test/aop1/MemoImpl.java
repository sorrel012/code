package com.test.aop1;

public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		
		System.out.println("메모 쓰기: " + memo);
		
		//로그 기록
//		Calendar now = Calendar.getInstance();
//		System.out.printf("[LOG][%tF %tT] 로그를 기록합니다.\n", now, now) ;
		
//		Logger log  = new Logger();
//		log.log();
	}

	@Override
	public String read(int seq) throws Exception {
		
		if (seq < 10) {
			System.out.println("메모 읽기");
		} else {
			throw new Exception("존재하지 않는 메모");
		}
		
		return "홍길동";
	}

	@Override
	public boolean edit(int seq, String memo) {
		
		System.out.println("메모 수정: " + memo);

		return true;
	}

	@Override
	public boolean del(int seq) {
		
		System.out.println("메모 삭제: " + seq);
		
		return true;
	}

}
