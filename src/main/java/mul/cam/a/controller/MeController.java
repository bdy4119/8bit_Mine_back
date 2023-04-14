package mul.cam.a.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.cam.a.dao.MeDao;
import mul.cam.a.dto.CalendarDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.dto.TodoDto;
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
	
	
	
	@GetMapping(value = "todoList")
	public Map<String, Object> getTodoList() {
		System.out.println("MeController getTodoList " + new Date());

		List<TodoDto> list = service.getTodoList();
		
		System.out.println(list);
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		
		
		return map;		
	}
	
	
	
}
