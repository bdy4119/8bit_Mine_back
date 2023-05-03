package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.BgmDao;
import mul.cam.a.dto.BgmDto;

@Service
@Transactional
public class BgmService {
	
	@Autowired
	BgmDao dao;
	
	public boolean bgm_add(BgmDto dto) {
		return dao.bgm_add(dto)>0?true:false;
	}
	
	public List<BgmDto> bgm_list(String id) {
		return dao.bgm_list(id);
	}
	
	public BgmDto bgm_detail(int seq) {
		return dao.bgm_detail(seq);
	}
	
	public boolean bgm_del(int seq) {
		return dao.bgm_del(seq)>0?true:false;
	}
}



























