package mul.cam.a.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.FriendDao;
import mul.cam.a.dto.FriendDto;

@Service
@Transactional
public class FriendService {
	
	@Autowired
	FriendDao dao;
	
	public boolean acceptfriend(FriendDto dto) {
		int n = dao.acceptfriend(dto);
		
		return n>0?true:false;
	}
	
	public List<FriendDto> friendlist(FriendDto dto) {
		System.out.println("friendlist Service" + new Date());
		
		return dao.friendlist(dto);
	}
	
	public int friendCount(String id) {
		
		return dao.friendCount(id);
	}
	
	public boolean deletefriend(int seq) {
		int n = dao.deletefriend(seq);
		
		return n>0?true:false;
	}

}
