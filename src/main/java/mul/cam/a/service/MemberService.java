package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.MemberDao;
import mul.cam.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
	@Autowired
	MemberDao dao;
	
	public List<MemberDto> allmember() {
		return dao.allmember();
	}
	
	public boolean idcheck(String id) {
		String userid = dao.idcheck(id);
		
		if (userid != null && !userid.equals("")) {
			return true;
		}
		
		return false;
	}
	
	public boolean addmemeber(MemberDto dto) {
		int n = dao.addmember(dto);
		
		return n>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
}



























