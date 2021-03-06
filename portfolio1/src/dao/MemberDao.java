package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBconn;
import vo.Member;

public class MemberDao {
	public List<Member> getMembers() {
		// 1. Connection 취득
		// 2. 문장(Statement) 생성
		// 3. Select >> 결과집합(Resultset)
		//     >> RS순회
		
		Connection conn = DBconn.getConnection();
		List<Member> list = new ArrayList<Member>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String name = rs.getString("name");
				
				Member member = new Member(id, pwd, email, name);
				list.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean login(String id, String pwd) {
		Connection conn = DBconn.getConnection();
		boolean success = false;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER "
					+ "WHERE ID='" + id + "' AND PWD = '" + pwd + "'");
			success = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	public void delete(String id) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE TBL_MEMBER WHERE id = ?");
			pstmt.setString(1,  id);
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void join(Member member) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TBL_MEMBER VALUES(?, ?, ?, ?)");
			int idx = 1;
			pstmt.setString(idx++, member.getId()); // 1
			pstmt.setString(idx++, member.getPwd()); // 2
			pstmt.setString(idx++, member.getEmail()); // 3
			pstmt.setString(idx++, member.getName()); // 4
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Member findBy(String id) {
		Connection conn = DBconn.getConnection();
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER WHERE ID=?");
			pstmt.setString(1,  id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				member = new Member(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public Member findId(String name, String email) {
		Connection conn = DBconn.getConnection();
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER WHERE NAME = ? AND EMAIL = ?");
			pstmt.setString(1,  name);
			pstmt.setString(2,  email);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				member = new Member(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public Member findPwd(String id, String email) {
		Connection conn = DBconn.getConnection();
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER WHERE ID = ? AND EMAIL = ?");
			pstmt.setString(1,  id);
			pstmt.setString(2,  email);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				member = new Member(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public void update(Member member) {
		Connection conn = DBconn.getConnection();
		try {
			conn.setAutoCommit(false);
			
			PreparedStatement pstmt = conn.prepareStatement("UPDATE TBL_MEMBER SET\r\n" + 
					"	PWD = ?,\r\n" + 
					"	EMAIL = ?,\r\n" + 
					"	NAME = ?\r\n" + 
					"WHERE ID = ?");
			int idx = 1;
			pstmt.setString(idx++, member.getPwd()); // 1
			pstmt.setString(idx++, member.getEmail()); // 2
			pstmt.setString(idx++, member.getName()); // 3
			pstmt.setString(idx++, member.getId()); // 4
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Member findBy2(String email) {
		Connection conn = DBconn.getConnection();
		Member member = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT ID, PWD, EMAIL, NAME FROM TBL_MEMBER WHERE EMAIL=?");
			pstmt.setString(1,  email);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				member = new Member(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

}
