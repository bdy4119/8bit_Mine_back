package mul.cam.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.SocialDto;
import mul.cam.a.service.SocialService;



@RestController
public class SocialController {

	@Autowired
	SocialService service;

	@GetMapping(value = "social_sel")
	public SocialDto social_sel(int seq) {
		System.out.println("SocialController social_sel() : " + new Date());

		return service.social_sel(seq);
	}
	
	@GetMapping(value = "social_list")
	public List<SocialDto> social_list(String owner) {
		System.out.println("SocialController social_list() : " + new Date());

		return service.social_list(owner);
	}
	
	@GetMapping(value = "social_add")
	public String social_add(SocialDto dto) {
		System.out.println("SocialController social_add() : " + new Date());

		if(service.social_add(dto)) {
			return "social_add_OK";
		} else {
			return "social_add_NO";
		}
	}
	
	@GetMapping(value = "social_del")
	public String social_del(int seq) {
		System.out.println("SocialController social_del() : " + new Date());
		
		if(service.social_del(seq)) {
			return "social_del_OK";
		} else {
			return "social_del_NO";
		}
	}
	
	@GetMapping(value = "social_upd")
	public String social_upd(SocialDto dto) {
		System.out.println("SocialController social_upd() : " + new Date());
		
		if(service.social_upd(dto)) {
			return "social_upd_OK";
		} else {
			return "social_del_NO";
		}
	}

}
