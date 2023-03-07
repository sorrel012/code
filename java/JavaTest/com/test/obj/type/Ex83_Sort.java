package com.test.obj.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ex83_Sort {

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
		m7();

	} //main

	private static void m7() {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		nums.add(5);
		nums.add(4);
		nums.add(2);
		nums.add(1);
		nums.add(3);

		System.out.println("정렬 전 : " + nums);
		
		nums.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		
		System.out.println("정렬 후 : " + nums);
		
	}

	private static void m6() {
		
		Student[] list = new Student[5];
		
		list[0] = new Student("가가가", 100, 90, 80);
		list[1] = new Student("나나나", 60, 70, 80);
		list[2] = new Student("라라라", 90, 90, 100);
		list[3] = new Student("다다다", 80, 90, 70);
		list[4] = new Student("마마마", 60, 60, 70);
		
		Arrays.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o2.getKor() - o1.getKor();
			}
		});
		
		System.out.println("국어 점수 기준 내림차순 정렬: " + Arrays.toString(list));

		Arrays.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return (o2.getKor() + o2.getEng() + o2.getMath())
						- (o1.getKor() + o1.getEng() + o1.getMath());
			}
		});
		
		System.out.println("총점 기준 내림차순 정렬: " + Arrays.toString(list));
		
		
		
	}

	private static void m5() {
		
		String[] names = { "홍길동", "아무개", "하하하", "가가가", "나나나", "김민", "남궁재민" };
		
		//가나다순 > 오름차순
		Arrays.sort(names);
		System.out.println("가나다 기준 오름차순 정렬 :" + Arrays.toString(names));
		
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		System.out.println("가나다 기준 내림차순 정렬 :" + Arrays.toString(names));
		
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		System.out.println("이름 길이 기준 오름차순 정렬 :" + Arrays.toString(names));
		
	}

	private static void m4() {
		
		Integer[] nums = { 1, 5, 6, 4, 2, 3 };
		
		Arrays.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
	
		System.out.println(Arrays.toString(nums));
	}

	private static void m3() {
		
		Integer[] nums = { 1, 5, 6, 4, 2, 3 };
		
		Comparator<Integer> my = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
			
		};
		
		Arrays.sort(nums, my);
		
		System.out.println(Arrays.toString(nums));
		
	}

	private static void m2() {
		
		Integer[] nums = { 1, 5, 6, 4, 2, 3 };
		
		MyComparator my = new MyComparator();
		
		Arrays.sort(nums, my);
		System.out.println(Arrays.toString(nums));
		
		
		
	}

	private static void m1() {
		
		int[] nums = { 1, 5, 3, 4, 2 };
		
		System.out.println("정렬 전: " + Arrays.toString(nums));
		
		Arrays.sort(nums);
		
		System.out.println("정렬 후: " + Arrays.toString(nums));
		System.out.println();
		
		
		ArrayList<Integer> nums2 = new ArrayList<Integer>();
		
		nums2.add(1);
		nums2.add(5);
		nums2.add(3);
		nums2.add(4);
		nums2.add(2);
		
		System.out.println("정렬 전: " + nums2);
		
		Collections.sort(nums2);
		
		System.out.println("정렬 후: " + nums2);
		System.out.println();
		
		Student[] list = new Student[5];
		
		list[0] = new Student("가가가", 100, 90, 80);
		list[1] = new Student("나나나", 60, 70, 80);
		list[2] = new Student("라라라", 90, 90, 100);
		list[3] = new Student("다다다", 80, 90, 70);
		list[4] = new Student("마마마", 60, 60, 70);
		
		System.out.println("정렬 전: " + Arrays.toString(list));
		
		for(int i = 0; i < list.length-1; i++) {
			for (int j = 0; j < list.length-1; j++) {
				
				if(list[j].getKor() + list[j].getEng() + list[j].getMath()
					< list[j+1].getKor() + list[j+1].getEng() + list[j+1].getMath()) {
					
					Student temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
				
			}
		}
		
		System.out.println("정렬 후: " + Arrays.toString(list));
		
	}
	
}

class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return "[name: " + name + ", kor: " + kor + ", eng: " + eng + ", math: " + math + "]";
	}
	
}

class MyComparator implements Comparator<Integer> {

	/*
	정렬할 때 비교를 담당하는 메소드
	o1 vs o2
	 - 오름차순
		- o1 크면 양수 반환
		- o2 크면 음수 반환
	 - 같으면  0 반환
	

	 - 내림차순
		- o1 크면 음수 반환
		- o2 크면 양수 반환
	 - 같으면  0 반환
	*/
	
	@Override
	public int compare(Integer o1, Integer o2) {
//		if(o1 > o2) {
//			return 1;
//		} else if (o1 < o2) {
//			return -1;
//		} else {
//			return 0;
//		}
		
		return o1 - o2; //> 오름차순
//		return o2 - o1;   > 내림차순
		
	}
	
}

 