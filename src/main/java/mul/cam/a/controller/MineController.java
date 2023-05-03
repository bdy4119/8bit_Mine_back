package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mul.cam.a.dto.MineDto;
import mul.cam.a.util.NaverCloud;
import mul.cam.a.service.MineService;
import mul.cam.a.util.FileUtil;

@RestController
public class MineController {
	@Autowired
	MineService service;
	
	@PostMapping(value = "minedata")
	public MineDto minedata(int position){
		System.out.println("minedata " + new Date());
		System.out.println("position: " + position);
		
		return service.mineData(position);		
	}
	

	@PostMapping(value = "minelist")
	public List<MineDto> minelist(String id){
		System.out.println("minelist " + new Date());
		
		return service.minelist(id);		
	}
	
	@PostMapping(value = "updatemine")
	public String updatemine(MineDto dto){
		System.out.println("updatemine " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.updatemine(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "insertmine")
	public String insertmine(MineDto dto){
		System.out.println("insertmine " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.insertmine(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "deletemine")
	public String deletemine(MineDto dto){
		System.out.println("deletemine " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.deletemine(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "checkmine")
	public String checkmine(MineDto dto){
		System.out.println("checkmine " + new Date());
		
		boolean b = service.checkmine(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "stageinsert")
	public String stageinsert(MineDto dto){
		System.out.println("stageinsert " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.stageinsert(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "stageupdate")
	public String stageupdate(MineDto dto){
		System.out.println("stageupdate " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.stageupdate(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "queinsert")
	public String queinsert(MineDto dto){
		System.out.println("queinsert " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.queinsert(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "queupdate")
	public String queupdate(MineDto dto){
		System.out.println("queupdate " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.queupdate(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	
	
	// 추가
	@PostMapping(value = "/oninsert")
	public String oninsert(MineDto mine, 
							@RequestParam("uploadFile")
							MultipartFile uploadFile, 
							HttpServletRequest req) {
		System.out.println("HelloController fileUpload " + new Date());
		
		String filename = uploadFile.getOriginalFilename();				
		
		mine.setFilename(filename);
		
		String newfilename = FileUtil.getNewFileName(filename);
		
		mine.setNewfilename(newfilename);
		
		System.out.println(mine.toString());
		
		String filepath = "C:/react/8bit_Mine_Front/public/img/" + newfilename;
		
		File file = new File(filepath);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(uploadFile.getBytes());			
			bos.close();
			
		} catch (Exception e) {			
			return "file upload fail";
		}
		
		service.insertmine(mine);
		
		return "file upload success";
	}
	
	// 수정
	@PostMapping(value = "/onupdate")
	public String onupdate(MineDto mine, 
							@RequestParam("uploadFile")
							MultipartFile uploadFile, 
							HttpServletRequest req) {
		System.out.println("HelloController fileUpload " + new Date());
		
		String filename = uploadFile.getOriginalFilename();				
		
		mine.setFilename(filename);
		
		String newfilename = FileUtil.getNewFileName(filename);
		
		mine.setNewfilename(newfilename);
		
		System.out.println(mine.toString());
		
		String filepath = "C:/react/8bit_Mine_Front/public/img/" + newfilename;
		File file = new File(filepath);
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			bos.write(uploadFile.getBytes());	
			bos.close();
			
		} catch (Exception e) {			
			return "file upload fail";
		}
		
		service.updatemine(mine);
		
		return "file upload success";
	}
	
	@PostMapping(value = "fileload")	// 파일 다운로드 버튼 누른 후 controller로 이동한 지점
	public File filedownLoad(int position, HttpServletRequest req, HttpServletResponse resp) {
		
		MineDto mine = service.mineData(position);	
		
		// 경로 취득
		String fupload = req.getServletContext().getRealPath("/upload");	
		
		// 다운로드 받을 파일 보내줌
		File downloadFile = new File(fupload + "/" + mine.getNewfilename());
		
		resp.setContentType("image/pjpeg");
		System.out.println(downloadFile);
		
		return downloadFile; 		// file-context.xml의 DownloadView 객체 생성시 id값
	}
	
	@PostMapping(value = "chatBot")
	public String chatBot(String msg) {
		System.out.println("NaverCloudController chatBot " + new Date());
		
		String json = NaverCloud.chatBot(msg);		
		return json;		
	}

}
