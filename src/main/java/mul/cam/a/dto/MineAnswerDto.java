package mul.cam.a.dto;

import java.io.Serializable;

public class MineAnswerDto implements Serializable{
	
	private int seq;
	private String userid;
	private String mineid;
	private String answer1;
	private String answer2;
	private String answer3;
	
	public MineAnswerDto() {
		
	}

	public MineAnswerDto(int seq, String userid, String mineid, String answer1, String answer2, String answer3) {
		super();
		this.seq = seq;
		this.userid = userid;
		this.mineid = mineid;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getMineid() {
		return mineid;
	}

	public void setMineid(String mineid) {
		this.mineid = mineid;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	@Override
	public String toString() {
		return "MineAnswerDto [seq=" + seq + ", userid=" + userid + ", mineid=" + mineid + ", answer1=" + answer1
				+ ", answer2=" + answer2 + ", answer3=" + answer3 + "]";
	}

}
