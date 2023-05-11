package mul.cam.a.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import mul.cam.a.APIS;
import mul.cam.a.dto.GbDto;
import mul.cam.a.service.GbService;


@RestController
public class GbController {

	@Autowired
	GbService service;

	@GetMapping(value = "gb_list")
	public List<GbDto> gb_list(String id) {
		System.out.println("GbController gb_list() : " + new Date());

		return service.gb_list(id);
	}
	
	@GetMapping(value = "gb_visit")
	public List<GbDto> gb_visit(GbDto dto) {
		System.out.println("GbController gb_visit() : " + new Date());

		return service.gb_visit(dto);
	}
	
	@GetMapping(value = "gb_upd")
	public String gb_upd(GbDto dto) {
		System.out.println("GbController gb_upd() : " + new Date());
		
		if(service.gb_upd(dto)) {
			return "gb_upd_OK";
		} else {
			return "gb_upd_NO";
		}
	}
	
	@GetMapping(value = "gb_del")
	public String gb_del(int seq) {

		if(service.gb_del(seq)) {
			return "gb_del_OK";
		} else {
			return "gb_del_NO";
		}
	}
	
	@GetMapping(value = "gb_detail")
	public GbDto gb_detail(int seq) {
		
		return service.gb_detail(seq);
	}

	@PostMapping(value = "sttUpload")
	public Map sttUpload(@RequestParam("uploadFile")MultipartFile uploadFile, HttpServletRequest req) {

		System.out.println("GbController sttUpload : " + new Date());

		String uploadpath = req.getServletContext().getRealPath("/upload");
		String filename = System.currentTimeMillis() + ".wav";
		String filepath = uploadpath + "/" + filename;
		
		String publicpath = "C:/react/8bit_Mine_Front/public/voice";
		String publicUpload = publicpath + "/" + filename;
		
		try {
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			bos.write(uploadFile.getBytes());
			bos.close();
			
			BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(new File(publicUpload)));
			bos2.write(uploadFile.getBytes());
			bos2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		String resp = APIS.stt(filepath);
		
		System.out.println(filename);

		Map<String, String> map =  new HashMap<String, String>();
		map.put("filename", filename);
		map.put("resp", resp);
		return map;
		
	}
	
	@GetMapping(value = "gb_add")
	public String gb_add(GbDto dto) {
		System.out.println("GbController gb_add() : " + new Date());
		
		if(dto.getIsvoice()==0) {
			dto.setFilename(null);
		}
		
		if(service.gb_add(dto)) {
			return "gb_add_OK";
		} else {
			return "gb_add_NO";
		}
		
	}
	

}