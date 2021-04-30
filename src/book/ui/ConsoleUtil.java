package book.ui;

import java.util.List;
import java.util.Scanner;

import book.domain.BookVO;

public class ConsoleUtil {
	
	public int printSelectByCodeMessege(Scanner sc) {
		int bookCode=0;
		
		System.out.println("*** 도서 정보 조회 화면 ***");
		System.out.print("도서 코드 >> ");
		bookCode = Integer.parseInt(sc.nextLine());		
		
		return bookCode;
	}
	
	public String printSelectByNameMessege(Scanner sc) {
		String bookName = null;
		
		System.out.println("*** 도서 정보 조회 화면 ***");
		System.out.print("도서명 >> ");
		bookName = sc.nextLine();		
		
		return bookName;
	}
	
	public void printSelectByCodeSuccessMessege(BookVO vo) {
		System.out.println("**** 요청하신 도서 정보는 다음과 같습니다. ****");
		System.out.println("1. 도서코드 \t>> "+vo.getBookCode());
		System.out.println("2. 도서명 \t>> "+vo.getBookName());
		System.out.println("3. 도서저자 \t>> "+vo.getWriterName());
		System.out.println("4. 도서가격 \t>> "+vo.getCost());
	}
	
	public void printSelectByNameSuccessMessege(List<BookVO> list) {
		System.out.println("**** 요청하신 도서 정보는 다음과 같습니다. ****");
		System.out.println("도서코드\t도서명\t도서저자\t도서가격");
		for(BookVO vo:list) {
			System.out.printf("%d\t%s\t%s\t%d",
					vo.getBookCode(),vo.getBookName(),vo.getWriterName(),vo.getCost());
			System.out.println();
		}
		System.out.println();
		
	}
	
	public void printSelectFailMessege() {
		System.out.println("\n찾으시는 도서가 없습니다.\n");
	}

	public BookVO printAddMessege(Scanner sc) {
		BookVO vo = new BookVO();
		System.out.println("**************** 도서 정보 입력 ****************");
		System.out.print("1. 도서코드(4자리 숫자) >> ");
		vo.setBookCode(Integer.parseInt(sc.nextLine()));
		System.out.print("2. 도서명 >> ");
		vo.setBookName(sc.nextLine());
		System.out.print("3. 도서저자 >> ");
		vo.setWriterName(sc.nextLine());
		System.out.print("4. 도서가격 >> ");
		vo.setCost(Integer.parseInt(sc.nextLine()));
		
		return vo;
	}
	
	public void printAddSuccessMessege() {
		System.out.println("도서 정보 입력 성공");
	}
	
	public void printAddFailMessege() {
		System.out.println("도서 정보 입력 실패");
	}
}

























