package main;

import java.util.ArrayList;
import java.util.Scanner;

<<<<<<< HEAD
import db.DBClass;
import dto.MemDTO;

public class mainClass {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int num;
		String id;
		DBClass db = new DBClass();
		ArrayList<MemDTO> list = new ArrayList<MemDTO>();
		int result = 0;
		
		
		while(true) {
			System.out.println("=== 1. 회원 전체 보기 5. 회원 삭제 3. 나가기 ===");
			num = input.nextInt();
			
			switch (num) {
			case 1:
				list = db.getList();
				for (int i = 0; i < list.size(); i++) {
					System.out.println("아이디 : " + list.get(i).getId());
					System.out.println("이름 : " + list.get(i).getName());
					System.out.println("성별 : " + list.get(i).getGender());
					System.out.println("연락처 : " + list.get(i).getNum());
					System.out.println("주소 : " + list.get(i).getAddress());
					System.out.println("추가 정보 : " + list.get(i).getInfo());
					System.out.println("==========================");
				}
				break;
			case 5:
				System.out.println("=== 삭제하실 아이디를 입력 해 주세요 ===" );
				id = input.next();
				
				result = db.deleteDB(id);
				
				if (result == 1) {
					System.out.println("정상적으로 삭제되었습니다.");
				} else {
					System.out.println("존재하는 아이디가 없어서 삭제가 불가능 합니다.");
				}
				
				break;
			case 3:
				return;
			}
		}
		
	
=======
import dto.MemDTO;
import hj.Db;

public class mainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<MemDTO>list = new ArrayList<MemDTO>();
		String id, name, address, gender, info;
		int age, num, sel;
		Db hj = new Db();

		System.out.println("---멤버관리 프로그램---");
		while (true) {
			System.out.println("1.회원추가 2.회원전체보기 3.회원검색 4.회원수정 5.회원삭제 6.공지사항 발표 및 보기");
			sel = scan.nextInt();
			switch (sel) {
			case 1:
				break;
			case 2:
				//회원 전체보기 기능 추가
				System.out.println("전체 회원을 보여줍니다.");
				list = hj.findAll();
				hj.show(list);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			}
		}
>>>>>>> ba1adbb98cda3ac47b2f192ee1bab32a2d26c33b
	}
}
