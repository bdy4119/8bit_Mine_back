package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MeDao;
import mul.cam.a.dao.MemberDao;
import mul.cam.a.dto.CalendarDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.dto.TodoDto;

@Service
@Transactional
public class MeService {
	@Autowired
	MeDao dao;
	
	public List<CalendarDto> getCalList() {
		return dao.getCalList();
	}
	
	public List<TodoDto> getTodoList() {
		return dao.getTodoList();
	}
	
}



























