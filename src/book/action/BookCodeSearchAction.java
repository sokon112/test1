package book.action;

import java.util.Scanner;

import book.domain.BookVO;
import book.service.BookCodeSearchService;
import book.ui.ConsoleUtil;

public class BookCodeSearchAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil util = new ConsoleUtil();
		BookVO vo = new BookVO();
		BookCodeSearchService service = new BookCodeSearchService();
		int bookCode = util.printSelectByCodeMessege(sc);
		
		vo = service.getBook(bookCode);
		if(vo.getBookName()!=null) {
			util.printSelectByCodeSuccessMessege(vo);
		}else {
			util.printSelectFailMessege();
		}		
		
	}

}
