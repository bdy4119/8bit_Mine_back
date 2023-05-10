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
	
	public boolean regiUser(String id, String email, String social, String jwt,
			String profPic, String profMsg, String job, String birthdate, String address) {
		int i = dao.regiUser(id, email, social, jwt, profPic, profMsg, job, birthdate, address);
		
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
	
	public boolean editUser(LoginDto dto) {
		int i = dao.editUser(dto);
		
		return i>0?true:false;
	}
	
	public boolean editUser_n(LoginDto dto) {
		int i = dao.editUser_n(dto);
		
		return i>0?true:false;
	}
	
	public boolean editUser_nc(LoginDto dto) {
		int i = dao.editUser_nc(dto);
		
		return i>0?true:false;
	}
	
	public int authCheck(String token) {
		return dao.authCheck(token);
	}
	
	public List<LoginDto> userList() {
		return dao.userList();
	}
	
	public boolean updateState(LoginDto dto) {
		int i = dao.updateState(dto);
		
		return i>0?true:false;
	}
	
	public List<LoginDto> searchList(String search) {
		return dao.searchList(search);
	}
	
	public LoginDto getDto(String email) {
		return dao.getDto(email);
	}
}
