package mul.cam.a.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MineDao;
import mul.cam.a.dto.MineAnswerDto;
import mul.cam.a.dto.MineDto;
import mul.cam.a.dto.NoticeDto;

@Service
@Transactional
public class MineService {
	@Autowired
	MineDao dao;
	
	public MineDto mineData(MineDto dto) {
		System.out.println("mineData Service" + new Date());
		return dao.mineData(dto);
	}
	
	public List<MineDto> minelist(String id) {
		System.out.println("minelist Service" + new Date());
		return dao.minelist(id);
	}
	
	public boolean updatemine(MineDto dto) {
		int n = dao.updatemine(dto);
		
		return n>0?true:false;
	}
	
	public boolean insertmine(MineDto dto) {
		int n = dao.insertmine(dto);
		
		return n>0?true:false;
	}
	
	public boolean deletemine(MineDto dto) {
		int n = dao.deletemine(dto);
		
		return n>0?true:false;
	}
	
	public boolean checkmine(MineDto dto) {
		int n = dao.checkmine(dto);
		
		return n>0?true:false;
	}
	
	public boolean stageinsert(MineDto dto) {
		int n = dao.stageinsert(dto);
		
		return n>0?true:false;
	}
	
	public boolean stageupdate(MineDto dto) {
		int n = dao.stageupdate(dto);
		
		return n>0?true:false;
	}
	
	public boolean queinsert(MineDto dto) {
		int n = dao.queinsert(dto);
		
		return n>0?true:false;
	}
	
	public boolean queupdate(MineDto dto) {
		int n = dao.queupdate(dto);
		
		return n>0?true:false;
	}
	
	public boolean updateanswer(MineAnswerDto dto) {
		int n = dao.updateanswer(dto);
		
		return n>0?true:false;
	}
	
	public List<MineAnswerDto> answerlist(String mineid) {
		System.out.println("answerlist Service" + new Date());
		return dao.answerlist(mineid);
	}
	
	public boolean deleteanswer(int seq) {
		int n = dao.deleteanswer(seq);
		
		return n>0?true:false;
	}
	
	
	public boolean checknotice(String id) {
		int n = dao.checknotice(id);
		
		return n>0?true:false;
	}
	
	public boolean insertnotice(String id) {
		int n = dao.insertnotice(id);
		
		return n>0?true:false;
	}
	
	public int answernum(String id) {

		return dao.answernum(id);
	}
	
	public int noticeminenum(String id) {

		return dao.noticeminenum(id);
	}
	
	public boolean noticemineupdate(NoticeDto dto) {
		int n = dao.noticemineupdate(dto);
		
		return n>0?true:false;
	}
	
	public int guestnum(String id) {

		return dao.guestnum(id);
	}
	
	public int noticebooknum(String id) {

		return dao.noticebooknum(id);
	}
	
	public boolean noticebookupdate(NoticeDto dto) {
		int n = dao.noticebookupdate(dto);
		
		return n>0?true:false;
	}
}



























