package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.FileloadDto;
import mul.cam.a.dto.FileloadParam;



@Mapper
@Repository
public interface FileloadDao {
	
	List<FileloadDto> fileList(FileloadParam param); //리스트
//	List<FileloadDto> Filelist(); //리스트
	
//	List<FileloadDto> Filesearch(FileloadParam param); // 검색
	
//	int getAllfile(FileloadParam param);// 글의총수	
	
	int getAllfile();

	FileloadDto fileDetail(int mfSeq);// 파일 상세보기
//	
	int uploadFile(FileloadDto dto); // 파일 업로드
	
	int downFile(FileloadDto File); // 파일 다운로드

//	int updateFile(int mfSeq);// 파일 수정
	
	int deleteFile(int mfSeq);// 파일 삭제
	
}
