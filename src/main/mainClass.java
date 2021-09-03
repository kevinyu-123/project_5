package main;

import java.util.ArrayList;
import java.util.Scanner;

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
		
	
	}
}
