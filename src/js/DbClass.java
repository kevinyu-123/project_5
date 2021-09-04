package js;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.MemDTO;

public class DbClass {
	private String url = "jdbc:oracle:thin:@210.221.253.215:1521:xe";
	private String id = "five";
	private String pwd = "oracle";
	
	
	public DbClass() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		public MemDTO searchM(String id) {
			ArrayList<MemDTO> list = new ArrayList<MemDTO>();
			MemDTO dto = null;
			String sql = "select * from MEMMANAGE where id = '"+id+"'";
			try {
				Connection con = DriverManager.getConnection(url,this.id,pwd);
				System.out.println("연결확인");
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					dto = new MemDTO();
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setAge(rs.getInt("age"));
					dto.setGender(rs.getString("gender"));
					dto.setNum(rs.getString("num"));
					dto.setAddress(rs.getNString("address"));
					dto.setInfo(rs.getString("info"));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dto;
			
		}
}