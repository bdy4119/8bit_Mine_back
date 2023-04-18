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
import mul.cam.a.dto.DiaryDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.dto.TodoDto;
import mul.cam.a.service.MeService;
import mul.cam.a.service.MemberService;

@RestController
public class MeController {
	@Autowired
	MeService service;

	
	//todo리스트 불러오기
	@GetMapping(value = "todoList")
	public Map<String, Object> getTodoList(MeParam param) {
		System.out.println("MeController getTodoList " + new Date());

		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
				
		param.setStart(start);
		param.setEnd(end);
		
		List<TodoDto> list = service.getTodoList();
		int len = service.getAllDiary(param);
		
	//	System.out.println(list);
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len); // 페이지수x -> 글의 총수
		
		
		return map;		
	}
	
	
	//todo글쓰기
	@PostMapping(value="todoWrite")
	public String writeTodo(TodoDto dto) {
		System.out.println("MeController writeTodo " + new Date());
		
		boolean b = service.writeTodo(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	//Todo수정
	@PostMapping(value="TodoUpdate")
	public String updateTodo(TodoDto dto) {
		System.out.println("MeController updateTodo " + new Date());
		
		boolean b = service.updateTodo(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	//todo삭제
	@GetMapping(value="deleteTodo")
	public void deleteTodo(int seq) {
		System.out.println("MeController deleteTodo " + new Date());
		
		service.deleteTodo(seq);
	}
	
	
	//diary리스트 불러오기
	@GetMapping(value = "diaryList")
	public Map<String, Object> getDiaryList(MeParam param) {
		System.out.println("MeController getDiaryList " + new Date());
		
		// 글의 시작과 끝
		int pn = param.getPageNumber();  // 0 1 2 3 4
		int start = 1 + (pn * 10);	// 1  11
		int end = (pn + 1) * 10;	// 10 20 
		
		param.setStart(start);
		param.setEnd(end);
		
		List<DiaryDto> list = service.getDiaryList(param);
		int len = service.getAllDiary(param);
		
		System.out.println(list);
		System.out.println(len);
		
		Map<String,Object> map = new HashMap<>();
		map.put("list", list);
		map.put("cnt", len); // 페이지수x -> 글의 총수
		
		return map;		
	}
	
	
	
	//diary글쓰기
	@PostMapping(value="diaryWrite")
	public String diaryWrite(DiaryDto dto) {
		System.out.println("MeController diaryWrite " + new Date());
		
		boolean b = service.writeDiary(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	//diary수정
	@PostMapping(value="diaryUpdate")
	public String updateDiary(DiaryDto dto) {
		System.out.println("MeController updateDiary " + new Date());
		
		boolean b = service.updateDiary(dto);
		if(b == false) {
			return "NO";
		}
		return "YES";
	}
	
	
	//diary삭제
	@GetMapping(value="deleteDiary")
	public void deleteDiary(int seq) {
		System.out.println("MeController deleteDiary " + new Date());
		
		service.deleteDiary(seq);
	}
	
	
	
}
