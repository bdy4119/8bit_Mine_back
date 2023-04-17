package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.DiaryDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.TodoDto;

@Mapper
@Repository
public interface MeDao {
	//todo리스트
	List<TodoDto> getTodoList();
	
	//todo 글쓰기
	int writeTodo(TodoDto dto);
	
	//diary리스트
	List<DiaryDto> getDiaryList(MeParam param);

	//diary 글쓰기
	int writeDiary(DiaryDto dto);
	
	//diary글의 총수
	int getAllDiary(MeParam param);
	
}
