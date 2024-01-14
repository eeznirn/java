/*
  객체지향 프로그래밍 과제 
  컴퓨터공학과 202104352 석민지
  
  member.java 클래스에서는 멤버에 대한 정보를 저장하는 
  멤버 변수(이름, 주소, 번호, 아이디, 비밀번호)가 있습니다. 
 */


package pr1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




//멤버 관리 클래스
 class Member {
	// 이름, 주소, 번호, 아이디, 비밀번호 변수를 저장한다. 
		private String name;
		private String address;
		private String phone;
		private String id;
		private String password;
		
		
		//생성자 
		public Member() {}
		
		public Member(String name, String address, String phone, String id, String password) {
			this.name = name;
			this.address = address;
			this.phone = phone;
			this.id = id;
			this.password = password;
			
		}
		
		//메소드
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) { 
		    this.password = password;
		}
		
	
		
		
	}
