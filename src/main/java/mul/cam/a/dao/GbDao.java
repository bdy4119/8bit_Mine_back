package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.GbDto;


@Mapper
@Repository
public interface GbDao {
	
	int gb_add(GbDto dto);
	int gb_list_c(String toid);
	
	List<GbDto> gb_list(GbDto dto);
	List<GbDto> vi_list(GbDto dto);
	List<GbDto> gb_visit(GbDto dto);
	int gb_visit_c(GbDto dto);
	
	GbDto gb_detail(int seq);
	
	int gb_upd(GbDto dto);
	int gb_del(int seq);
}
