package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.MineDto;
import mul.cam.a.dto.MineDto;

@Mapper
@Repository
public interface MineDao {
	
	MineDto mineData(int position);
	
	List<MineDto> minelist(String id);
	
	int updatemine(MineDto dto);
	
	int insertmine(MineDto dto);
	
	int deletemine(MineDto dto);
	
	int checkmine(MineDto dto);
	
	int stageinsert(MineDto dto);
	
	int stageupdate(MineDto dto);
	
	int queinsert(MineDto dto);
	
	int queupdate(MineDto dto);
	

}
