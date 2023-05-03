package mul.cam.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.dto.IDto;
import mul.cam.a.dto.QnaDto;


@Mapper
@Repository
public interface IDao {
	
	int i_add(IDto dto);
	
	int i_add_classi(IDto dto);
	
	List<IDto> i_classi_list(String id);
	
	List<IDto> i_detail(IDto dto);
	
	int i_del(IDto dto);
	int i_del_classi(IDto dto);
	
	int i_add_qna(QnaDto dto);
	int i_del_qna(String id);
	QnaDto i_qna(String id);
	
}
