package mul.cam.a.dto;

import java.io.Serializable;

public class IDto implements Serializable{
	
	private int seq;
	private String id;
	private String classify;
	private String item;
	private String detail;
	private int ref;
	
	public IDto() {
	}

	public IDto(int seq, String id, String classify, String item, String detail, int ref) {
		super();
		this.seq = seq;
		this.id = id;
		this.classify = classify;
		this.item = item;
		this.detail = detail;
		this.ref = ref;
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

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	@Override
	public String toString() {
		return "IDto [seq=" + seq + ", id=" + id + ", classify=" + classify + ", item=" + item + ", detail=" + detail
				+ ", ref=" + ref + "]";
	}

}
