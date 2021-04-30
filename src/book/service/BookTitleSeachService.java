package book.service;

import java.sql.Connection;
import java.util.List;

import book.dao.BookDAO;
import book.domain.BookVO;

import static book.dao.JDBCUtil.*;

public class BookTitleSeachService {
	
	public List<BookVO> listBook(String bookName){
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		List<BookVO> list = dao.selectByBookName(bookName);
		
		close(con);
		return list;		
	}
	

}
