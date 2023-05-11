package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.GbDto;


@Mapper
@Repository
public interface GbDao {
	
	int gb_add(GbDto dto);
	
	List<GbDto> gb_list(String id);
	List<GbDto> gb_visit(GbDto dto);
	GbDto gb_detail(int seq);
	
	int gb_upd(GbDto dto);
	int gb_del(int seq);
}
