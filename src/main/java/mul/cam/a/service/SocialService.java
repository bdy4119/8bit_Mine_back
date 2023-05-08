package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.SocialDao;
import mul.cam.a.dto.SocialDto;


@Service
@Transactional
public class SocialService {
	
	@Autowired
	SocialDao dao;

	public SocialDto social_sel(int seq) {
		return dao.social_sel(seq);
	}
	
	public List<SocialDto> social_list(String owner) {
		return dao.social_list(owner);
	}
	
	public boolean social_add(SocialDto dto) {
		return dao.social_add(dto)>0?true:false;
	}
	
	public boolean social_del(int seq) {
		return dao.social_del(seq)>0?true:false;
	}
	
	public boolean social_upd(SocialDto dto) {
		return dao.social_upd(dto)>0?true:false;
	}
}



























