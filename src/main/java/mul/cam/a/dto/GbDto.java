package mul.cam.a.dto;

import java.io.Serializable;

public class GbDto implements Serializable {

	private int seq;
	private String toid;
	private String toname;
	private String fromid;
	private String fromname;
	private String profpic;
	private String comment;
	private int ref;
	private int step;
	private int isvoice;
	private String filename;
	private String regdate;
	
	private int start;
	private int end;
	private int rnum;
	
	public GbDto() {
	}

	public GbDto(int seq, String toid, String toname, String fromid, String fromname, String profpic, String comment,
			int ref, int step, int isvoice, String filename, String regdate, int start, int end, int rnum) {
		super();
		this.seq = seq;
		this.toid = toid;
		this.toname = toname;
		this.fromid = fromid;
		this.fromname = fromname;
		this.profpic = profpic;
		this.comment = comment;
		this.ref = ref;
		this.step = step;
		this.isvoice = isvoice;
		this.filename = filename;
		this.regdate = regdate;
		this.start = start;
		this.end = end;
		this.rnum = rnum;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getToid() {
		return toid;
	}

	public void setToid(String toid) {
		this.toid = toid;
	}

	public String getToname() {
		return toname;
	}

	public void setToname(String toname) {
		this.toname = toname;
	}

	public String getFromid() {
		return fromid;
	}

	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public String getProfpic() {
		return profpic;
	}

	public void setProfpic(String profpic) {
		this.profpic = profpic;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getIsvoice() {
		return isvoice;
	}

	public void setIsvoice(int isvoice) {
		this.isvoice = isvoice;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
}
