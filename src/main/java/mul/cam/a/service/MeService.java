package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MeDao;
import mul.cam.a.dao.MemberDao;
import mul.cam.a.dto.DiaryDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.dto.TodoDto;

@Service
@Transactional
public class MeService {
	@Autowired
	MeDao dao;
	
	public List<TodoDto> getTodoList() {
		return dao.getTodoList();
	}
	
	public boolean writeTodo(TodoDto dto) {
		int n = dao.writeTodo(dto);
		return n>0?true:false;
	}
	
	public List<DiaryDto> getDiaryList(MeParam param) {
		return dao.getDiaryList(param);
	}
	
	public int getAllDiary(MeParam param) {
		return dao.getAllDiary(param);
	}
	
	public boolean writeDiary(DiaryDto dto) {
		int n = dao.writeDiary(dto);
		return n>0?true:false;
	}
	
	
}



























