package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.SocialDto;


@Mapper
@Repository
public interface SocialDao {

	SocialDto social_sel(int seq);
	
	List<SocialDto> social_list(String owner);
	
	int social_add(SocialDto dto);
	
	int social_del(int seq);
	
	int social_upd(SocialDto dto);
}
