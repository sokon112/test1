package book.action;

import java.util.List;
import java.util.Scanner;

import book.domain.BookVO;
import book.service.BookTitleSeachService;
import book.ui.ConsoleUtil;

public class BookTitleSearchAction implements Action {

	@Override
	public void execute(Scanner sc) {
		String bookName = null;
		ConsoleUtil util = new ConsoleUtil();
		BookTitleSeachService service = new BookTitleSeachService();
		
		bookName = util.printSelectByNameMessege(sc);
		List<BookVO> list = service.listBook(bookName);
		
		if(list!=null) {
			util.printSelectByNameSuccessMessege(list);
		}else {
			util.printSelectFailMessege();
		}
		
	}

}
