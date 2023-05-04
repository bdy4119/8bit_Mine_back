package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.LoginDao;
import mul.cam.a.dto.LoginDto;

@Service
@Transactional
public class LoginService {
	@Autowired
	LoginDao dao;
	
	public boolean emailCheck(String email) {
		String userEmail = dao.emailCheck(email);
		
		if (userEmail == null || userEmail.equals("")) {
			return true;
		}
		
		return false;
	}
	
	public boolean regiUser(String id, String email, String social, String jwt) {
		int i = dao.regiUser(id, email, social, jwt);
		
		return i>0?true:false;
	}
	
	public String getId(String token) {
		return dao.getId(token);
	}
	
	public boolean withdrawalUser(String id) {
		int i = dao.withdrawalUser(id);
		
		return i>0?true:false;
	}
	
	public String getJwt(String email) {
		return dao.getJwt(email);
	}
	
	public boolean jwtCheck(String token) {
		if (dao.jwtCheck(token).equals(token)) {
			return true;
		}
		
		return false;
	}
	
	public LoginDto showUser(String token) {
		return dao.showUser(token);
	}
	
	public boolean editUser(String name, String token) {
		int i = dao.editUser(name, token);
		
		return i>0?true:false;
	}
	
	public int authCheck(String token) {
		return dao.authCheck(token);
	}
	
	public List<LoginDto> userList() {
		return dao.userList();
	}
}
