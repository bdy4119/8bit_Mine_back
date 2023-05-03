package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.BgmDto;


@Mapper
@Repository
public interface BgmDao {
	
	int bgm_add(BgmDto dto);
	
	List<BgmDto> bgm_list(String id);
	BgmDto bgm_detail(int seq);
	
	int bgm_del(int seq);
}
