package book.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookVO {
	private int bookCode;
	private String bookName;
	private String writerName;
	private int cost;
	
	public BookVO(int bookCode, String bookName, String writerName, int cost) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.writerName = writerName;
		this.cost = cost;
	}

	public BookVO() {
		super();
	}
	
}
