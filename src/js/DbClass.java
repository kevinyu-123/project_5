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
		public ArrayList<MemDTO> getList(){
			ArrayList<MemDTO> list = new ArrayList<MemDTO>();
		
		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결됨!?");
		
			String sql = "select * from memMangage";
			PreparedStatement ps = con.prepareStatement(sql);
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MemDTO mem = new MemDTO();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setAge(rs.getInt("age"));
				mem.setGender(rs.getString("gender"));
				mem.setNum(rs.getString("num"));
				mem.setAddress(rs.getNString("address"));
			}
		}catch (Exception e) {
				e.printStackTrace();
		}
			return list;
		}
		
		public MemDTO searchO(String id) {
			String sql = "select * from memMangage where id = '"+id+"'";
			
			MemDTO dto = null;
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
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			return dto;
			
		}
}