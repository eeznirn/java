/*
  객체지향 프로그래밍 과제 
  컴퓨터공학과 202104352 석민지
 */


package pr1;

    import java.io.*;
	import java.util.*;



	// 회원 관리 클래스
	public class MemberManager {
	    private ArrayList<Member> memberList;

	    public MemberManager() {
	        memberList = new ArrayList<>();
	    }

	    // 회원 추가
	    public void addMember(Member member) {
	        memberList.add(member);
	        System.out.println("새로운 회원이 추가되었습니다.");
	    }

	    // 회원 조회
	    public void viewMembers() {
	        if (memberList.isEmpty()) {
	            System.out.println("등록된 회원이 없습니다.");
	        } else {
	            System.out.println("======= 회원 목록 =======");
	            for (Member member : memberList) {
	                System.out.println("이름: " + member.getName());
	                System.out.println("주소: " + member.getAddress());
	                System.out.println("전화번호: " + member.getPhone());
	                System.out.println("아이디: " + member.getId());
	                System.out.println("=======================");
	            }
	        }
	    }

	    // 회원 수정
	    public void updateMember(String targetId, Member updatedMember) {
	        Iterator<Member> iterator = memberList.iterator();
	        while (iterator.hasNext()) {
	            Member member = iterator.next();
	            if (member.getId().equals(targetId)) {
	                member.setName(updatedMember.getName());
	                member.setAddress(updatedMember.getAddress());
	                member.setPhone(updatedMember.getPhone());
	                member.setId(updatedMember.getId());
	                member.setPassword(updatedMember.getPassword());
	                System.out.println("회원 정보가 수정되었습니다.");
	                return;
	            }
	        }
	        System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
	    }

	    // 회원 삭제
	    public void deleteMember(String targetId) {
	        Iterator<Member> iterator = memberList.iterator();
	        while (iterator.hasNext()) {
	            Member member = iterator.next();
	            if (member.getId().equals(targetId)) {
	                iterator.remove();
	                System.out.println("회원이 삭제되었습니다.");
	                return;
	            }
	        }
	        System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        MemberManager memberManager = new MemberManager();

	        while (true) {
	            System.out.println("1. 회원 추가 | 2. 회원 조회 | 3. 회원 수정 | 4. 회원 삭제 | 5. 종료");
	            System.out.print("선택: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1: //회원 추가 
	                    System.out.print("이름: ");
	                    String name = scanner.nextLine();
	                    System.out.print("주소: ");
	                    String address = scanner.nextLine();
	                    System.out.print("전화번호: ");
	                    String phone = scanner.nextLine();
	                    System.out.print("아이디: ");
	                    String id = scanner.nextLine();
	                    System.out.print("비밀번호: ");
	                    String password = scanner.nextLine();

	                    Member newMember = new Member(name, address, phone, id, password);
	                    memberManager.addMember(newMember);
	                    break;

	                case 2: //회원 조회 
	                    memberManager.viewMembers();
	                    break;

	                case 3: //회원 수정 
	                    System.out.print("수정할 회원의 아이디: ");
	                    String targetId = scanner.nextLine();
	                    System.out.print("수정할 정보 입력 - 이름: ");
	                    name = scanner.nextLine();
	                    System.out.print("수정할 정보 입력 - 주소: ");
	                    address = scanner.nextLine();
	                    System.out.print("수정할 정보 입력 - 전화번호: ");
	                    phone = scanner.nextLine();
	                    System.out.print("수정할 정보 입력 - 아이디: ");
	                    id = scanner.nextLine();
	                    System.out.print("수정할 정보 입력 - 비밀번호: ");
	                    password = scanner.nextLine();

	                    Member updatedMember = new Member(name, address, phone, id, password);
	                    memberManager.updateMember(targetId, updatedMember);
	                    break;

	                case 4: //회원 삭제 
	                    System.out.print("삭제할 회원의 아이디: ");
	                    targetId = scanner.nextLine();
	                    memberManager.deleteMember(targetId);
	                    break;

	                case 5: //프로그램 종료 
	                    System.out.println("종료합니다.");
	                    scanner.close();
	                    System.exit(0);

	                default: //오류 
	                    System.out.println("잘못된 선택입니다.");
	            }
	        }
	    }
	}


//멤버 매니지먼트 인터페이스 
//  MemberMange 인터페이스는 멤버 관리와 관련된 기능을 정의

interface MemberManage{
	void addMember(Member member);
	void updateMember (Member member);
	void deleteMember (Member member);
}


//배열 및 컬렉션 프레임 워크를 사용하여 참조하고,
//ArrayList를 사용하여 멤버 정보를 저장하고 관리한다.
class MemberManageImpl implements MemberManage {
    private List<Member> members = new ArrayList<>();
    
    
    @Override
    public void addMember(Member member) {
    	members.add(member);
    }
    
    @Override
    public void updateMember(Member member) {
    	System.out.println("수정되지 않았습니다.");
    }
    
    @Override
    public void deleteMember(Member member) {
    members.remove(member);
}
}



//멤버 뷰 클래스
class MemberView{
	
}

//컨트롤러 인터페이스 
interface Controller{
	void start();
}

//컨트롤러 구현 클래스
public class ManagementController implements Controller {
 private MemberView mv = new MemberView();
 private MemberManage memberManager = new MemberManageImpl();

 @Override
 public void start() {
     while (true) {
         System.out.println("1. 회원 추가 | 2. 회원 수정 | 3. 회원 삭제 | 4. 종료");
         System.out.print("선택: ");

         Scanner scanner = new Scanner(System.in);
         int choice = scanner.nextInt();
         scanner.nextLine(); 

         switch (choice) {
             case 1:
                 // 회원 추가 
                 System.out.println("새로운 회원 추가 중");
                 
                 break;

             case 2:
                 // 회원 수정 
                 System.out.println("회원 정보 수정 중");
                 
                 break;

             case 3:
                 // 회원 삭제 
                 System.out.println("회원 삭제 중");
                 
                 break;

             case 4:
                 // 프로그램 종료
                 System.out.println("프로그램을 종료합니다.");
                 System.exit(0);

             default:
                 System.out.println("유효하지 않은 선택입니다.");
                 break;
         }
     }
 }
}

