package book.service;

import java.sql.Connection;

import book.dao.BookDAO;

import static book.dao.JDBCUtil.*;

public class BookAddService {
	
	public boolean addBook(int bookCode, String bookName, String writerName, int cost){
		boolean isAdd = false;
		
		Connection con = getConnection();
		
		BookDAO dao = new BookDAO(con);
		int result = dao.insert(bookCode, bookName, writerName, cost);
		if(result>0) {
			commit(con);
			isAdd=true;
		}else {
			rollback(con);
		}
		close(con);
		
		return isAdd;
	}

}
