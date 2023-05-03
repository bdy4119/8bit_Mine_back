package mul.cam.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.dao.IDao;
import mul.cam.a.dto.IDto;
import mul.cam.a.dto.QnaDto;


@Service
@Transactional
public class IService {
	@Autowired
	IDao dao;
	
	public void i_add(IDto dto) {
		dao.i_add(dto);
	}
	
	public boolean i_add_classi(IDto dto) {
		return dao.i_add_classi(dto)>0?true:false;
	}
	
	public List<IDto> i_classi_list(String id) {
		return dao.i_classi_list(id);
	}
	
	public List<IDto> i_detail(IDto dto) {
		return dao.i_detail(dto);
	}
	
	public boolean i_del(IDto dto) {
		return dao.i_del(dto)>0?true:false;
	}
	
	public boolean i_del_classi(IDto dto) {
		return dao.i_del_classi(dto)>0?true:false;
	}
	
	public boolean i_add_qna(QnaDto dto) {
		return dao.i_add_qna(dto)>0?true:false;
	}
	
	public void i_del_qna(String id) {
		dao.i_del_qna(id);
	}
	
	public QnaDto i_qna(String id) {
		return dao.i_qna(id);
	}
}



























