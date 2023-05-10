package mul.cam.a.dto;
import java.io.Serializable;
public class FileloadDto implements Serializable {
 
private int mfSeq;
private String mfuserId, mfCategory,mfTitle,mfRegdate,mfMemo,mfFileId,mfFilename,mfNewFilename;
public FileloadDto() {
}
public FileloadDto(int mfSeq, String mfCategory, String mfTitle, String mfRegdate, String mfMemo,
 String mfFileId, String mfFilename, String mfNewFilename) {
 super();
 this.mfSeq = mfSeq;
 this.mfCategory = mfCategory;
 this.mfTitle = mfTitle;
 this.mfRegdate = mfRegdate;
 this.mfMemo = mfMemo;
 this.mfFileId = mfFileId;
 this.mfFilename = mfFilename;
 this.mfNewFilename = mfNewFilename;
}
public int getMfSeq() {
 return mfSeq;
}
public void setMfSeq(int mfSeq) {
 this.mfSeq = mfSeq;
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
 return mfNewFilename;
}
public void setMfNFilename(String mfNewFilename) {
 this.mfNewFilename = mfNewFilename;
}
@Override
public String toString() {
 return "FileloadDto [mfSeq=" + mfSeq + ", mfCategory=" + mfCategory + ", mfTitle="
 + mfTitle + ", mfRegdate=" + mfRegdate + ", mfMemo=" + mfMemo + ", mfFileId=" + mfFileId + ", mfFilename="
 + mfFilename + ", mfNewFilename=" + mfNewFilename + "]";
}
}
