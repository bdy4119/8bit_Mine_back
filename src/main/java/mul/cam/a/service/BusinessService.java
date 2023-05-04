package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.BusinessDao;
import mul.cam.a.dto.BusinessBackDto;
import mul.cam.a.dto.BusinessDto;

@Service
@Transactional
public class BusinessService {
	@Autowired
	BusinessDao dao;
	
	
	/* 명함 앞면  */
	public List<BusinessDto> businesscard(BusinessDto dto) {
		return dao.businesscard(dto);
	}
	
	//명함 상세보기
	public BusinessDto businessDetail(String id) {
		return dao.businessDetail(id);
	}
	
	public boolean writeBusiness(BusinessDto dto) {
		int n = dao.writeBusiness(dto);
		return n>0?true:false;
	}
	
	
	public boolean updateBusiness(BusinessDto dto) {
		int n = dao.updateBusiness(dto);
		return n>0?true:false;
	}
	
	public void deleteBusiness(int seq) {
		dao.deleteBusiness(seq);
	}
	
	
	
	
	/* 명함 뒷면  */
	public List<BusinessBackDto> businesscardB(BusinessBackDto dto) {
		return dao.businesscardB(dto);
	}
	
	public void backDel(int seq) {
		dao.backDel(seq);
	}
	
	public boolean backUpdate(BusinessBackDto dto) {
		int n = dao.backUpdate(dto);
		return n>0?true:false;
	}
	
	//상세보기
	public BusinessBackDto backDetail(int seq) {
		return dao.backDetail(seq);
	}
	
	public boolean backWrite(BusinessBackDto dto) {
		int n = dao.backWrite(dto);
		return n>0?true:false;
	}
	
	

	
	
}
