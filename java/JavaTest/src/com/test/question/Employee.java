package com.test.question;

public class Employee {

	private String name;
	private String department;
	private String position;
	private String tel;
	private Employee boss;
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		
		if(name.length() < 2 || name.length() > 5) {
			return;
		}
		

		for(int i = 0; i < name.length(); i++) {

			if(name.charAt(i) >= '가' && name.charAt(i) <= '힣') {
				this.name = name;

			} else { break; }
		}
		
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String department) {
		
		String[] departments = { "영업부", "기획부", "총무부", "개발부", "홍보부" };
		
		for(int i = 0; i < departments.length; i++) {
			
			if(departments[i].equals(department)) {
				this.department = department;
				break;
			}
			
		}
		
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public void setPosition(String position) {
		
		String[] positions = { "부장", "과장", "대리", "사원" };

		for(int i = 0; i < positions.length; i++) {

			if(positions[i].equals(position)) {
				this.position = position;
				break;
			}

		}
		
	}
	
	public String getTel() {
		return this.tel;
	}
	
	public void setTel(String tel) {
		
		if(tel.indexOf("-") != 3 && tel.indexOf("-") != 8) {
			return;
		}

		String telNum = tel.replace("-", "");

		if(telNum.charAt(0) != '0' || telNum.charAt(1) != '1' || telNum.charAt(2) != '0') {
			return;
		}
		
		for(int i=0; i<telNum.length(); i++) {
			
			if(telNum.charAt(i) < '0' || telNum.charAt(i) > '9') {
				return;
			}
			
		}
		
		this.tel = tel;
		
	}
	
	public String getBoss() {
		
		String bossInfo = "";
		
		if(boss == null) {
			bossInfo = "없음\n";
			
		} else {
			bossInfo = String.format("%s(%s %s)\n"
											, boss.name
											, boss.department
											, boss.position);
		}
		
		return bossInfo;
	}
	
	public void setBoss(Employee boss) {
		
		if(boss == null) {
			return;
		}
		
		if( !this.department.equals(boss.getDepartment()) ) {
			return;
		}
		
		this.boss = boss;
	}

	public void info() {
		
		System.out.printf("[%s]\n", this.name);
		System.out.println("- 부서: " + this.department);
		System.out.println("- 직위: " + this.position);
		System.out.println("- 연락처: " + this.tel);
		System.out.println("- 직속상사: " + getBoss());

	}

}
