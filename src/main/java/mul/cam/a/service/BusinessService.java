package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.BusinessDao;
import mul.cam.a.dto.BusinessDto;

@Service
@Transactional
public class BusinessService {
	@Autowired
	BusinessDao dao;
	
	public List<BusinessDto> businesscard(BusinessDto dto) {
		return dao.businesscard(dto);
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
	
}
