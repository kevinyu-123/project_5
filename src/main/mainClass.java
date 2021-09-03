package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemDTO;
import eun.EunDB;


public class mainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String id, name, gender, address, info;
		int age, num;
		int result = 0;
		ArrayList<MemDTO> arr =new ArrayList<MemDTO>();
		EunDB dbee = new EunDB();
		while (true) {
			System.out.println("1.추가 2.전체보기 3.검색 4.수정 5.삭제");
			num = input.nextInt();

			switch (num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				dbee.update();
				break;
			case 5:
				break;

			}
		}
	}
}