package main;

import java.util.ArrayList;
import java.util.Scanner;

import dto.MemDTO;
import kb.Notice;


public class mainClass {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<MemDTO>list = new ArrayList<MemDTO>();
		String id, name, address, gender, info;
		int age, num, sel;
		Notice kb = new Notice();		
		System.out.println("---멤버관리 프로그램---");
		while (true) {
			System.out.println("1.회원추가 2.회원전체보기 3.회원검색 4.회원수정 5.회원삭제 6.공지사항 발표 및 보기");
			sel = scan.nextInt();
			switch (sel) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5: 
				break;
			case 6:
				kb.test();
				break;
			}
		}
	}
}