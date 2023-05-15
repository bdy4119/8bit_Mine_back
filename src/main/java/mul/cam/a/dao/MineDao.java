package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.MineAnswerDto;
import mul.cam.a.dto.MineDto;
import mul.cam.a.dto.NoticeDto;
import mul.cam.a.dto.MineDto;

@Mapper
@Repository
public interface MineDao {
	
	MineDto mineData(MineDto dto);
	
	List<MineDto> minelist(String id);
	
	int updatemine(MineDto dto);
	
	int insertmine(MineDto dto);
	
	int deletemine(MineDto dto);
	
	int checkmine(MineDto dto);
	
	int stageinsert(MineDto dto);
	
	int stageupdate(MineDto dto);
	
	int queinsert(MineDto dto);
	
	int queupdate(MineDto dto);
	
	int updateanswer(MineAnswerDto dto);
	
	List<MineAnswerDto> answerlist(String mineid);
	
	int deleteanswer(int seq);

	
	
	int checknotice(String id);
	
	int insertnotice(String id);
	
	int answernum(String id);
	
	int noticeminenum(String id);
	
	int noticemineupdate(NoticeDto dto);
	
	int guestnum(String id);
	
	int noticebooknum(String id);
	
	int noticebookupdate(NoticeDto dto);
	
	
}
