package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.LoginDto;

@Mapper
@Repository
public interface LoginDao {
	String emailCheck(String email);
	
	int regiUser(String id, String email, String social, String jwt,
			String profPic, String profMsg, String job, String birthdate, String address);
	
	String getId(String token);
	
	int withdrawalUser(String id);
	
	String getJwt(String email);
	
	String jwtCheck(String token);
	
	LoginDto showUser(String token);
	
	int editUser(LoginDto dto);
	
	int authCheck(String token);
	
	List<LoginDto> userList();
	
	int updateState(LoginDto dto);
	
	List<LoginDto> searchList(String search);
}
