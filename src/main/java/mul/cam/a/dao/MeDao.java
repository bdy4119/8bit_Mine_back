package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.CalendarDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.MemberDto;
import mul.cam.a.dto.TodoDto;

@Mapper
@Repository
public interface MeDao {
	
	//calendar리스트 불러오기
	List<CalendarDto> getCalList();
	
	//todo리스트
	List<TodoDto> getTodoList();
	
}
