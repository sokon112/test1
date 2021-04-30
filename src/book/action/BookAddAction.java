package book.action;

import java.util.Scanner;

import book.domain.BookVO;
import book.service.BookAddService;
import book.ui.ConsoleUtil;

public class BookAddAction implements Action {

	@Override
	public void execute(Scanner sc) {
		ConsoleUtil util = new ConsoleUtil();
		BookVO vo = util.printAddMessege(sc);
		BookAddService service = new BookAddService();
		
		boolean result = service.addBook(
				vo.getBookCode(), vo.getBookName(), vo.getWriterName(), vo.getCost());
		if(result) {
			util.printAddSuccessMessege();
		}else {
			util.printAddFailMessege();
		}
		
	}

}
