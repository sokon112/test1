package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import book.domain.BookVO;

import static book.dao.JDBCUtil.*;

public class BookDAO {
	private Connection con = getConnection();

	public BookDAO(Connection con) {
		this.con = con;
	}
	
	public BookVO selectByBookCode(int bookCode) {
		BookVO vo = new BookVO();

		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql = "select * from bookTBL where bookCode = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bookCode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setBookCode(rs.getInt("bookCode"));
				vo.setBookName(rs.getString("bookName"));
				vo.setWriterName(rs.getString("writerName"));
				vo.setCost(rs.getInt("cost"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}	
		
		return vo;
	}
	
	public List<BookVO> selectByBookName(String bookName){
		List<BookVO> list = new ArrayList<BookVO>();

		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql = "select * from bookTBL where bookName like ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,"%"+bookName+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setBookCode(rs.getInt("bookCode"));
				vo.setBookName(rs.getString("bookName"));
				vo.setWriterName(rs.getString("writerName"));
				vo.setCost(rs.getInt("cost"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}			
		
		return list;
	}
	
	public int insert(int bookCode, String bookName, String writerName, int cost) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into bookTBL(bookCode,bookName,writerName,cost)"
				+"values(?,?,?,?)";
		BookVO vo = new BookVO();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bookCode);
			pstmt.setString(2,bookName);
			pstmt.setString(3, writerName);
			pstmt.setInt(4, cost);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}		
		return result;
	}
	
}
