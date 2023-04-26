package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.BusinessBackDto;
import mul.cam.a.dto.BusinessDto;
import mul.cam.a.dto.TodoDto;

@Mapper
@Repository
public interface BusinessDao {
	
	/* 명함 앞면  */
	//명함정보 리스트
	List<BusinessDto> businesscard(BusinessDto dto);
	
	//명함 상세보기
	BusinessDto businessDetail(String id);
	
	//글쓰기
	int writeBusiness(BusinessDto dto);
		
	//수정
	int updateBusiness(BusinessDto dto);
		
	//삭제
	public void deleteBusiness(int seq);
	/* 명함 앞면 end */
	
	
	
	
	
	/* 명함 뒷면  */
	List<BusinessBackDto> businesscardB(BusinessBackDto dto);
	
	//삭제
	public void backDel(int seq);
	
	//수정
	int backUpdate(BusinessBackDto dto);
	
	//상세보기
	BusinessBackDto backDetail(int seq);
}
