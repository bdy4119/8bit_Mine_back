package mul.cam.a.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dao.MeDao;
import mul.cam.a.dto.CalendarDto;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.service.MeService;
import mul.cam.a.service.MemberService;

@RestController
public class MeController {
	@Autowired
	MeService service;
	
	
	@GetMapping(value = "calList")
	public String calList(Model model) {
		System.out.println("MeController getCalList " + new Date());
		
		List<CalendarDto> list = service.getCalList();
		
		model.addAttribute("calList", list);
		
		return "calList";
	}
	
	
}
