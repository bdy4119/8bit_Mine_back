package mul.cam.a.dto;

import java.io.Serializable;

public class MineDto implements Serializable{
	
	private int seq;
	private String id;
	private int position;
	private String filename;
	private String newfilename;
	private String imgtext;
	
	public MineDto() {
		
	}

	public MineDto(int seq, String id, int position, String filename, String newfilename, String imgtext) {
		super();
		this.seq = seq;
		this.id = id;
		this.position = position;
		this.filename = filename;
		this.newfilename = newfilename;
		this.imgtext = imgtext;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public String getImgtext() {
		return imgtext;
	}

	public void setImgtext(String imgtext) {
		this.imgtext = imgtext;
	}

	@Override
	public String toString() {
		return "MineDto [seq=" + seq + ", id=" + id + ", position=" + position + ", filename=" + filename
				+ ", newfilename=" + newfilename + ", imgtext=" + imgtext + "]";
	}

}
