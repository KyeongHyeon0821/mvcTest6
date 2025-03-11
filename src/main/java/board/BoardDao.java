package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.DbConnection;

public class BoardDao {

	private Connection conn = DbConnection.getConn();
	private PreparedStatement pstmt;
	private ResultSet rs;

	String sql = "";
	BoardVo vo = null;

	public void pstmtClose() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
			}
		}
	}

	public void rsClose() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			} finally {
				pstmtClose();
			}
		}
	}

	// 게시글 전체 리스트
	public List<BoardVo> getBoardList() {
		List<BoardVo> vos = new ArrayList<>();
		try {
			sql = "select * from boardTest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setReadNum(rs.getInt("readNum"));
				vo.setwDate(rs.getDate("wDate"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getBoardList) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	// 게시글 등록 처리
	public int setBoardInput(BoardVo vo) {
		int res = 0;
		try {
			sql = "insert into boardTest values(default,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getHostIp());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardInput) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 글 조회수 증가
	public void setReadNumUpdate(int idx) {
		try {
			sql = "update boardTest set readNum = readNum + 1 where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setReadNumUpdate) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
	}

	// 글 내용 조회하기
	public BoardVo getBoardContent(int idx) {
		vo = new BoardVo();
		try {
			sql = "select * from boardTest where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHostIp(rs.getString("hostIp"));
				vo.setReadNum(rs.getInt("readNum"));
				vo.setwDate(rs.getDate("wDate"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getBoardContent) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 글 지우기
	public int setBoardDelete(int idx) {
		int res = 0;
		try {
			sql = "delete from boardTest where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardDelete) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	// 게시글 수정하기
	public int setBoardUpdateOk(BoardVo vo) {
		int res = 0;
		try {
			sql = "update boardTest set name=?, title=?, content=?, hostIp=?, wDate=now() where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getHostIp());
			pstmt.setInt(5, vo.getIdx());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardUpdateOk) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
}
