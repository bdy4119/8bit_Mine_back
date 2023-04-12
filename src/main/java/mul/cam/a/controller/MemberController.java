package mul.cam.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "테스트";
	}
	
	@GetMapping(value = "allmember")
	public List<MemberDto> allmember(){
		System.out.println("MemberController allmember() " + new Date());
		
		return service.allmember();
	}
	
	/*@PostMapping(value = "findname")
	public String findname(String name) {
		System.out.println("MemberController findname() " + new Date());
		
		System.out.println("name: " + name);
		
		return "검색 완료";
	}*/
	
	@PostMapping(value = "idcheck")
	public String idcheck(String id) {
		System.out.println("MemberController idcheck() " + new Date());
		
		boolean b = service.idcheck(id);
		
		if (b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "addmember")
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember() " + new Date());
		
		boolean b = service.addmemeber(dto);
		
		if (!b) {
			return "NO";
		}
		
		return "YES";
	}
	
	@PostMapping(value = "login")
	public MemberDto login(MemberDto dto) {
		System.out.println("MemberController login() " + new Date());
		
		return service.login(dto);
	}
}
