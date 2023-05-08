package com.test.question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Q126 {

	public static void main(String[] args) {

		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\OneDrive\\쌍용\\과제\\120-126. 파일입출력\\문제 파일\\리소스\\출결.dat"));
			
			ArrayList<EmployeeAttendance> employees = new ArrayList<EmployeeAttendance>();
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				employees = checkDuplicate(employees, tmp);
				
			}
			
			System.out.println("[이름]\t[지각]\t[조퇴]\n");
			
			for(EmployeeAttendance e : employees) {
				System.out.printf("%s\t%s회\t%s회\n", e.getName(), e.getLateness(), e.getEarlyLeave());
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	} //main
	
	private static ArrayList<EmployeeAttendance> checkDuplicate(ArrayList<EmployeeAttendance> employees, String[] tmp) {
		
		EmployeeAttendance newEmployee = new EmployeeAttendance();

		if(employees.isEmpty()) { //list가 비어있을 경우
			newEmployee.setName(tmp[1]);
			newEmployee.setStartTime(tmp[2]);
			newEmployee.setEndTime(tmp[3]);
			employees.add(newEmployee);
			
			return employees;
		}
			
		for(EmployeeAttendance e : employees) { //list가 비어있지 않고, 이미 출결사항이 있을 경우

			if(tmp[1].equals(e.getName())) {
				e.setStartTime(tmp[2]);
				e.setEndTime(tmp[3]);
				
				return employees;
			}

		}
		
		//list가 비어있지 않고, 출결사항이 없을 경우
		newEmployee.setName(tmp[1]);
		newEmployee.setStartTime(tmp[2]);
		newEmployee.setEndTime(tmp[3]);
		employees.add(newEmployee);
			
		return employees;
		
	}
	
}

class EmployeeAttendance {
	
	private String name;
	private int lateness = 0;
	private int earlyLeave = 0;;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStartTime(String startTime) {
		
		String[] time = startTime.split(":");
		
		if(Integer.parseInt(time[0]) > 9) {
			this.lateness++;
		} else if(Integer.parseInt(time[0]) == 9 && Integer.parseInt(time[1]) > 0) {
			this.lateness++;
		}
		
	}
	
	public void setEndTime(String endTime) {

		String[] time = endTime.split(":");

		if(Integer.parseInt(time[0]) < 18) {
			this.earlyLeave++;
		}
		
	}
	
	public int getLateness() {
		return lateness;
	}
	
	public int getEarlyLeave() {
		return earlyLeave;
	}
	
}