package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.LoginDto;

@Mapper
@Repository
public interface LoginDao {
	String emailCheck(String email);
	
	int regiUser(String id, String email, String social, String jwt);
	
	String getId(String token);
	
	int withdrawalUser(String id);
	
	String getJwt(String email);
	
	String jwtCheck(String token);
	
	LoginDto showUser(String token);
	
	int editUser(String name, String token);
	
	int authCheck(String token);
	
	List<LoginDto> userList();
}
