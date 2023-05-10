package mul.cam.a.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mul.cam.a.MediaTypeUtils;
import mul.cam.a.dto.FileloadDto;
import mul.cam.a.dto.FileloadParam;
import mul.cam.a.service.FileloadService;
import mul.cam.a.util.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class FileloadController {

	@Autowired
	FileloadService service;

	

	@PostMapping("fileList")
	public List<FileloadDto> fileList(FileloadParam param){

		System.out.println("FileloadController fileList()" + new Date());

		// 글의 시작과 끝
		int pn = param.getPageNumber(); // 0 1 2 3 4
		int start = 1 + (pn * 5); // [1] 1 시작, [2] 6 시작...
		int end = (pn + 1) * 5; // [1] 5 끝, [2] 10에서 끝

		param.setStart(start);
		param.setEnd(end);

		System.out.println(param.toString());
		List<FileloadDto> fileList = service.fileList(param);

		return fileList;

	} // 글의 총수
	@GetMapping("getAllfile")
	public int getAllfile() {
		System.out.println("FileloadController getAllfile() : " + new Date());

		return service.getAllfile();
	}
	
	
	// 상세 페이지
	@GetMapping("fileDetail")
	public FileloadDto fileDetail(int mfSeq) {
		System.out.println(mfSeq);
		return service.fileDetail(mfSeq);
	}
	
	// 파일 삭제
	@GetMapping("deleteFile")
	public String deleteFile(int mfSeq) {
		System.out.println("FileloadController deleteFile() : " + new Date());

		if(service.deleteFile(mfSeq)>0) {
			return "del_File_OK";
		} else {
			return "del_File_NO";
		}
	}





	// 파일 upload
	@PostMapping("/uploadFile")
	public String uploadFile(FileloadDto dto, @RequestParam("fileLoad") MultipartFile fileLoad, HttpServletRequest req)
			throws IOException {
		
		System.out.println(dto.toString());

		// req.getServletContext() 웹경로
		String path = req.getServletContext().getRealPath("/upload");

		// 원본파일명.
		String filename = fileLoad.getOriginalFilename();
		String newFileName = FileUtil.getNewFileName(filename);
		dto.setMfFilename(newFileName);

		String filepath = "/upload/" + newFileName;
		dto.setMfNFilename(filepath);

		File file = new File(path + "/" + newFileName);
		FileUtils.writeByteArrayToFile(file, fileLoad.getBytes());

		return service.uploadFile(dto) > 0 ? "파일 업로드 완료" : "실패";
	}

	
	// 파일 download
	@Autowired
	ServletContext servletcontext;
	
	@GetMapping(value = "downFile")
	public ResponseEntity<InputStreamResource> download(String filename, HttpServletRequest req) throws Exception {
	
		System.out.println("fileloadController fileDownload() : " + new Date());
		
		//경로
		String path = req.getServletContext().getRealPath("/upload");
		
		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletcontext, filename);
		System.out.println("filename : " + filename);
		System.out.println("mediaType : " + mediaType);
		
		File file = new File(path + File.separator + filename);
		
		InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment;filename=" + file.getName()).contentType(mediaType)
				.contentLength(file.length()).body(isr);
	}


} // end of FileloadController
