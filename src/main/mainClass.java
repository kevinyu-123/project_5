package main;

import java.util.Scanner;

import han.addMembership;

public class mainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=0;
		addMembership add = new addMembership();
		boolean bool = true;
		while(bool) {
			System.out.println("회원 관리 프로그램입니다.");
			System.out.println("1.추가 2.전체보기 3.특정보기 4.수정 5.삭제");
			num = input.nextInt();
			switch(num) {
			case 1 : add.display(); break;
			case 2 : break;
			case 3 : break;
			case 4 : break;
			case 5 : break;
			}
		}
	}
}
