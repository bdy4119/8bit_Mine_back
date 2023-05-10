package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.FileloadDao;
import mul.cam.a.dto.FileloadDto;
import mul.cam.a.dto.FileloadParam;

@Service
@Transactional
public class FileloadService {

	@Autowired
	FileloadDao dao;

	public List<FileloadDto> fileList(FileloadParam param){
		return dao.fileList(param);
	}


	public int getAllfile() {
		return dao.getAllfile();
	}

	public int uploadFile(FileloadDto dto) {
		return dao.uploadFile(dto);
	}

	
	public int downFile(FileloadDto dto) {
		return dao.downFile(dto);
	}

	public int deleteFile(int mfSeq) {
		return dao.deleteFile(mfSeq);
	}
	
	// file detail
	public FileloadDto fileDetail(int mfSeq) {
		return dao.fileDetail(mfSeq);
	}
	}
