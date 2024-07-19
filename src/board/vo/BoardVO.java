package board.vo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BoardVO {

	private BigDecimal boardNo;
	private LocalDateTime boardDate;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int prePage;
	private int nextPage;
	
	public BigDecimal getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(BigDecimal boardNo) {
		this.boardNo = boardNo;
	}
	public LocalDateTime getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(LocalDateTime boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardDate=" + boardDate + ", boardWriter=" + boardWriter
				+ ", boardTitle=" + boardTitle + ", boardContent=" + boardContent + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + "]";
	}

}
