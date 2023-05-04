package mul.cam.a.dto;

import java.io.Serializable;

public class FileloadParam implements Serializable {
	
	
	
	private int pageNumber; //[1][2][3]
	private String choice, search; //제목, 내용, 메모??
	
	private int start, end; // 시작 , 끝
	
	public FileloadParam() {
		// TODO Auto-generated constructor stub
	}

	public FileloadParam(int pageNumber, String choice, String search, int start, int end) {
		super();
		this.pageNumber = pageNumber;
		this.choice = choice;
		this.search = search;
		this.start = start;
		this.end = end;
	}




	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "FileloadParam [pageNumber=" + pageNumber + ", choice=" + choice + ", search=" + search + ", start="
				+ start + ", end=" + end + "]";
	}

	
}	
	