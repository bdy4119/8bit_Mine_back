package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.FriendDto;

@Mapper
@Repository
public interface FriendDao {
	
	int acceptfriend(FriendDto dto);
	
	List<FriendDto> friendlist(String id);

	int deletefriend(int seq);
}
