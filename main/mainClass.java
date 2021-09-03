package main;

import java.util.ArrayList;

import java.util.Scanner;
import han.addMembership;
import dto.MemDTO;
import hj.Db;
import ys.DBClass;
import eun.EunDB;

public class mainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<MemDTO>list = new ArrayList<MemDTO>();
		String id, name, address, gender, info;
		int age, num, sel;
		Db hj = new Db();
		addMembership add = new addMembership();
		DBClass db = new DBClass();
		EunDB dbee = new EunDB();
		int result = 0;
		
		System.out.println("---멤버관리 프로그램---");
		while (true) {
			System.out.println("1.회원추가 2.회원전체보기 3.회원검색 4.회원수정 5.회원삭제 6.공지사항 발표 및 보기");
			sel = scan.nextInt();
			switch (sel) {
			case 1:
				//회원 add 기능 추가
				add.display();
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
				dbee.update();
				break;
			case 5:
				//회원 삭제기능 추가
				System.out.println("=== 삭제하실 아이디를 입력 해 주세요 ===" );
				id = scan.next();
				
				result = db.deleteDB(id);
				
				if (result == 1) {
					System.out.println("정상적으로 삭제되었습니다.");
				} else {
					System.out.println("존재하는 아이디가 없어서 삭제가 불가능 합니다.");
				}
				break;
			case 6:
				break;
			}
		}
	}
}