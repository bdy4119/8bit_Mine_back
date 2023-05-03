package mul.cam.a.dto;

import java.io.Serializable;

public class FileloadDto implements Serializable {
	
private int mfSeq;
private String mfuserId, mfCategory,mfTitle,mfRegdate,mfMemo,mfFileId,mfFilename,mfNFilename;


public FileloadDto() {
}

public FileloadDto(int mfSeq, String mfuserId, String mfCategory, String mfTitle, String mfRegdate, String mfMemo,
		String mfFileId, String mfFilename, String mfNFilename) {
	super();
	this.mfSeq = mfSeq;
	this.mfuserId = mfuserId;
	this.mfCategory = mfCategory;
	this.mfTitle = mfTitle;
	this.mfRegdate = mfRegdate;
	this.mfMemo = mfMemo;
	this.mfFileId = mfFileId;
	this.mfFilename = mfFilename;
	this.mfNFilename = mfNFilename;
}

public int getMfSeq() {
	return mfSeq;
}

public void setMfSeq(int mfSeq) {
	this.mfSeq = mfSeq;
}

public String getMfuserId() {
	return mfuserId;
}

public void setMfuserId(String mfuserId) {
	this.mfuserId = mfuserId;
}

public String getMfCategory() {
	return mfCategory;
}

public void setMfCategory(String mfCategory) {
	this.mfCategory = mfCategory;
}

public String getMfTitle() {
	return mfTitle;
}

public void setMfTitle(String mfTitle) {
	this.mfTitle = mfTitle;
}

public String getMfRegdate() {
	return mfRegdate;
}

public void setMfRegdate(String mfRegdate) {
	this.mfRegdate = mfRegdate;
}

public String getMfMemo() {
	return mfMemo;
}

public void setMfMemo(String mfMemo) {
	this.mfMemo = mfMemo;
}

public String getMfFileId() {
	return mfFileId;
}

public void setMfFileId(String mfFileId) {
	this.mfFileId = mfFileId;
}

public String getMfFilename() {
	return mfFilename;
}

public void setMfFilename(String mfFilename) {
	this.mfFilename = mfFilename;
}

public String getMfNFilename() {
	return mfNFilename;
}

public void setMfNFilename(String mfNFilename) {
	this.mfNFilename = mfNFilename;
}

@Override
public String toString() {
	return "FileloadDto [mfSeq=" + mfSeq + ", mfuserId=" + mfuserId + ", mfCategory=" + mfCategory + ", mfTitle="
			+ mfTitle + ", mfRegdate=" + mfRegdate + ", mfMemo=" + mfMemo + ", mfFileId=" + mfFileId + ", mfFilename="
			+ mfFilename + ", mfNFilename=" + mfNFilename + "]";
}
}
