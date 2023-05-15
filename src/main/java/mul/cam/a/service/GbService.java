package mul.cam.a.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.GbDao;
import mul.cam.a.dto.GbDto;


@Service
@Transactional
public class GbService {
	
	@Autowired
	GbDao dao;
	
	public boolean gb_add(GbDto dto) {
		return dao.gb_add(dto)>0?true:false;
	}
	
	public int gb_list_c(String toid) {
		return dao.gb_list_c(toid);
	}
	
	public List<GbDto> gb_list(GbDto dto) {
		return dao.gb_list(dto);
	}
	
	public List<GbDto> vi_list(GbDto dto) {
		return dao.vi_list(dto);
	}
	
	public List<GbDto> gb_visit(GbDto dto) {
		return dao.gb_visit(dto);
	}
	
	public int gb_visit_c(GbDto dto) {
		return dao.gb_visit_c(dto);
	}
	
	
	public GbDto gb_detail(int seq) {
		return dao.gb_detail(seq);
	}
	
	public boolean gb_upd(GbDto dto) {
		return dao.gb_upd(dto)>0?true:false;
	}
	
	public boolean gb_del(int seq) {
		System.out.println("serv del() : " + new Date());
		
		return dao.gb_del(seq)>0?true:false;
	}
}



























