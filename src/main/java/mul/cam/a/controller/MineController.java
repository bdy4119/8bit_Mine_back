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
import mul.cam.a.dto.MineAnswerDto;
import mul.cam.a.dto.MineDto;
import mul.cam.a.dto.NoticeDto;
import mul.cam.a.util.NaverCloud;
import mul.cam.a.service.MineService;
import mul.cam.a.util.FileUtil;

@RestController
public class MineController {
	@Autowired
	MineService service;
	
	@PostMapping(value = "minedata")
	public MineDto minedata(MineDto dto){
		System.out.println("minedata " + new Date());
		System.out.println("dto: " + dto);
		
		return service.mineData(dto);		
	}
	

	@PostMapping(value = "minelist")
	public List<MineDto> minelist(String id){
		System.out.println("minelist " + new Date());
		System.out.println("id: " + id);
		
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
		System.out.println("dto :" + dto);
		
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
		
		 String filepath = Privatepath.micPath + newfilename;
		
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
		
		String filepath = Privatepath.micPath + newfilename;
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
	
	@PostMapping(value = "chatBot")
	public String chatBot(String msg) {
		System.out.println("NaverCloudController chatBot " + new Date());
		
		String json = NaverCloud.chatBot(msg);		
		return json;		
	}
	
	@PostMapping(value = "updateanswer")
	public String updateanswer(MineAnswerDto dto){
		System.out.println("updateanswer " + new Date());
		System.out.println("dto: " + dto.toString());
		
		boolean b = service.updateanswer(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "answerlist")
	public List<MineAnswerDto> answerlist(String mineid){
		System.out.println("answerlist " + new Date());
		System.out.println("id: " + mineid);
		
		return service.answerlist(mineid);		
	}
	
	@PostMapping(value = "deleteanswer")
	public String deleteanswer(int seq){
		System.out.println("deleteanswer " + new Date());
		
		boolean b = service.deleteanswer(seq);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	
	
	@PostMapping(value = "noticemine")
	public int noticemine(String id){
		System.out.println("noticemine " + new Date());
		System.out.println("id: " + id);
		
		boolean b = service.checknotice(id);
		
		if(!b) {
			service.insertnotice(id);
		}
		
		int answer = service.answernum(id);
		int notice = service.noticeminenum(id);
		
		return answer-notice;
	}
	
	@PostMapping(value = "noticemineupdate")
	public String noticemineupdate(NoticeDto dto){
		System.out.println("noticemineupdate " + new Date());
		System.out.println("dto: " + dto.toString());
		
		int answer = service.answernum(dto.getId());
		
		dto.setMinenotice(answer);
		
		boolean b = service.noticemineupdate(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "noticebook")
	public int noticebook(String id){
		System.out.println("noticebook " + new Date());
		System.out.println("id: " + id);
		
		boolean b = service.checknotice(id);
		
		if(!b) {
			service.insertnotice(id);
		}
		
		int guest = service.guestnum(id);
		int notice = service.noticebooknum(id);
		
		return guest-notice;
	}
	
	@PostMapping(value = "noticebookupdate")
	public String noticebookupdate(NoticeDto dto){
		System.out.println("noticebookupdate " + new Date());
		System.out.println("dto: " + dto.toString());
		
		int guest = service.guestnum(dto.getId());
		
		dto.setGuestnotice(guest);
		
		boolean b = service.noticebookupdate(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}

}
