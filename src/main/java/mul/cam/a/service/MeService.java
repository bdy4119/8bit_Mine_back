package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MeDao;
import mul.cam.a.dto.DiaryDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.TodoDto;
import mul.cam.a.dto.TodoParam;

@Service
@Transactional
public class MeService {
	@Autowired
	MeDao dao;
	
	public List<TodoDto> getTodoList(TodoParam param) {
		return dao.getTodoList(param);
	}
	
	public int getAllTodo(TodoParam param) {
		return dao.getAllTodo(param);
	}
	
	public boolean writeTodo(TodoDto dto) {
		int n = dao.writeTodo(dto);
		return n>0?true:false;
	}
	
	public boolean updateTodo(TodoDto dto) {
		int n = dao.updateTodo(dto);
		return n>0?true:false;
	}
	
	public boolean updateCheck(TodoDto dto) {
		int n = dao.updateCheck(dto);
		return n>0?true:false;
	}
	
	public void deleteTodo(int seq) {
		dao.deleteTodo(seq);
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
	
	public boolean updateDiary(DiaryDto dto) {
		int n = dao.updateDiary(dto);
		return n>0?true:false;
	}
	
	public void deleteDiary(int seq) {
		dao.deleteDiary(seq);
	}
	
	
	//전체 보내주기 -> 달력 뿌릴용
	public List<DiaryDto> getDiaryCalList(MeParam param) {
		return dao.getDiaryCalList(param);
	}
	
}



























