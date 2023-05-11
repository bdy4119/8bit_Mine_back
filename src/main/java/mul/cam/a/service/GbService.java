package mul.cam.a.service;

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
	
	public List<GbDto> gb_list(String id) {
		return dao.gb_list(id);
	}
	
	public List<GbDto> gb_visit(GbDto dto) {
		return dao.gb_visit(dto);
	}
	
	public GbDto gb_detail(int seq) {
		return dao.gb_detail(seq);
	}
	
	public boolean gb_upd(GbDto dto) {
		return dao.gb_upd(dto)>0?true:false;
	}
	
	public boolean gb_del(int seq) {
		return dao.gb_del(seq)>0?true:false;
	}
}



























