package book.service;

import java.sql.Connection;

import book.dao.BookDAO;
import book.domain.BookVO;

import static book.dao.JDBCUtil.*;

public class BookCodeSearchService {
	
	public BookVO getBook(int bookCode) {
		
		Connection con = getConnection();
		BookDAO dao = new BookDAO(con);
		BookVO vo = dao.selectByBookCode(bookCode);
		close(con);
		
		return vo;
	}

}
