package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.BusinessDto;
import mul.cam.a.dto.TodoDto;

@Mapper
@Repository
public interface BusinessDao {
	
	//todo리스트
	List<BusinessDto> businesscard(BusinessDto dto);
	
	//todo 글쓰기
	int writeBusiness(BusinessDto dto);
		
	//todo 수정
	int updateBusiness(BusinessDto dto);
		
	//todo 삭제
	public void deleteBusiness(int seq);
	
}
