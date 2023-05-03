package mul.cam.a.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.APIS;
import mul.cam.a.dto.IDto;
import mul.cam.a.dto.QnaDto;
import mul.cam.a.service.IService;


@RestController
public class IController {
	@Autowired
	IService service;
	
	@GetMapping(value = "i_add")
	public void i_add(IDto dto) {
		System.out.println("IController i_add() : " + new Date());
		service.i_add(dto);
	}
	
	@GetMapping(value = "i_add_classi")
	public String i_add_classi(IDto dto) {
		System.out.println("IController i_add_classi() : " + new Date());
		boolean b = service.i_add_classi(dto);
		if(b) {
			return "add_classi_OK";
		} else {
			return "add_classi_NO";
		}
	}
	
	@GetMapping(value = "i_classi_list")
	public List<IDto> i_classi_list(String id) {
		System.out.println("IController i_classi_list() : " + new Date());
		
		return service.i_classi_list(id);
	}
	
	@GetMapping(value = "i_detail")
	public List<IDto> i_detail(IDto dto) {
		System.out.println("IController i_detail() : " + new Date());
		
		return service.i_detail(dto);
	}
	
	@GetMapping(value = "i_del")
	public String i_del(IDto dto) {
		System.out.println("IController i_del() : " + new Date());
		
		boolean b1 = service.i_del(dto);
		boolean b2 = service.i_del_classi(dto);
		
		if(b1&&b2) {
			return "i_del_OK";
		} else {
			return "i_del_NO";
		}
		
	}
	
	@GetMapping(value = "i_add_qna")
	public String i_add_qna(QnaDto dto) {
		System.out.println("IController i_add_qna() : " + new Date());
		
		if(service.i_add_qna(dto)) {
			return "i_add_qna_OK";
		} else {
			return "i_add_qna_NO";
		}
		
	}
	
	@GetMapping(value = "i_del_qna")
	public void i_del_qna(String id) {
		System.out.println("IController i_del_qna() : " + new Date());
		
		service.i_del_qna(id);
	}
	
	@GetMapping(value = "i_qna")
	public QnaDto i_qna(String id) {
		System.out.println("IController i_qna() : " + new Date());
		
		return service.i_qna(id);
	}
	
	@GetMapping(value = "naverBook")
	public String naverBook(String search, int page) {
		System.out.println("IController naverBook() : " + new Date());
		
		return APIS.naverBook(search, page);
	}
	
	@GetMapping(value = "tmdb")
	public Map tmdb(String kind, String query, int page) throws Exception {
		System.out.println("IController tmdb() : " + new Date());
		
		return APIS.tmdb(kind, query, page);
	}
	
	@GetMapping(value = "kakaoLocal")
	public Map kakaoLocal(String query, int page) throws Exception {
		System.out.println("IController kakaoLocal() : " + new Date());
		
		return APIS.kakaoLocal(query, page);
	}
}
