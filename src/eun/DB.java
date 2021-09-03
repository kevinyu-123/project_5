package eun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

import dto.MemDTO;

public class DB {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "five";
	private String pwd = "oracle";

	public DB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int alterData(String id, String gender, String name, int age, int num, String address, String info) {
		int result = 0;
		String sql = "update memmanage set name= ? ,age=? ,gender=?,num=?,address=?,info=? where id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
			ps = con.prepareStatement(sql);
			ps.setString(3, gender);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(4, num);
			ps.setString(5, address);
			ps.setString(6, info);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;

	}
	public void update() {
		String id, name, gender, address, info;
		int age, num;
		int result = 0;
		Scanner input = new Scanner(System.in);
		ArrayList<MemDTO> arr = null;
		DB db = new DB();
		System.out.print("수정할 id : ");
		id = input.next();
		for (int i = 0; i < arr.size(); i++) {
			MemDTO m = arr.get(i);
			if (m.equals(m.getId())) {
				System.out.println("-----------저장된 정보--------------");
				System.out.println("학생 이름 : " + arr.get(i).getName());
				System.out.println("학생 나이 : " + arr.get(i).getAge());
				System.out.println("학생 전화번호 : " + arr.get(i).getNum());
				System.out.println("학생 성별 : " + arr.get(i).getGender());
				System.out.println("학생 주소: " + arr.get(i).getAddress());
				System.out.println("학생 info: " + arr.get(i).getInfo());
				System.out.println("---------------------------------");
				
				System.out.println("수정할 아이디 입력");
				this.id = input.next();
				System.out.println("수정(변경)할 이름");
				name = input.next();
				System.out.println("수정(변경)할 나이");
				age = input.nextInt();
				System.out.println("수정(변경)할 성별");
				gender = input.next();
				System.out.println("수정(변경)할 전화번호");
				num = input.nextInt();
				System.out.println("수정(변경)할 주소");
				address = input.next();
				System.out.println("수정(변경)할 info");
				info = input.next();

				result = db.alterData(id, gender, name, age, num, address, info);

				if (result == 1) {
					System.out.println("정상적으로 수정 되었습니다");
				} else {
					System.out.println("해당하는 아이디는 존재하지 않습니다.(수정실패)");
				}

			} else {
				System.out.println("존재하지 않는 학번입니다.");
			}
		}

		
	}

}
