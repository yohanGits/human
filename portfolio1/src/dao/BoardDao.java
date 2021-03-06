package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBconn;
import vo.Attach;
import vo.Board;
import vo.Criteria;
import vo.Member;
import vo.PageDTO;

public class BoardDao {
	// CRUD
	// 글쓰기
	public Long insert(Board board) {
		Connection conn = DBconn.getConnection();
		Long bno = null;
		try {
			conn.setAutoCommit(false);
			
			// 글 번호를 먼저 발급
			ResultSet rs = conn.prepareStatement("SELECT SEQ_BOARD.NEXTVAL FROM DUAL").executeQuery();
			rs.next();
			bno = rs.getLong(1);
			
			// 글작성
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO TBL_BOARD(BNO, TITLE, CONTENT, ID, CATEGORY) VALUES (?, ?, ?, ?, ?)");
			int idx = 1;
			pstmt.setLong(idx++, bno);
			pstmt.setString(idx++, board.getTitle()); // 1
			pstmt.setString(idx++, board.getContent()); // 2
			pstmt.setString(idx++, board.getId()); // 3
			pstmt.setLong(idx++, board.getCategory()); // 4
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(true);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bno;
	}
	
	// 글 조회
	public Board read(Long bno) {
		Connection conn = DBconn.getConnection();
		Board board = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT BNO, TITLE, CONTENT, REGDATE, ID, CATEGORY\r\n" + 
					"FROM TBL_BOARD\r\n" + 
					"WHERE BNO = ?");
			pstmt.setLong(1,  bno);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int idx = 1;
				board = new Board(
						rs.getLong(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++),
						rs.getString(idx++),
						rs.getLong(idx++),
						null,
						null
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return board;
	}
	
	// 목록조회
	public List<Board> list() {
		Connection conn = DBconn.getConnection();
		List<Board> list = new ArrayList<Board>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT \r\n" + 
					"	BNO, TITLE, REGDATE, ID, CATEGORY\r\n" + 
					"FROM TBL_BOARD\r\n" + 
					"WHERE BNO > 0\r\n" + 
					"ORDER BY 1 DESC");
			while(rs.next()) {
				int idx = 1;
				Long bno = rs.getLong(idx++);
				String title = rs.getString(idx++);
				Date regDate = rs.getDate(idx++);
				String id = rs.getString(idx++);
				Long category = rs.getLong(idx++);
				
				Board board = new Board(bno, title, regDate, id, category);
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Board> list(Criteria cri) {
		Connection conn = DBconn.getConnection();
		List<Board> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			
			StringBuilder sql = new StringBuilder();
			sql.append("WITH B AS (\r\n");
			sql.append("	SELECT /*+ INDEX_DESC(TB PK_BOARD) */ \r\n");
			sql.append("		ROWNUM RN, TB.*\r\n");
			sql.append("	FROM TBL_BOARD TB \r\n");
			sql.append("	WHERE BNO > 0\r\n");
			sql.append("	AND CATEGORY = ? \r\n");
			sql.append("	AND ROWNUM <= ? * ?\r\n");
//			sql.append("	ORDER BY BNO DESC\r\n");
			sql.append(")\r\n");
			sql.append("SELECT BNO, TITLE, REGDATE, ID, CATEGORY, (SELECT COUNT(*) FROM TBL_REPLY R WHERE R.BNO = B.BNO) REPLYCNT, CONTENT FROM B\r\n");
			sql.append("WHERE RN > (?-1) * ?");
			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			int idx = 1;
			pstmt.setInt(idx++, cri.getCategory());
			pstmt.setInt(idx++, cri.getPageNum());
			pstmt.setInt(idx++, cri.getAmount());
			pstmt.setInt(idx++, cri.getPageNum());
			pstmt.setInt(idx++, cri.getAmount());
			
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				idx = 1;
				Long bno = rs.getLong(idx++);
				String title = rs.getString(idx++);
				Date regDate = rs.getDate(idx++);
				String id = rs.getString(idx++);
				Long category = rs.getLong(idx++);
				
				Board board = new Board(bno, title, regDate, id, category);
				board.setReplyCnt(rs.getInt(idx++));
				board.setContent(rs.getString(idx++));
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void idNull(String id) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE TBL_BOARD SET ID=NULL WHERE ID=?");
			int idx = 1;
			pstmt.setString(idx++,  id);
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Board board) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE TBL_BOARD SET\r\n" + 
					"	TITLE = ?,\r\n" + 
					"	CONTENT = ?\r\n" + 
					"WHERE BNO = ?");
			int idx = 1;
			pstmt.setString(idx++,  board.getTitle());
			pstmt.setString(idx++, board.getContent()); 
			pstmt.setLong(idx++, board.getBno()); 
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Long bno) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE TBL_BOARD WHERE BNO = ?");
			pstmt.setLong(1,  bno);
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 첨부 파일
	
	public void deleteAll(Long bno) {
		Connection conn = DBconn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE TBL_ATTACH WHERE BNO = ?");
			pstmt.setLong(1,  bno);
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeAttach(Attach attach) {
		Connection conn = DBconn.getConnection();
		try {
			// 글 작성
			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO TBL_ATTACH VALUES (?, ?, ?, ?)");
			int idx = 1;			
			pstmt.setString(idx++, attach.getUuid()); // 3
			pstmt.setString(idx++, attach.getOrigin()); // 3
			pstmt.setLong(idx++, attach.getBno()); // 3
			pstmt.setString(idx++, attach.getPath()); // 3
			
			// select : executeQuery /  insert update delete : executeUpdate
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Attach> readAttach(Long bno){
		Connection conn = DBconn.getConnection();
		List<Attach> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT UUID, ORIGIN, PATH FROM TBL_ATTACH WHERE BNO = ?");
			pstmt.setLong(1, bno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				String uuid = rs.getString(idx++);
				String origin = rs.getString(idx++);
				String path = rs.getString(idx++);
				
				Attach attach = new Attach(uuid, origin, bno, path);
				list.add(attach);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Attach> readAttachByPath(String path){
		Connection conn = DBconn.getConnection();
		List<Attach> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT UUID, ORIGIN, PATH FROM TBL_ATTACH WHERE PATH = ?");
			pstmt.setString(1, path);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				String uuid = rs.getString(idx++);
				String origin = rs.getString(idx++);
				
				Attach attach = new Attach(uuid, origin, null, path);
				list.add(attach);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String findOriginBy(String uuid) {
		Connection conn = DBconn.getConnection();
		String origin = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT ORIGIN FROM TBL_ATTACH WHERE UUID = ?");
			pstmt.setString(1,  uuid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				origin = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return origin;
	}
	
	
	public int getCount(Criteria cri) {
		Connection conn = DBconn.getConnection();
		int count = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT COUNT(*) FROM TBL_BOARD WHERE CATEGORY=?");
			pstmt.setInt(1, cri.getCategory());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return count;
	}
	
	
	
	// 테스트
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		dao.list(new Criteria(1, 10)).forEach(System.out::println);
	}
}