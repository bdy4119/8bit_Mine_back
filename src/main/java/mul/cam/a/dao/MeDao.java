package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.DiaryDto;
import mul.cam.a.dto.MeParam;
import mul.cam.a.dto.TodoDto;
import mul.cam.a.dto.TodoParam;

@Mapper
@Repository
public interface MeDao {
	//todo리스트
	List<TodoDto> getTodoList(TodoParam param);
	
	//todo 글쓰기
	int writeTodo(TodoDto dto);
	
	//todo 수정
	int updateTodo(TodoDto dto);
	
	//todo 수정
	int updateCheck(TodoDto dto);
	
	//todo 삭제
	public void deleteTodo(int seq);
	
	//todo글의 총수
	int getAllTodo(TodoParam param);
	
	
	
	//diary리스트 -> 오늘이랑 같은 날짜만 보내주기
	List<DiaryDto> getDiaryList(MeParam param);

	//diary 글쓰기
	int writeDiary(DiaryDto dto);
	
	//diary 수정
	int updateDiary(DiaryDto dto);
	
	//diary 삭제
	public void deleteDiary(int seq);
	
	//diary글의 총수
	int getAllDiary(MeParam param);

	//diary리스트 -> 전체 보내주기(달력 뿌릴용)
	List<DiaryDto> getDiaryCalList(MeParam param);
}
