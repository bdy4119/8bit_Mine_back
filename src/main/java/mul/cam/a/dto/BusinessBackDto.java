package mul.cam.a.dto;

import java.io.Serializable;

//명함 뒷면
public class BusinessBackDto implements Serializable{

	private int seq;
    private String id; 
	private String historyDate; // 수행날짜
    private String historyTitle;  // 수행제목
    private String historyContent; //수행내용
    private String historyUrl;
    private String wdate;
    
    
    //기본생성자
    public BusinessBackDto() {
    	
    }

    //외부에서 입력받는 생성자
	public BusinessBackDto(String historyDate, String historyTitle,
							String historyContent, String historyUrl) {
		super();
		this.historyDate = historyDate;
		this.historyTitle = historyTitle;
		this.historyContent = historyContent;
		this.historyUrl = historyUrl;
	}
    
    
	public BusinessBackDto(int seq, String id, String historyDate, String historyTitle, String historyContent,
			String historyUrl, String wdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.historyDate = historyDate;
		this.historyTitle = historyTitle;
		this.historyContent = historyContent;
		this.historyUrl = historyUrl;
		this.wdate = wdate;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	public String getHistoryTitle() {
		return historyTitle;
	}

	public void setHistoryTitle(String historyTitle) {
		this.historyTitle = historyTitle;
	}

	public String getHistoryContent() {
		return historyContent;
	}

	public void setHistoryContent(String historyContent) {
		this.historyContent = historyContent;
	}

	public String getHistoryUrl() {
		return historyUrl;
	}

	public void setHistoryUrl(String historyUrl) {
		this.historyUrl = historyUrl;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "BusinessBackDto [seq=" + seq + ", id=" + id + ", historyDate=" + historyDate + ", historyTitle="
				+ historyTitle + ", historyContent=" + historyContent + ", historyUrl=" + historyUrl + ", wdate=" + wdate
				+ "]";
	}
	
	
	
	
}
