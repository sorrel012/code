package com.test.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.test.data.Data;
import com.test.data.Item;
import com.test.data.User;

public class Ex91_Stream {

	public static void main(String[] args) {

//		m1();
//		m2();
//		m3();
//		m4();
//		m5();
//		m6();
//		m7();
//		m8();
		m9();
//		m10();

	} //main
	
	private static void m10() {
		
		//Optional<T>
		
		int age = getAge("홍길동");
		
		System.out.println("나이: " + age);
		
		Optional<Integer> num = getNum("홍길동");
		
		if(!num.isEmpty()) {
			System.out.println("번호: " + num);
		} else {
			System.out.println("회원 없음");
		}
		
	}
	
	private static Optional<Integer> getNum(String name) {
		
		Optional<Integer> num = Optional.empty(); //null
		
		if(name.equals("홍길동")) {
			num = Optional.of(20);
		} else if(name.equals("아무개")) {
			num = Optional.of(22);
		} else if (name.equals("호호호")) {
			num = Optional.of(25);
		}
		
		return num;
	}

	private static int getAge(String name) {
		
		int age = 0;
		
		if(name.equals("홍길동")) {
			age = 20;
		} else if(name.equals("아무개")) {
			age = 22;
		} else if (name.equals("호호호")) {
			age = 25;
		}
		
		return age;
	}

	private static void m9() {
		
		List<Integer> list = Data.getIntList();
		
		System.out.println(list.size());
		
		System.out.println(list.stream().count());
		System.out.println();
		
		long cnt = list.stream()
						.filter(num -> num % 2 ==0)
						.count();
		System.out.println("짝수의 개수: " + cnt);
		System.out.println();
		
		cnt = Data.getUserList().stream()
								.filter(user -> user.getHeight() >= 175)
								.count();
		System.out.println("175cm 이상인 사람은 " + cnt + "명입니다.");
		System.out.println();
		System.out.println();
		
		list = Data.getIntList(10);
		
		System.out.println(list);
		
		int max = Integer.MIN_VALUE;  //list 안의 모든 숫자들 중 가장 작은 숫자 - 1;
		int min = Integer.MAX_VALUE;  //list 안의 모든 숫자들 중 가장 큰 숫자 + 1;
		
		//enhanced for
		for(int n : list) {
			if (n > max) {
				max = n;
			}
			
			if (n < min) {
				min = n;
			}
		}
		
		System.out.println("최댓값: " + max);
		System.out.println("최솟값: " + min);
		
		System.out.println();
		System.out.println();
		
		
		//stream
		
		//Optional<Integer>
		// - Integer, int 타입과 동일한 자료형
		// - null을 가질 수 있다.
		Optional<Integer> result = list.stream().max((a,b) -> a - b);
		
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println(Data.getUserList().stream()
						.max((a,b) -> a.getHeight() - b.getHeight()).get());
		
		System.out.println(Data.getUserList().stream()
				.min((a,b) -> a.getWeight() - b.getWeight()).get());
		
		//Stream<Integer> : IntStream
		System.out.println(Data.getIntList(5).stream().mapToInt(num -> num).sum());
		System.out.println(Data.getIntList(5).stream().mapToInt(num -> num).average().getAsDouble());
		
		System.out.println();
		
		//User > 평균 몸무게
		System.out.println(Data.getUserList().stream()
												.filter(user -> user.getGender() == 1)
												.mapToInt(user -> user.getWeight())
												.average()
												.getAsDouble());
		
	}
	
	private static void m8() {
		
		//요구사항] 배열 안에 짝수만 있는지?
		
		int[] nums = { 2, 4, 6, 8, 10, 3 };
		
		//1. enhanced-for

		boolean result = true;
				
		for(int n : nums) {
			if (n % 2 == 1) {
				result = false;
				break;
			}
		}
		
		if(result) {
			System.out.println("짝수만 존재");
		} else {
			System.out.println("홀수 발견!!");
		}
		
		//2. allMatch
		
		result = Arrays.stream(nums).allMatch(n -> n % 2 == 0);
		
		if(result) {
			System.out.println("짝수만 존재");
		} else {
			System.out.println("홀수 발견!!");
		}
		System.out.println();
		System.out.println();
		
		
		//요구사항] nums안에 홀수가 1개 이상 존재하는지?

		result = Arrays.stream(nums).anyMatch(n -> n % 2 == 1);
		
		if(result) {
			System.out.println("홀수 존재");
		} else {
			System.out.println("짝수만 존재");
		}
		System.out.println();
		System.out.println();
		
		
		//요구사항] nums 안에 모두 홀수가 아닌가?
		
		result = Arrays.stream(nums).noneMatch(n -> n % 2 == 1);
		if(result) {
			System.out.println("짝수만 존재");
		} else {
			System.out.println("홀수 존재");
		}
		System.out.println();
		System.out.println();
		
		System.out.println(Data.getUserList());
		System.out.println();
		
		result = Data.getUserList().stream()
									.anyMatch(user -> user.getHeight() >= 180);
		if(result) {
			System.out.println("180 이상인 사람이 존재합니다.");
		} else {
			System.out.println("모두 180 미만입니다.");
		}
		
		result = Data.getUserList().stream()
									.allMatch(user -> user.getGender() == 1);
		if(result) {
			System.out.println("모두 남자입니다.");
		} else {
			System.out.println("여자도 존재합니다.");
		}
		
		result = Data.getUserList().stream()
									.filter(user -> user.getHeight() >= 180)
									.allMatch(user -> user.getGender() == 1);
		if(result) {
			System.out.println("180 넘는 사람은 모두 남자입니다.");
		} else {
			System.out.println("180 넘는 여자도 존재합니다.");
		}
		
		result = Data.getUserList().stream()
									.noneMatch(user -> user.getWeight() < 60);
		if(result) {
			System.out.println("60kg 미만이 아무도 없습니다.");
		} else {
			System.out.println("60kg 미만인 사람이 있습니다.");
		}
		
	}

	private static void m7() {
		
		//sorted
		Data.getIntList(10).stream()
							.forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		Data.getIntList(10).stream()
							.sorted()
							.forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		Data.getIntList(10).stream()
							.sorted((a,b) -> b - a)
							.forEach(num -> System.out.print(num + " "));
		System.out.println();
		
		Data.getItemList().stream()
							.forEach(item -> System.out.println(item));
		System.out.println();
		
		Data.getItemList().stream()
							.sorted((a,b) -> a.getName().compareTo(b.getName()))
							.forEach(item -> System.out.println(item));
		System.out.println();
		
		List<Integer> list = Data.getIntList(10);
		
		System.out.println(list);
		
		Collections.sort(list); 				//오름차순
		Collections.sort(list, (a,b) -> b - a); //내림차순
		
		list.sort((a,b) -> a - b); 				//오름차순
		list.sort((a,b) -> b - a); 				//내림차순
		
		list.sort(Comparator.naturalOrder());	//오름차순
		list.sort(Comparator.reverseOrder());	//내림차순
		
		Data.getIntList().stream()
							.distinct()
							.filter(n -> n % 2 == 0)
							.filter(n -> n % 3 == 0)
							.sorted()
							.forEach(System.out::println);
		System.out.println();
		
	}

	private static void m6() {
		
		//map
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		System.out.println();
		
		list.stream()
			.forEach(word -> System.out.printf("%3d", word.length()));
		System.out.println();
		
		list.stream()
			.map(word -> word.length())
			.forEach(num -> System.out.printf("%3d", num));
		System.out.println();
		System.out.println();
		
		String[] names = { "홍길동", "유재석", "박명수", "박나래", "장도연" };
		
		Arrays.stream(names)
				.map(name -> name.substring(1))
				.forEach(name -> System.out.printf("%4s", name));
		System.out.println();
		System.out.println();
		
		
		for(int i = 0; i < names.length; i++) {
			
			String firstName = names[i].substring(1); //이름
			String lastName = names[i].substring(0, 1); //성
			
			Name name = new Name();
			name.setFirstName(firstName);
			name.setLastName(lastName);
			
			System.out.println(name.getFirstName() + ", " + name.getLastName());
			
		}
		System.out.println();
		
		Arrays.stream(names)
				.map(name -> {

					String firstName = name.substring(1); //이름
					String lastName = name.substring(0, 1); //성
					
					Name n = new Name();
					n.setFirstName(firstName);
					n.setLastName(lastName);
					
					return n;
					
				})
				.forEach(name -> System.out.println(name.getFirstName() + ", " + name.getLastName()));
		System.out.println();
		
		Data.getIntList(5).stream()
							.map(num -> 1)
							.forEach(n -> System.out.println(n));
		
		Data.getUserList().stream()
							.forEach(user -> System.out.println(user.getName()));
		System.out.println();
		
		Data.getUserList().stream()
							.map(user -> user.getName())
							.forEach(name -> System.out.println(name));
		System.out.println();
		
	}

	private static void m5() {
		
		List<Integer> list = Data.getIntList();
		System.out.println(list.size());
		
		//요구사항] 집합에서 중복값을 제거하여 유일값들을 출력하시오.
		
		//Case 1.
		Set<Integer> set1 = new HashSet<Integer>();
		
		for(int n : list) {
			set1.add(n);
		}
		System.out.println(set1.size());
		
		
		//Case 2.
		Set<Integer> set2 = new HashSet<Integer>(list);
		System.out.println(set2.size());
		System.out.println();
		
		
		//Case 3.
		list.stream()
			.distinct()
			.forEach(num -> System.out.printf("%4d", num));
		System.out.println();
		
		Data.getStringList().stream()
							.filter(word -> word.length() > 5)
							.distinct()
							.forEach(word -> System.out.println(word));
		
		List<Student> slist = new ArrayList<Student>();
		
		slist.add(new Student("가가가", 20, "남자"));
		slist.add(new Student("나나나", 20, "남자"));
		slist.add(new Student("다다다", 20, "남자"));
		slist.add(new Student("홍길동", 20, "남자"));
		slist.add(new Student("홍길동", 20, "남자"));
		
		slist.stream()
			.distinct()
			.forEach(s -> System.out.println(s));
		System.out.println();
		
		
	}

	private static void m4() {
		
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
		//요구사항] 짝수만 화면에 출력하시오.
		
		//1. for
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) % 2 == 0) {
				System.out.printf("%4d", list.get(i));
			}
		}
		System.out.println();
		
		//2. 향상된 for문
		for(int n : list) {
			if(n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		}
		System.out.println();
		
		//3. stream
		list.stream()
			.filter(num -> num % 2 == 0 && num > 50)
			.forEach(num -> System.out.printf("%4d", num));
		
		list.stream() //관리 차원에선 보기가 더 수월
			.filter(num -> num % 2 == 0)
			.filter(num -> num > 50)
			.forEach(num -> System.out.printf("%4d", num));
		
		System.out.println();
		System.out.println();
		
		Data.getStringList().stream()
							.filter(word -> word.length() >= 5)
							.filter(word -> word.startsWith("애플"))
							.forEach(word -> System.out.println(word));
		System.out.println();
		
		Data.getUserList().stream()
							.filter(user -> user.getGender() == 1)
							.filter(user -> user.getHeight() >= 180)
							.filter(user -> user.getWeight() >= 80)
							.forEach(user -> System.out.println(user));
		System.out.println();
		
		
	
	}

	private static void m3() {

		//스트림을 얻어오는 방법
		
		//1. 컬렉션으로부터
		ArrayList<Integer> nums1 = new ArrayList<Integer>();
		nums1.add(100);
		nums1.add(200);
		nums1.add(300);
		
		nums1.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		LinkedList<Integer> nums2 = new LinkedList<Integer>();
		nums2.add(1000);
		nums2.add(2000);
		nums2.add(3000);

		nums2.stream().forEach(num -> System.out.println(num));
		System.out.println();
		
		HashSet<Integer> nums3 = new HashSet<Integer>();
		nums3.add(10000);
		nums3.add(20000);
		nums3.add(30000);

		nums3.stream().forEach(num -> System.out.println(num));
		System.out.println();

		//2. 배열로부터
		int[] nums4 = { 111, 222, 333, 444, 555 };
		
		Arrays.stream(nums4).forEach(num -> System.out.println(num));
		System.out.println();
		System.out.println();
		
		//3. 숫자 범위로부터
		IntStream.range(1, 11).forEach(num -> System.out.println(num));
		System.out.println();
		System.out.println();
				
		try {
			
			//4. 파일로부터
			// - 파일 읽기
			Path path = Paths.get("C:\\class\\code\\java\\JavaTest\\dat\\user.txt"); //File file = new File();
			
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			System.out.println();
			
			//5. 디렉토리로부터
			// - 목록 보기 : dir.listFiles()
			
			Path dir = Paths.get("c:\\class\\dev\\eclipse");
			
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName() + ", " + p.toFile().length());
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		//배열(컬렉션) 탐색
		List<Integer> list = Data.getIntList(10);
		
		//1. for문(while문)
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%5d", list.get(i));
		}
		System.out.println();
		
		//2. 향상된 for문
		for(int n : list) {
			System.out.printf("%5d", n);
		}
		System.out.println();
		
		//3. Iterator
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.printf("%5d", iter.next());
		}
		System.out.println();
		
		//4. stream
		Stream<Integer> stream = list.stream();
		
//		Consumer<Integer> c1 = num -> System.out.printf("%5d", num);
		
//		stream.forEach(c1); > c1.accept() 반복
		
		stream.forEach(num -> System.out.printf("%5d", num)); //배열 탐색
		
		System.out.println();
		System.out.println();
		
//		List<Double> list2 = Data.getDoubleList(10);
//		Stream<Double> stream2 = list2.stream();
//		Consumer<Double> c2 = num -> System.out.printf("%5.1f", num);
//		stream2.forEach(c2);
		
		//메소드 체인
		Data.getDoubleList(10)
				.stream()
				.forEach(num -> System.out.printf("%5.1f", num));
		
		System.out.println();
		
		Data.getDoubleList(10)
				.stream()
				.forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		
		Data.getStringList(10)
				.stream()
				.forEach(System.out::println);
		
		System.out.println();
		
		Data.getStringList(10)
				.stream()
				.forEach(txt -> System.out.println(txt.length()));
		
		System.out.println();
		System.out.println();
		
		Data.getUserList()
				.stream()
				.forEach(user -> {
					System.out.println("이름: "+ user.getName());
					System.out.println("나이: "+ user.getAge());
					System.out.println();
				});
		
	}

	//컴파일한 jar파일 안에 어떤 클래스, 메소드가 있는지 확인
	private static void m1() {
		
		int[] nums1 = Data.getIntArray();
		System.out.println(Arrays.toString(nums1));
		
		System.out.println();
		
		int[] nums2 = Data.getIntArray(10);
		System.out.println(Arrays.toString(nums2));
		
		System.out.println();
		
		//★★★ 인터페이스를 구현한 클래스의 객체를 담을 참조 변수
		// BB: 자기 타입, AA: 부모 타입
		//1. 자기 타입의 클래스 변수		BB a1 = new BB();
		//2. 부모 타입의 인터페이스 변수	AA a2 = new BB();
		ArrayList<Integer> list1 = (ArrayList<Integer>)Data.getIntList();
		
		List<Integer> list2 = Data.getIntList();
		
		System.out.println(list2);
		
		System.out.println();
		System.out.println();
		
		String[] txt1 = Data.getStringArray();
		System.out.println(Arrays.toString(txt1));
		
		System.out.println();
		
		User[] ulist = Data.getUserArray();
		System.out.println(Arrays.toString(ulist));
		
		System.out.println();
		
		Item[] ilist = Data.getItemArray();
		System.out.println(Arrays.toString(ilist));
		
	}
	
} //Main

class Name {
	
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}


